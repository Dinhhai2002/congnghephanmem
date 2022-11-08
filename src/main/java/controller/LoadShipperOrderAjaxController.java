package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDetailDao;
import dao.ShopDao;
import entity.OrderDetail;
import entity.Shop;
import entity.User;

@WebServlet(urlPatterns = {"/shipper/loadshipperorder"})
public class LoadShipperOrderAjaxController extends HttpServlet{
	OrderDetailDao orderDetailDao = new OrderDetailDao();
	ShopDao shopDao = new ShopDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		//tam thoi load ra 6 san pham truoc
		String amount = req.getParameter("exits");
		String action = req.getParameter("action");
		HttpSession httpSession = req.getSession();
		User acc = (User) httpSession.getAttribute("acc");
		int iamount = Integer.parseInt(amount);
		if (action == null) {
			List<OrderDetail> listO = orderDetailDao.findAllByStatus(7);
			displayHTML(listO, resp);
		} else {
			action = action.replaceAll("\\s\\s+", " ").trim();
			if (action.equals("Nhận đơn")) {
				List<OrderDetail> listO = orderDetailDao.findAllByStatus(7);
				displayHTML(listO, resp);
			}

			if (action.equals("Chờ lấy hàng")) {
				List<OrderDetail> listO = orderDetailDao.findAllByStatusOfShipper(acc, 2);
				displayHTML(listO, resp);
			}

			if (action.equals("Chờ đi giao")) {
				List<OrderDetail> listO = orderDetailDao.findAllByStatusOfShipper(acc, 3);
				List<OrderDetail> list = orderDetailDao.findAllByStatusOfShipper(acc, 8);
				listO.addAll(list);
				displayHTML(listO, resp);
			}

			if (action.equals("Đã giao")) {
				List<OrderDetail> listO = orderDetailDao.findAllByStatusOfShipper(acc, 4);
				List<OrderDetail> list = orderDetailDao.findAllByStatusOfShipper(acc, 9);
				listO.addAll(list);
				displayHTML(listO, resp);
			}

			if (action.equals("Khách không nhận")) {
				List<OrderDetail> listO = orderDetailDao.findAllByStatusOfShipper(acc, 6);
				displayHTML(listO, resp);
			}
		}
	}

	private void displayHTML(List<OrderDetail> listO, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		for (OrderDetail x : listO) {
			String html="";
			int s = x.getStatus().getIdStatus();
			if(s==7) {
				html += "<td><button id=\"orderStatus\" onclick=\"editStatus(this, "+x.getOrder().getOrderId()+")\" value=\"${result[i].id}\">Nhận đơn</button></td>";
			}
			if (s == 2) {
				html += "<td><button id=\"orderStatus\" onclick=\"editStatus(this, "+x.getOrder().getOrderId()+")\" value=\"${result[i].id}\">Xác nhận lấy hàng</button></td>";			
			}
			if (s == 3) {
				html += "<td><button id=\"orderStatus\" onclick=\"editStatus(this, "+x.getOrder().getOrderId()+")\" value=\"${result[i].id}\">Xác nhận đã giao</button></td>";
				html += "<td><button id=\"orderStatus\" onclick=\"editStatus(this, "+x.getOrder().getOrderId()+")\" value=\"${result[i].id}\">Khách không nhận</button></td>";
			}
			
			out.println("<tr style=\"margin: 8px 0;\">\n"
					+   "<td>"+x.getOrder().getUser().getuName()+"</td>"
					+   "<td>"+x.getProduct().getpName()+"</td>"
					+   "<td><img style=\"width:90px; height:90px;\" src=\""+x.getProduct().getpImage()+"\"></td>"
					+   "<td>"+x.getTotalPrice()+"</td>"
					+   "<td>"+x.getStatus().getNameStatus()+"</td>"
					+   html
					+   "</tr>" 
					);

		}
	}
}

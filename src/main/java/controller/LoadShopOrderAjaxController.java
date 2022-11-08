package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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


@WebServlet(urlPatterns = {"/shop-manager/loadshoporder"})
public class LoadShopOrderAjaxController extends HttpServlet{
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
		int shopId = shopDao.getShopIdByuId(acc.getuId());
		Shop shop = shopDao.findOne(shopId);
		int iamount = Integer.parseInt(amount);
		if (action == null) {
			List<OrderDetail> listO = orderDetailDao.findNext3OrderOfShop(shop, iamount);
			displayHTML(listO, resp);
		} else {
			action = action.replaceAll("\\s\\s+", " ").trim();
			
			if (action.equals("Tất cả")) {
				List<OrderDetail> listO = orderDetailDao.findNext3OrderOfShop(shop, iamount);
				displayHTML(listO, resp);
			}

			if (action.equals("Chờ xác nhận")) {
				List<OrderDetail> listO = orderDetailDao.findNext3ShopOrderByStatus(shop, 1, iamount);
				displayHTML(listO, resp);
			}
			
			if (action.equals("Chờ shipper nhận đơn")) {
				List<OrderDetail> listO = orderDetailDao.findNext3ShopOrderByStatus(shop, 7, iamount);
				displayHTML(listO, resp);
			}

			if (action.equals("Chờ lấy hàng")) {
				List<OrderDetail> listO = orderDetailDao.findNext3ShopOrderByStatus(shop, 2, iamount);
				displayHTML(listO, resp);
			}

			if (action.equals("Đang giao")) {
				List<OrderDetail> listO = orderDetailDao.findNext3ShopOrderByStatus(shop, 3, iamount);
				displayHTML(listO, resp);
			}

			if (action.equals("Đã giao")) {
				List<OrderDetail> listO = orderDetailDao.findAllByStatusOfShop(shop, 4);
				List<OrderDetail> list = orderDetailDao.findAllByStatusOfShop(shop, 9);
				listO.addAll(list);
				displayHTML(listO, resp);
			}
			
			if (action.equals("Khách trả hàng")) {
				List<OrderDetail> listO = orderDetailDao.findAllByStatusOfShop(shop, 6);
				displayHTML(listO, resp);
			}

			if (action.equals("Đã từ chối")) {
				List<OrderDetail> listO = orderDetailDao.findNext3OrderByStatus(acc, 10, iamount);
				displayHTML(listO, resp);
			}
		}
	}

	private void displayHTML(List<OrderDetail> listO, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		for (OrderDetail x : listO) {
			String html="";
			int s = x.getStatus().getIdStatus();
			if (s == 1) {
				html += "<td><button id=\"orderStatus\" onclick=\"editStatus(this)\" value=\"${result[i].id}\">Chốt đơn</button></td>";
				html += "<td><button id=\"orderStatus\" onclick=\"editStatus(this)\" value=\"${result[i].id}\">Từ chối</button></td>";
			}
			if (s == 8) {
				html += "<td><button id=\"orderStatus\" onclick=\"editStatus(this)\">Shipper đã lấy hàng</button></td>";			
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

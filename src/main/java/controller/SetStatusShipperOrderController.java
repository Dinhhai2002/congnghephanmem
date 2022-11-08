package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDetailDao;
import entity.OrderDetail;
import entity.User;

@WebServlet(urlPatterns = {"/statusshipperorder"})
public class SetStatusShipperOrderController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		String orderId = req.getParameter("orderId");
		String id = req.getParameter("id");
		String statusName = req.getParameter("statusName");
		int orderID = Integer.parseInt(orderId);
		int sid = Integer.parseInt(id);
		HttpSession httpSession = req.getSession();
		User acc = (User) httpSession.getAttribute("acc");
		OrderDetailDao orderDetailDao = new OrderDetailDao();
		String html="";
		if(statusName.equals("Nhận đơn")) {
			html+="<td>Nhận thành công</td>";
			orderDetailDao.updateShipper(acc, orderID);
			orderDetailDao.update(sid, 2);
			displayHTML(sid, html, resp);
		}
		
		if(statusName.equals("Xác nhận đã giao")) {
			html+="<td>Đã xác nhận</td>";
			orderDetailDao.update(sid, 4);
			displayHTML(sid, html, resp);
		}
		
		if(statusName.equals("Xác nhận lấy hàng")) {
			html+="<td>Lấy hàng thành công</td>";
			orderDetailDao.update(sid, 8);
			displayHTML(sid, html, resp);
		}
		
		if(statusName.equals("Khách không nhận")) {
			html+="<td>Khách trả hàng</td>";
			orderDetailDao.update(sid, 6);
			displayHTML(sid, html, resp);
		}
	}

	private void displayHTML(int id, String html, HttpServletResponse resp) throws ServletException, IOException {
		OrderDetailDao orderDetailDao = new OrderDetailDao();
		OrderDetail x = orderDetailDao.findOne(id);		
		PrintWriter out = resp.getWriter();
			out.println("<tr style=\"margin: 8px 0;\">\n"
					+   "<td>"+x.getOrder().getUser().getuName()+"</td>"
					+   "<td>"+x.getProduct().getpName()+"</td>"
					+   "<td><img style=\"width:90px; height:90px;\" src=\""+x.getProduct().getpImage()+"\"></td>"
					+   "<td>"+x.getTotalPrice()+"</td>"
					+   html
					+   "</tr>" 
					);
		}
}

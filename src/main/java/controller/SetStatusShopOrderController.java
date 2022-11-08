package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDetailDao;
import entity.OrderDetail;

@WebServlet(urlPatterns = {"/statusshoporder"})
public class SetStatusShopOrderController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String statusName = req.getParameter("statusName");
		int sid = Integer.parseInt(id);
		OrderDetailDao orderDetailDao = new OrderDetailDao();
		String html="";
		if(statusName.equals("Từ chối")) {
			html+="<td>Đã từ chối đơn</td>";
			orderDetailDao.update(sid, 11);
			displayHTML(sid, html, resp);
		}
		
		if(statusName.equals("Chốt đơn")) {
			html+="<td>Đơn đã chốt</td>";
			orderDetailDao.update(sid, 7);
			displayHTML(sid, html, resp);
		}
		
		if(statusName.equals("Xác nhận shipper lấy hàng")) {
			html+="<td>Đã xác nhận</td>";
			orderDetailDao.update(sid, 3);
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

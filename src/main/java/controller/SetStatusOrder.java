package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.OrderDetail;
import dao.OrderDetailDao;

@WebServlet(urlPatterns = { "/member/statusorder" })
public class SetStatusOrder extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String statusName = req.getParameter("statusName");
		int sid = Integer.parseInt(id);
		OrderDetailDao orderDetailDao = new OrderDetailDao();
		String html="";
		if(statusName.equals("Hủy đơn")) {
			html+="<td>Đã hủy</td>";
			orderDetailDao.update(sid, 5);
			displayHTML(sid, html, resp);
		}
		
		if(statusName.equals("Đã nhận được hàng")) {
			html+="<td>Đã nhận</td>";
			orderDetailDao.update(sid, 9);
			displayHTML(sid, html, resp);
		}	
		
	}
	private void displayHTML(int id,String html, HttpServletResponse resp) throws ServletException, IOException {
		OrderDetailDao orderDetailDao = new OrderDetailDao();
		OrderDetail x = orderDetailDao.findOne(id);		
		PrintWriter out = resp.getWriter();
			out.println("<tr style=\"margin: 8px 0;\">\n"
					+   "<td>"+x.getProduct().getpName()+"</td>"
					+   "<td><img style=\"width:90px; height:90px;\" src=\""+x.getProduct().getpImage()+"\"></td>"
					+   "<td>"+x.getTotalPrice()+"</td>"
					+   html
					+   "</tr>" 
					);
		}
}

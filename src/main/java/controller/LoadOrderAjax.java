package controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dao.OrderDetailDao;
import entity.OrderDetail;
import entity.User;

@WebServlet(urlPatterns = { "/member/loadorder" })
public class LoadOrderAjax extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		//tam thoi load ra 3 san pham truoc
		String amount = req.getParameter("exits");
		String action = req.getParameter("action");
		HttpSession httpSession = req.getSession();
		Object user = httpSession.getAttribute("acc");
		OrderDetailDao orderDetailDao = new OrderDetailDao();
		User acc = (User) user;
		int iamount = Integer.parseInt(amount);
		if (action == null) {
			List<OrderDetail> listO = orderDetailDao.findNext3OrderOfUser(acc, iamount);
			displayHTML(listO, resp);
		} else {
			action = action.replaceAll("\\s\\s+", " ").trim();
			
			if (action.equals("Tất cả")) {
				List<OrderDetail> listO = orderDetailDao.findNext3OrderOfUser(acc, iamount);
				displayHTML(listO, resp);
			}

			if (action.equals("Chờ xác nhận")) {
				List<OrderDetail> listO = orderDetailDao.findNext3OrderByStatus(acc, 1, iamount);
				List<OrderDetail> list = orderDetailDao.findNext3OrderByStatus(acc, 7, iamount);
				listO.addAll(list);
				displayHTML(listO, resp);
			}

			if (action.equals("Chờ lấy hàng")) {
				List<OrderDetail> listO = orderDetailDao.findNext3OrderByStatus(acc, 2, iamount );
				displayHTML(listO, resp);
			}

			if (action.equals("Đang giao")) {
				List<OrderDetail> listO = orderDetailDao.findNext3OrderByStatus(acc, 3, iamount );
				displayHTML(listO, resp);
			}

			if (action.equals("Đã giao")) {
				List<OrderDetail> listO = orderDetailDao.findNext3OrderByStatus(acc, 4, iamount );
				displayHTML(listO, resp);
			}

			if (action.equals("Đã hủy")) {
				List<OrderDetail> listO = orderDetailDao.findNext3OrderByStatus(acc, 5, iamount );
				displayHTML(listO, resp);
			}
		}	
	}
	private void displayHTML(List<OrderDetail> listO, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		for (OrderDetail x : listO) {
			String html="";
			int s = x.getStatus().getIdStatus();
			if (s == 1 || s==7) {
				html += "<td>Chờ xác nhận</td>";
				html += "<td><button id=\"orderStatus\" onclick=\"editStatus(this)\">Hủy đơn</button></td>";
			}else if (s == 3) {
				html += "<td>"+x.getStatus().getNameStatus()+"</td>";
				html += "<td><button id=\"orderStatus\" onclick=\"editStatus(this)\">Đã nhận được hàng</button></td>";
				html += "<td><button id=\"orderStatus\" onclick=\"editStatus(this)\">Hủy đơn</button></td>";
			}else if (s == 4 || s == 5) {
				html += "<td>"+x.getStatus().getNameStatus()+"</td>";
				html += "<td><button id=\"orderStatus\" onclick=\"editStatus(this)\">Mua lại</button></td>";
			}else {
				html += "<td>"+x.getStatus().getNameStatus()+"</td>";
			}
			out.println("<tr style=\"margin: 8px 0;\">\n"
					+   "<td>"+x.getProduct().getpName()+"</td>"
					+   "<td><img style=\"width:90px; height:90px;\" src=\""+x.getProduct().getpImage()+"\"></td>"
					+   "<td>"+x.getTotalPrice()+"</td>"
					+   html
					+   "</tr>" 
					);

		}
	}
}



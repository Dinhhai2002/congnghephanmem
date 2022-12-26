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
import dao.UserDao;
import entity.OrderDetail;
import entity.User;

@WebServlet(urlPatterns = { "/member/purchase" })
public class OrderPurchase extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String action = req.getParameter("action");
		OrderDetailDao orderDetailDao = new OrderDetailDao();
		HttpSession httpSession = req.getSession();
		Object user = httpSession.getAttribute("acc");
		User acc = (User) user;
		if (action == null) {
			List<OrderDetail> listO = orderDetailDao.findAllByuid(acc);
			req.setAttribute("listO", listO);
			req.setAttribute("choxacnhan", orderDetailDao.count(1));
			req.setAttribute("cholayhang", orderDetailDao.count(2));
			req.setAttribute("danggiao", orderDetailDao.count(3));		
			RequestDispatcher rq = req.getRequestDispatcher("/views/StoreProduct.jsp");
			rq.forward(req, resp);
		} else {
			action = action.replaceAll("\\s\\s+", " ").trim();
			if (action.equals("Tất cả")) {
				List<OrderDetail> listO = orderDetailDao.findAllByuid(acc);
				displayHTML(listO, resp);
			}

			if (action.equals("Chờ xác nhận")) {
				List<OrderDetail> listO = orderDetailDao.findAllByStatusOfUser(acc, 1);
				List<OrderDetail> list = orderDetailDao.findAllByStatusOfUser(acc, 7);
				listO.addAll(list);
				displayHTML(listO, resp);
			}

			if (action.equals("Chờ lấy hàng")) {
				List<OrderDetail> listO = orderDetailDao.findAllByStatusOfUser(acc, 2);
				displayHTML(listO, resp);
			}

			if (action.equals("Đang giao")) {
				List<OrderDetail> listO = orderDetailDao.findAllByStatusOfUser(acc, 3);
				List<OrderDetail> list = orderDetailDao.findAllByStatusOfUser(acc, 4);
				listO.addAll(list);
				displayHTML(listO, resp);
			}

			if (action.equals("Đã giao")) {
				List<OrderDetail> listO = orderDetailDao.findAllByStatusOfUser(acc, 9);
				displayHTML(listO, resp);
			}

			if (action.equals("Đã hủy")) {
				List<OrderDetail> listO = orderDetailDao.findAllByStatusOfUser(acc, 5);
				displayHTML(listO, resp);
			}

		}
	}

	private void displayHTML(List<OrderDetail> listO, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		OutputStream outputStream = resp.getOutputStream();
		Gson gson = new Gson();
		outputStream.write(gson.toJson(listO).getBytes());
		outputStream.flush();
	}

}

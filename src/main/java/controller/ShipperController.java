package controller;

import java.io.IOException;
import java.io.OutputStream;
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
import dao.ShopDao;
import entity.OrderDetail;
import entity.Shop;
import entity.User;

@WebServlet(urlPatterns = {"/admin/shipper/order"})
public class ShipperController extends HttpServlet{
	OrderDetailDao orderDetailDao = new OrderDetailDao();
	ShopDao shopDao = new ShopDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String action = req.getParameter("action");
		
		HttpSession httpSession = req.getSession();
		User acc = (User) httpSession.getAttribute("acc");
		if (action == null) {
			List<OrderDetail> listO = orderDetailDao.findAllByStatus(7);
			req.setAttribute("listO", listO);
			RequestDispatcher rq = req.getRequestDispatcher("/views/ShipperAdmin.jsp");
			rq.forward(req, resp);
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
		resp.setContentType("application/json");
		OutputStream outputStream = resp.getOutputStream();
		Gson gson = new Gson();
		outputStream.write(gson.toJson(listO).getBytes());
		outputStream.flush();
	}
}

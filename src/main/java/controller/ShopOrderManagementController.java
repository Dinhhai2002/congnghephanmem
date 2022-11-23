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

@WebServlet(urlPatterns = {"/admin/shop-manager/order"})
public class ShopOrderManagementController extends HttpServlet {
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
		int shopId = shopDao.getShopIdByuId(acc.getuId());
		Shop shop = shopDao.findOne(shopId);
		if (action == null) {
			List<OrderDetail> listO = orderDetailDao.findAllByShopId(shop);
			req.setAttribute("listO", listO);
			RequestDispatcher rq = req.getRequestDispatcher("/views/AdminManager.jsp");
			rq.forward(req, resp);
		} else {
			action = action.replaceAll("\\s\\s+", " ").trim();
			if (action.equals("Tất cả")) {
				List<OrderDetail> listO = orderDetailDao.findAllByShopId(shop);
				displayHTML(listO, resp);
			}

			if (action.equals("Chờ xác nhận")) {
				List<OrderDetail> listO = orderDetailDao.findAllByStatusOfShop(shop, 1);
				displayHTML(listO, resp);
			}
			
			if (action.equals("Chờ shipper nhận đơn")) {
				List<OrderDetail> listO = orderDetailDao.findAllByStatusOfShop(shop, 7);
				List<OrderDetail> list = orderDetailDao.findAllByStatusOfShop(shop, 8);
				listO.addAll(list);
				displayHTML(listO, resp);
			}

			if (action.equals("Chờ lấy hàng")) {
				List<OrderDetail> listO = orderDetailDao.findAllByStatusOfShop(shop, 2);
				displayHTML(listO, resp);
			}

			if (action.equals("Đang đi giao")) {
				List<OrderDetail> listO = orderDetailDao.findAllByStatusOfShop(shop, 3);
				displayHTML(listO, resp);
			}

			if (action.equals("Đã đi giao")) {
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
				List<OrderDetail> listO = orderDetailDao.findAllByStatusOfShop(shop, 10);
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

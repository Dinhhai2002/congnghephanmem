package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDao;
import dao.CartItemDao;
import entity.CartItem;
@WebServlet(urlPatterns={"/member/cart-remove"})
public class CartItemRemoveController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		//Lấy tham số từ JSP
		String pId = req.getParameter("pId");
		CartItemDao cartItemDao = new CartItemDao();
		CartDao cartDao = new CartDao();
		
		HttpSession httpSession = req.getSession();
		Object obj = httpSession.getAttribute("cart");//đọc từ session ra
		if(obj != null) {
			@SuppressWarnings("unchecked")
			Map<Integer, CartItem> map = (Map<Integer, CartItem>) obj; //ép về kiểm của
			//Xóa sản phẩm trong map
			map.remove(Integer.parseInt(pId));
			cartItemDao.delete(Integer.parseInt(pId));
			cartDao.delete();
			//Cập nhật lại session
			httpSession.setAttribute("cart", map);
		}
		resp.sendRedirect(req.getContextPath()+"/member/cart");
		
	}
	

}

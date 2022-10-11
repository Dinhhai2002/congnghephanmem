package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDao;
import dao.CartItemDao;
import entity.Cart;
import entity.CartItem;

@WebServlet(urlPatterns={"/member/cart-quantityincdec"})
public class QuantityIncDecController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		//Lấy tham số từ JSP
		String action = req.getParameter("action");
		String pId = req.getParameter("pId");		
		HttpSession httpSession = req.getSession();
		Object obj = httpSession.getAttribute("cart");
		CartItemDao cartItemDao = new CartItemDao();
		CartDao cartDao = new CartDao();
		
		if(obj != null) {
			@SuppressWarnings("unchecked")
			Map<Integer, CartItem> map = (Map<Integer, CartItem>) obj; //ép về kiểu của map
			CartItem existedCartItem = map.get(Integer.valueOf(pId));
			if(action.equals("add")) {
			existedCartItem.setCount(existedCartItem.getCount() + 1);
			
			
			} else {
				if (existedCartItem.getCount()==1) {
					map.remove(Integer.parseInt(pId));
					cartItemDao.delete(Integer.parseInt(pId));
					cartDao.delete();
					}
				existedCartItem.setCount(existedCartItem.getCount() - 1);
				}
			
			
			existedCartItem.setTotalPrice(existedCartItem.getCount()*existedCartItem.getProduct().getpPrice());
			cartItemDao.update(existedCartItem);
			//Cập nhật lại session
			httpSession.setAttribute("cart", map);
		}
		resp.sendRedirect(req.getContextPath()+"/member/cart");
	}
	
}

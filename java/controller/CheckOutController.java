package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.CartItem;
import entity.User;

@WebServlet(urlPatterns={"/member/checkout"})
public class CheckOutController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		
		HttpSession httpSession = req.getSession();
		Object obj = httpSession.getAttribute("acc");
		Object obj1 = httpSession.getAttribute("cart");
		
		User acc = (User) obj; //ép về kiểm của
		Map<Integer, CartItem> map = (Map<Integer, CartItem>) obj1;
		
		httpSession.setAttribute("cart", map);
		httpSession.setAttribute("acc", acc);		
		
		req.getRequestDispatcher("/views/checkout.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}

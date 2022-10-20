package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDao;
import dao.CartItemDao;
import entity.CartItem;
import entity.Category;
import entity.Product;

@WebServlet(urlPatterns = { "/member/cart" })
public class CartController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		Object obj = httpSession.getAttribute("acc");
		if (obj == null) {	
			resp.sendRedirect(req.getContextPath() + "/login");	
		}else {
			RequestDispatcher rq=req.getRequestDispatcher("/views/cart.jsp");
			rq.forward(req, resp);
		}		
	}

	@SuppressWarnings("unchecked")
	private Map<Integer, CartItem> extracted(Object obj) {
		return (Map<Integer, CartItem>) obj;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}

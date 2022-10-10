package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartItemDao;
import dao.DAO;
import entity.CartItem;
import entity.User;

@WebServlet(urlPatterns = "/login")

public class loginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String pass = req.getParameter("password");

		CartItemDao cartItemDao = new CartItemDao();
		DAO dao = new DAO();
		User a = dao.Login(username, pass);
		if (username != null && pass != null) {
			if (a == null) {
				req.setAttribute("mess", "Bạn đã nhập sai mật khẩu hoặc tên người dùng");
				req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			} else {
				HttpSession session=req.getSession();
				session.setAttribute("acc", a);
				List<CartItem> listCartItem = cartItemDao.findAllByuId(a.getuId());
				Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();
				 for (int i = 0; i < listCartItem.size(); i++) {
					 map.put(listCartItem.get(i).getProduct().getpId(), listCartItem.get(i));
			        }
				session.setAttribute("cart", map);
				req.getRequestDispatcher("/home?index=1").forward(req, resp);
			}
		} else {
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}

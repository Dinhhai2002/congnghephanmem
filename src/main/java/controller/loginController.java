package controller;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import dao.CartItemDao;
import dao.UserDao;
import entity.CartItem;
import entity.User;

@WebServlet(urlPatterns = "/login")

public class loginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Cookie arr[]=req.getCookies();
		if(arr!=null)
		{
			for(Cookie o: arr)
			{
				if(o.getName().equals("username"))
				{
					req.setAttribute("username", o.getValue());
				}
				if(o.getName().equals("pass"))
				{
					req.setAttribute("pass", o.getValue());
				}
			}
		}
		req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		PrintWriter out=resp.getWriter();
		String username = req.getParameter("username");
		String pass = req.getParameter("password");
		String remember=req.getParameter("remember");

		CartItemDao cartItemDao = new CartItemDao();
		UserDao userDao = new UserDao();
		
		
		try {
			User a = userDao.CheckAccount(username);
			String uPass=a.getuPassword();
			if (username != null && pass != null) {
				if ((a!=null && BCrypt.checkpw(pass, a.getuPassword())==true )||(a!=null && pass.equals(uPass))) {
					HttpSession session=req.getSession();
					session.setAttribute("acc", a);
					List<CartItem> listCartItem = cartItemDao.findAllByuId(a.getuId());
					Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();
				 for (int i = 0; i < listCartItem.size(); i++) {
					 map.put(listCartItem.get(i).getProduct().getpId(), listCartItem.get(i));
			        }
				session.setAttribute("cart", map);
					Cookie u=new Cookie("username",username);
					Cookie p=new Cookie("pass",pass);
					u.setMaxAge(60*60*24*365);
					if(remember!=null)
					{
						p.setMaxAge(60*60*24*365);
					}
					else {
						p.setMaxAge(0);
					}
					
					
					resp.addCookie(u);
					resp.addCookie(p);
					if(a.getIdRole()==1||a.getIdRole()==3)
					{
						resp.sendRedirect("/Shopee/home");
					}
					else if(a.getIdRole()==2)
					{
						resp.sendRedirect("/Shopee/admin");
					}
					else if(a.getIdRole()==4)
					{
						resp.sendRedirect("/Shopee/admin/shipper/order");
					}
					
					System.out.print("success");
					
				} else {
					req.setAttribute("mess", "Bạn đã nhập sai mật khẩu hoặc tên người dùng");
					req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
					
				}
				
			} else {
				req.getRequestDispatcher("/views/login.jsp").forward(req, resp);

			}
		}
		catch(Exception e){
			req.setAttribute("mess", "Bạn đã nhập sai mật khẩu hoặc tên người dùng");
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
		}
		out.close();
	}
	

	

}
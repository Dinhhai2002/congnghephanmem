package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;



@WebServlet(urlPatterns="/ValidateOtpSignup")
public class validateOtpSignUp extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=null; 
		dispatcher=request.getRequestDispatcher("/views/EnterOtpSignUp.jsp");
			dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int value=Integer.parseInt(request.getParameter("otp"));
		HttpSession session=request.getSession();
		int otp=(int)session.getAttribute("otp");
		String username=(String) session.getAttribute("username");
		String pass=(String) session.getAttribute("password");
		String fullname=(String) session.getAttribute("fullname");
		String  email=(String) session.getAttribute("email");
		String phoneNumber=(String) session.getAttribute("phoneNumber");
		String address=(String) session.getAttribute("address");
		String fullAddress=(String) session.getAttribute("fullAddress");
		
		
		RequestDispatcher dispatcher=null;
		
		
		if (value==otp) 
		{
			UserDao userDao=new UserDao();
			userDao.SignUp(username, fullname,email,address,fullAddress,pass,phoneNumber);
				request.setAttribute("status", "success");
			  response.sendRedirect("/Shopee/login");
			
		}
		else
		{
			request.setAttribute("message","wrong otp");
			
		   dispatcher=request.getRequestDispatcher("/views/EnterOtpSignUp.jsp");
			dispatcher.forward(request, response);
		
		}
	}
}

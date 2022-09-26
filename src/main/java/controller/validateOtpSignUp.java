package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;

@WebServlet(urlPatterns="/ValidateOtpSignup")
public class validateOtpSignUp extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int value=Integer.parseInt(request.getParameter("otp"));
		HttpSession session=request.getSession();
		int otp=(int)session.getAttribute("otp");
		String username=(String) session.getAttribute("username");
		String pass=(String) session.getAttribute("password");
		String  email=(String) session.getAttribute("email");
		String phoneNumber=(String) session.getAttribute("phoneNumber");
		String address=(String) session.getAttribute("address");
		
		
		RequestDispatcher dispatcher=null;
		
		
		if (value==otp) 
		{
			DAO dao=new DAO();
			dao.SignUp(username, pass,email,phoneNumber,address);
				request.setAttribute("status", "success");
			  dispatcher=request.getRequestDispatcher("/login");
			dispatcher.forward(request, response);
			
		}
		else
		{
			request.setAttribute("message","wrong otp");
			
		   dispatcher=request.getRequestDispatcher("/views/EnterOtp.jsp");
			dispatcher.forward(request, response);
		
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}

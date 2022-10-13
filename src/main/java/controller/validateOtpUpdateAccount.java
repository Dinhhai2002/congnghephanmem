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


@WebServlet(urlPatterns="/ValidateOtpUpdateAccount")
public class validateOtpUpdateAccount extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=null; 
		dispatcher=request.getRequestDispatcher("/views/EnterOtpUpdateAccount.jsp");
			dispatcher.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int value=Integer.parseInt(request.getParameter("otp"));
		HttpSession session=request.getSession();
		int otp=(int)session.getAttribute("otp");
		String id=(String) session.getAttribute("id");
		String username=(String) session.getAttribute("username");
		String fullname=(String) session.getAttribute("fullname");
		String  email=(String) session.getAttribute("email");
		String phoneNumber=(String) session.getAttribute("phoneNumber");
		String address=(String) session.getAttribute("address");
		RequestDispatcher dispatcher=null;
		if (value==otp) 
		{
			UserDao userDao=new UserDao();
			userDao.UpdateAccount(id, username, fullname, email, address, phoneNumber);
			session.setAttribute("acc", userDao.CheckAccountUpdate(username, fullname, email, address, phoneNumber));
			request.setAttribute("mess", "Cập nhật thành công");
				request.setAttribute("status", "success");
			  response.sendRedirect("/Shopee/myAccount");
			
		}
		else
		{
			request.setAttribute("message","wrong otp");
			
		   dispatcher=request.getRequestDispatcher("/views/EnterOtpUpdateAccount.jsp");
			dispatcher.forward(request, response);
		
		}
	}
	
}

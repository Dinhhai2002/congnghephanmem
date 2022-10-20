package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import dao.UserDao;


@WebServlet(urlPatterns="/newPassword")
public class newPasswordController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/newPassword.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String newPassword = request.getParameter("password");
		String confPassword = request.getParameter("confPassword");
		String email=(String) session.getAttribute("email");
		String phoneNumber=(String) session.getAttribute("phoneNumber");
		String username=(String) session.getAttribute("username");
		if (newPassword != null && confPassword != null && newPassword.equals(confPassword)) {
				
			UserDao userDao = new UserDao();
			userDao.updatePassword(BCrypt.hashpw(newPassword, BCrypt.gensalt(12)),username,email);
			userDao.updatePasswordSMS(BCrypt.hashpw(newPassword, BCrypt.gensalt(12)), username, phoneNumber);
			request.setAttribute("status", "resetSuccess");
			response.sendRedirect("/Shopee/login");
			
		}
	else {
		request.setAttribute("status", "resetFailed");
		request.getRequestDispatcher("/views/newPassword.jsp").forward(request, response);;
	}
	}
}

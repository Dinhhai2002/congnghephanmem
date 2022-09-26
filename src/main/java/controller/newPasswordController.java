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

import dao.DAO;


@WebServlet(urlPatterns="/newPassword")
public class newPasswordController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String newPassword = request.getParameter("password");
		String confPassword = request.getParameter("confPassword");
		String email=(String) session.getAttribute("email");
		String username=(String) session.getAttribute("username");
		if (newPassword != null && confPassword != null && newPassword.equals(confPassword)) {
				
			DAO dao=new DAO();
			dao.updatePassword(newPassword,username,email);
			request.setAttribute("status", "resetSuccess");
			request.getRequestDispatcher("/login").forward(request, response);
			
		}
	else {
		request.setAttribute("status", "resetFailed");
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);;
	}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}

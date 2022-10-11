package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import entity.user;

@WebServlet(urlPatterns="/changePassword")
public class changePasswordController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/changePasswordAccount.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession mySession=req.getSession();
		String id=req.getParameter("id");
		String oldPass=req.getParameter("oldPass");
		String pass=req.getParameter("pass");
		String repass=req.getParameter("repass");
		DAO dao=new DAO();
		user a=dao.checkpasswordAccount(id, oldPass);
		if(pass!=null &&pass.equals(repass) && a!=null) {
			dao.UpdatePassWordAccount(id, pass);
			mySession.setAttribute("acc",dao.checkpasswordAccount(id, pass) );
			req.setAttribute("mess", "Cập nhật thành công");
			resp.sendRedirect("/Shopee/changePassword");
		}
		else {
			req.setAttribute("mess","thay đổi mật khẩu thất bại");
			req.getRequestDispatcher("/views/changePasswordAccount.jsp").forward(req, resp);
		}
		
		
	}
}

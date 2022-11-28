package adminController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
@WebServlet(urlPatterns = {"/admin/customer/delete"})
public class deleteCustomerAdminController extends HttpServlet{
	
	
	UserDao userdao = new UserDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String uId = req.getParameter("id");
		userdao.deleteUser(uId);
		resp.sendRedirect("/Shopee/admin/customer");
	}
}

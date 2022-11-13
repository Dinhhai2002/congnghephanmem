package adminController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.User;

public class editCustomerAdminController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String id = req.getParameter("uId");
		UserDao userdao = new UserDao();
		User user = userdao.getUserById(id);
		req.setAttribute("user", user);
		req.getRequestDispatcher("/views/customerAdmin.jsp").forward(req,resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uId = req.getParameter("uId");
		String uName = req.getParameter("uName");
		String uEmail = req.getParameter("uEmail");
		String uAddress = req.getParameter("uAddress");
		String uPhone = req.getParameter("uPhone");
		UserDao userdao = new UserDao();
		userdao.editUser(uId,uName,uEmail,uAddress,uPhone);
		resp.sendRedirect("customer");
		super.doPost(req, resp);
	}
	
}

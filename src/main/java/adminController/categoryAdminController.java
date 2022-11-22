package adminController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import dao.UserDao;
import entity.Category;

@WebServlet(urlPatterns="/admin/category")
public class categoryAdminController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		
		
		UserDao userdao = new UserDao();
		int totalUser = userdao.getTotalUser();
		req.setAttribute("totalUser", totalUser);
		
		CategoryDao categorydao = new CategoryDao();
		List<Category> listCategory = categorydao.getAllCategory();
		req.setAttribute("listCategory", listCategory);
		RequestDispatcher rq=req.getRequestDispatcher("/views/categoryAdmin.jsp");
		rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
 
}

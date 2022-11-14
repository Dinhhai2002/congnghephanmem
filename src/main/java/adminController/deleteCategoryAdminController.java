package adminController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
@WebServlet(urlPatterns = {"/deleteCategoryAdmin"})
public class deleteCategoryAdminController extends HttpServlet{
	CategoryDao cateDao = new CategoryDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		int cId = Integer.parseInt(req.getParameter("id"));
		cateDao.deleteCategory(cId);
		resp.sendRedirect("category");
	}
	
}

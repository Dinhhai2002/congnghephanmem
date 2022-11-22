package adminController;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.CategoryDao;
import entity.Category;
import utils.Constant;

@WebServlet(urlPatterns = {"/admin/category/add"})
public class addCategoryAdminController extends HttpServlet{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		CategoryDao cateDao = new CategoryDao();

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Category category = new Category();
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
			servletFileUpload.setHeaderEncoding("utf-8");
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			try {
				List<FileItem> items = servletFileUpload.parseRequest(req);
				for (FileItem item : items) {
					if (item.getFieldName().equals("name")) {
						category.setcName(item.getString("utf-8"));
					}  else if (item.getFieldName().equals("image")) {
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constant.dir + "/category/" + fileName);
						item.write(file);
						category.setcImage("category/" + fileName);
					}
				}
				cateDao.insertCategory(category);
				resp.sendRedirect("category");
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}


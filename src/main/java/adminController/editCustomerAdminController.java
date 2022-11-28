package adminController;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
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

import com.google.gson.Gson;

import dao.UserDao;
import entity.User;
import utils.Constant;

@WebServlet(urlPatterns = {"/admin/customer/edit"})
public class editCustomerAdminController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserDao userdao = new UserDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");
		UserDao userdao = new UserDao();
		User user = userdao.getUserById(id);
		
		
		
		OutputStream outputStream = resp.getOutputStream();
		Gson gson = new Gson();
		outputStream.write(gson.toJson(user).getBytes());
		outputStream.flush();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		User user = new User();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("utf-8");
		try {
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("id")) {
					user.setuId(Integer.parseInt(item.getString("utf-8")));
				} else if (item.getFieldName().equals("name")) {
					user.setuFullName(item.getString("utf-8"));
				} else if (item.getFieldName().equals("email")) {
					user.setuEmail(item.getString("utf-8"));
				} else if (item.getFieldName().equals("address")) {
					user.setuAddress(item.getString("utf-8"));
				} else if (item.getFieldName().equals("phone")) {
					user.setuPhone(item.getString("utf-8"));
				} else if (item.getFieldName().equals("image")) {
					if (item.getSize() > 0) {
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constant.dir + "/customer/" + fileName);
						item.write(file);
						user.setuImage("customer/" + fileName);
					} else {
						user.setuImage(null);
					}
				}
			}
			userdao.editUpdateUser(user);
			resp.sendRedirect("/Shopee/admin/customer");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
;
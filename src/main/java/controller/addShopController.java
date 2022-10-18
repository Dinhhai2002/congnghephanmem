package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.CategoryDao;
import dao.ProductDao;
import dao.ShopDao;
import dao.UserDao;
import entity.Category;

import entity.Shop;
import entity.User;
import utils.Constant;

@WebServlet(urlPatterns= {"/addShop"})
public class addShopController extends HttpServlet{
	ShopDao shopDao = new ShopDao();
	ProductDao productDao = new ProductDao();
	CategoryDao cateDao = new CategoryDao();
	UserDao userDao=new UserDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Category> listC = cateDao.getAllCategory();
		req.setAttribute("listC", listC);
		req.getRequestDispatcher("/views/registerManagerProduct.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Category category = new Category();
		int dem=0;
		Shop shop = new Shop();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("utf-8");
		String shopName=req.getParameter("shopName");
		Shop checkshop=shopDao.checkNameShop(shopName);
		
			try {
				resp.setContentType("text/html");
				resp.setCharacterEncoding("UTF-8");
				req.setCharacterEncoding("UTF-8");
				
				List<FileItem> items = servletFileUpload.parseRequest(req);
				for (FileItem item : items) {
					if (item.getFieldName().equals("shopName")) {
						shop.setShopName(item.getString("utf-8"));
					}
					
					else if (item.getFieldName().equals("description")) {
						shop.setShopDecription(item.getString("utf-8"));
					}
					else if (item.getFieldName().equals("address")) {
						shop.setShopAddress(item.getString("utf-8"));
					}
					else if (item.getFieldName().equals("category")) {
						category = cateDao.findOne(Integer.parseInt(item.getString("utf-8")));
						shop.setCategory(category);
					}
					else if (item.getFieldName().equals("image")) {
						if(item.getSize() > 0) {
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constant.dir + "/shop/" + fileName);
						item.write(file);
						shop.setShopImage("shop/" + fileName);}
						else {
							dem++;
						}
						}
					}  
				if(dem==1)
				{
					req.setAttribute("mess", "người dùng chưa thêm ảnh hoặc thông tin không phù hợp");
					req.getRequestDispatcher("/views/registerManagerProduct.jsp").forward(req, resp);
				}
				else if(dem==0)
				{
				HttpSession session = req.getSession();
				User a = (User) session.getAttribute("acc");
				int id = a.getuId();
				shop.setUser(a);
				shopDao.insertShop(shop);
				userDao.UpdateAccountManager(id);
				session.setAttribute("acc", userDao.get(id));
				resp.sendRedirect("home");
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
		
	


package adminController;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

import com.google.gson.Gson;

import dao.CategoryDao;
import dao.ProductDao;
import dao.ShopDao;
import entity.Category;
import entity.Product;
import entity.Shop;
import entity.User;
import utils.Constant;

@WebServlet(urlPatterns = {"/admin/product", "/admin/product/add", "/admin/product/edit", "/admin/product/delete"})
public class ProductAdminController extends HttpServlet{
	ShopDao shopDao = new ShopDao();
	ProductDao productDao = new ProductDao();
	CategoryDao cateDao = new CategoryDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if(url.contains("edit")) {
			edit(req, resp);
		}else {			
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
		
			String index = req.getParameter("index");
			if(index==null) {
				index="1";
			}
			int page = Integer.parseInt(index);
			int pageSize = 50;
		
			int count = productDao.getTotalProduct();
			int endPage = count/pageSize;
			if(count%pageSize > 0) {
				endPage++;
			}
			List<Category> listC = cateDao.getAllCategory();
			List<Product> list = productDao.pagingProductAdmin(page);
		
			req.setAttribute("endPage", endPage);
			req.setAttribute("tag", page);
			req.setAttribute("listP", list);
			req.setAttribute("listC", listC);
			RequestDispatcher rq = req.getRequestDispatcher("/views/productAdmin.jsp");
			rq.forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if(url.contains("add")) {
			add(req, resp);
		}else if(url.contains("edit")) {
			update(req, resp);
		}else if(url.contains("delete")) {
			delete(req, resp);
		}
	}
	
	protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Product product = new Product();
		Category category = new Category();
		int dem = 0;
		
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("utf-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("name")) {
					product.setpName(item.getString("utf-8"));
				} else if (item.getFieldName().equals("price")) {
					String price = item.getString("utf-8");
					float pPrice = Float.parseFloat(price);
					product.setpPrice(pPrice);
				} else if (item.getFieldName().equals("description")) {
					product.setpDescription(item.getString("utf-8"));
				} else if (item.getFieldName().equals("quantity")) {
					product.setpQuantity(Integer.parseInt(item.getString("utf-8")));
				} else if (item.getFieldName().equals("category")) {
					category = cateDao.findOne(Integer.parseInt(item.getString("utf-8")));
					product.setCategory(category);
				} else if (item.getFieldName().equals("image")) {
					if (item.getSize() > 0) {
						String imageName = item.getString("utf-8");
						if (imageName.contains("http")) {
							product.setpImage(imageName);
						} else {
							String originalFileName = item.getName();
							int index = originalFileName.lastIndexOf(".");
							String ext = originalFileName.substring(index + 1);
							String fileName = System.currentTimeMillis() + "." + ext;
							File file = new File(Constant.dir + "/product/" + fileName);
							item.write(file);
							product.setpImage("product/" + fileName);
						}
					} else {
						dem++;
					}
				}
			}
			if (dem != 0) {
				resp.sendRedirect("/Shopee/admin/product?error=1");
			}

			else {
				productDao.insertProduct(product);
				resp.sendRedirect("/Shopee/admin/product");
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		req.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		Product product = productDao.findOne(id);
		OutputStream outputStream = resp.getOutputStream();
		Gson gson = new Gson();
		outputStream.write(gson.toJson(product).getBytes());
		outputStream.flush();
	}
	
	protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Product product = new Product();
		Category category = new Category();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("utf-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("id")) {
					product.setpId(Integer.parseInt(item.getString("utf-8")));
				} else if (item.getFieldName().equals("name")) {
					product.setpName(item.getString("utf-8"));
				} else if (item.getFieldName().equals("price")) {
					String price = item.getString("utf-8");
					float pPrice = Float.parseFloat(price);
					product.setpPrice(pPrice);
				} else if (item.getFieldName().equals("description")) {
					product.setpDescription(item.getString("utf-8"));
				} else if (item.getFieldName().equals("quantity")) {
					product.setpQuantity(Integer.parseInt(item.getString("utf-8")));
				} else if (item.getFieldName().equals("category")) {
					category = cateDao.findOne(Integer.parseInt(item.getString("utf-8")));
					product.setCategory(category);
				} else if (item.getFieldName().equals("image")) {
					if (item.getSize() > 0) {
						String imageName = item.getString("utf-8");
						if (imageName.contains("http")) {
							product.setpImage(imageName);
						} else {
							String originalFileName = item.getName();
							int index = originalFileName.lastIndexOf(".");
							String ext = originalFileName.substring(index + 1);
							String fileName = System.currentTimeMillis() + "." + ext;
							File file = new File(Constant.dir + "/product/" + fileName);
							item.write(file);
							product.setpImage("product/" + fileName);
						}
					} else {
						product.setpImage(null);
					}

				}
			}
			productDao.editUpdateProduct(product);
			resp.sendRedirect("/Shopee/admin/product");
		} catch (FileUploadException e) {
			e.printStackTrace();
			resp.sendRedirect("/Shopee/admin/product?error=2");
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/Shopee/admin/product?error=2");
		}
	}
	
	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			
			int pId = Integer.parseInt(req.getParameter("id"));
			productDao.deleteProduct(pId);
			resp.sendRedirect("/Shopee/admin/product");
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/Shopee/admin/product?error=3");
		}
		
	}
}

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
import entity.Category;
import entity.Product;
import entity.Shop;
import entity.User;
import utils.Constant;

@WebServlet(urlPatterns = { "/admin/editP" })
public class ProductEditController extends HttpServlet {
	ProductDao productDao = new ProductDao();
	CategoryDao cateDao = new CategoryDao();
	ShopDao shopDao = new ShopDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		Product p = productDao.findOne(id);
		List<Category> listC = cateDao.getAllCategory();

		req.setAttribute("product", p);
		req.setAttribute("listC", listC);
		req.getRequestDispatcher("/views/EditProduct.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product product = new Product();
		Category category = new Category();
		Shop shop = new Shop();
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
			HttpSession session = req.getSession();
			User a = (User) session.getAttribute("acc");
			int id = a.getuId();
			int shopId = shopDao.getShopIdByuId(id);
			shop = shopDao.findOne(shopId);
			product.setShop(shop);
			productDao.editUpdateProduct(product);
			resp.sendRedirect("shop-manager");
		} catch (FileUploadException e) {
			e.printStackTrace();
			int id = Integer.parseInt(req.getParameter("id"));
			Product p = productDao.findOne(id);
			List<Category> listC = cateDao.getAllCategory();

			req.setAttribute("product", p);
			req.setAttribute("listC", listC);
			req.setAttribute("mess", "Chỉnh sửa không thành công");
			req.getRequestDispatcher("/views/EditProduct.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			int id = Integer.parseInt(req.getParameter("id"));
			Product p = productDao.findOne(id);
			List<Category> listC = cateDao.getAllCategory();

			req.setAttribute("product", p);
			req.setAttribute("listC", listC);
			req.setAttribute("mess", "Chỉnh sửa không thành công");
			req.getRequestDispatcher("/views/EditProduct.jsp").forward(req, resp);
		}
	}
	
}

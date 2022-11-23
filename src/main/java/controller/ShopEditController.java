package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.ShopDao;
import entity.Shop;
import utils.Constant;

@WebServlet(urlPatterns = {"/admin/shop-manager/editShop"})
public class ShopEditController extends HttpServlet {
	ShopDao shopDao = new ShopDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		int shopId = Integer.parseInt(req.getParameter("sid"));
		Shop shop = shopDao.findOne(shopId);
		req.setAttribute("shop", shop);
		RequestDispatcher rq = req.getRequestDispatcher("/views/editShop.jsp");
		rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
					shop.setShopId(Integer.parseInt(item.getString("utf-8")));
				} else if (item.getFieldName().equals("name")) {
					shop.setShopName(item.getString("utf-8"));
				} else if (item.getFieldName().equals("description")) {
					shop.setShopDecription(item.getString("utf-8"));
				} else if (item.getFieldName().equals("address")) {
					shop.setShopAddress(item.getString("utf-8"));
				} else if (item.getFieldName().equals("image")) {
					if (item.getSize() > 0) {
						String imageName = item.getString("utf-8");
						if (imageName.contains("http")) {
							shop.setShopImage(imageName);
						} else {
							String originalFileName = item.getName();
							int index = originalFileName.lastIndexOf(".");
							String ext = originalFileName.substring(index + 1);
							String fileName = System.currentTimeMillis() + "." + ext;
							File file = new File(Constant.dir + "/shop/" + fileName);
							item.write(file);
							shop.setShopImage("shop/" + fileName);
						}
					} else {
						shop.setShopImage(null);
					}

				}
			}
			shopDao.editUpdateShop(shop);
			resp.sendRedirect("shop-manager");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

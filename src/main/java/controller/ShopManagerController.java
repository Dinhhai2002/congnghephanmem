package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoryDao;
import dao.ProductDao;
import dao.ShopDao;
import entity.Category;
import entity.Product;
import entity.Shop;
import entity.User;

@WebServlet(urlPatterns = {"/admin/shop-manager"})
public class ShopManagerController extends HttpServlet{
	ShopDao shopDao = new ShopDao();
	ProductDao productDao = new ProductDao();
	CategoryDao cateDao = new CategoryDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		User a = (User) session.getAttribute("acc");
		String index = req.getParameter("index");
		if(index==null) {
			index="1";
		}
		int page = Integer.parseInt(index);
		int pageSize = productDao.pageSize;
			
		int uId = a.getuId();
		int shopId = shopDao.getShopIdByuId(uId);
		int count = productDao.getTotalProductByShopId(shopId);
		int endPage = count/pageSize;
		if(count%pageSize > 0) {
			endPage++;
		}
		Shop shop = shopDao.findOne(shopId);
		List<Product> list = productDao.pagingProductByShopId(shopId, page);
		List<Category> listC = cateDao.getAllCategory();
		
		req.setAttribute("endPage", endPage);
		req.setAttribute("tag", page);
		req.setAttribute("shop", shop);
		req.setAttribute("listP", list);
		req.setAttribute("listC", listC);
		RequestDispatcher rq = req.getRequestDispatcher("/views/managerProduct.jsp");
		rq.forward(req, resp);
	}
}

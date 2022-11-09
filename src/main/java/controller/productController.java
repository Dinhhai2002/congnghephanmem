package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import dao.ProductDao;
import entity.Category;
import entity.Product;

@WebServlet(urlPatterns="/product")
public class productController extends HttpServlet {
	ProductDao productDao=new ProductDao();
	CategoryDao cateDao=new CategoryDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String cIndex = req.getParameter("index");
		int page = Integer.parseInt(req.getParameter("page"));	
		
		int pageSize = productDao.pageSize;
		
		List<Category> listC = cateDao.getAllCategory();
		/*set data to jsp*/
		if("0".equals(cIndex)) {
			int count = productDao.getTotalProduct();
			int endPage = count/pageSize;
			if(count%pageSize>0) {
				endPage++;
			}
			List<Product> listP = productDao.pagingProduct(page);
			req.setAttribute("endPage", endPage);
			req.setAttribute("listP", listP);
		}
		else {
			int count = productDao.getTotalProductByCid(cIndex);
			int endPage = count/pageSize;
			if(count%pageSize>0) {
				endPage++;
			}
			List<Product> listPC = productDao.pagingProductByCid(cIndex, page);
			req.setAttribute("endPage", endPage);
			req.setAttribute("listP", listPC);
		}
		req.setAttribute("isSearch", 0);
		req.setAttribute("cid", cIndex);
		req.setAttribute("tag", page);
	    req.setAttribute("listCC", listC);
//        req.setAttribute("p", last);
		RequestDispatcher rq=req.getRequestDispatcher("/views/Product.jsp");
		rq.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}

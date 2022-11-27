package controller;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet(urlPatterns="/product/searchproduct")

public class SearchController extends HttpServlet {
	ProductDao productDao=new ProductDao();
	CategoryDao cateDao=new CategoryDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String txtS = req.getParameter("txtS");
		String p = req.getParameter("page");	
		if(p==null) {
			p="1";
		}
		int page = Integer.parseInt(p);
		int pageSize = productDao.pageSize;
		int count = productDao.getTotalSearchProduct(txtS);
		int endPage = count/pageSize;
		if(count%pageSize>0) {
			endPage++;
		}
		List<Category> listC = cateDao.getAllCategory();
		List<Product> listP = productDao.SearchProductWithPaging(txtS, page);
		
		req.setAttribute("isSearch", 1);
		req.setAttribute("endPage", endPage);
		req.setAttribute("tag", page);
		req.setAttribute("listP", listP);
		req.setAttribute("txtS", txtS);
		req.setAttribute("listCC", listC);
		req.getRequestDispatcher("/views/Product.jsp").forward(req, resp);
	}
}

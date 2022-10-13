package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.Category;
import entity.Product;

@WebServlet(urlPatterns="/product")
public class productController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String pIndex = req.getParameter("index");
		int index = Integer.parseInt(pIndex);
		
		DAO dao = new DAO();
		int count = dao.getTotalProduct();
		int pageSize = dao.pageSize;
		int endPage = count/pageSize;
		if(count%pageSize>0) {
			endPage++;
		}
		List<Product> list = dao.pagingProduct(index);
		List<Category> listC = dao.getAllCategory();
		/*set data to jsp*/
		req.setAttribute("tag", index);
		req.setAttribute("endPage", endPage);
	    req.setAttribute("listP", list);
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
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

@WebServlet(urlPatterns="/search")

public class SearchController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String txtS=req.getParameter("txtS");
		DAO dao =new DAO();
		List<Product> list=dao.SearchProduct(txtS);
		List<Category> listC = dao.getAllCategory();
		/*set data to jsp*/
	    req.setAttribute("listP", list);
	    req.setAttribute("listCC", listC);
	    req.setAttribute("txtSearch", txtS);
//        req.setAttribute("p", last);
		RequestDispatcher rq=req.getRequestDispatcher("/views/home.jsp");
		rq.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}

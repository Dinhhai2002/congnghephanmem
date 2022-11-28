package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;

@WebServlet(urlPatterns = {"/admin/deleteP"})
public class ProductDeleteController extends HttpServlet{
	ProductDao productDao = new ProductDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		int pId = Integer.parseInt(req.getParameter("id"));
		productDao.deleteProduct(pId);
		resp.sendRedirect("shop-manager");
	}
	
}

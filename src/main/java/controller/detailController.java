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
import dao.CommentDao;
import dao.ProductDao;
import entity.Category;
import entity.Product;
import entity.User;
import entity.evaluate;

@WebServlet(urlPatterns="/product/detail")
public class detailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			String pid=req.getParameter("pId");
			
			
			
			//String quantity = req.getParameter("quantity");
			//int x  = Integer.parseInt(quantity);
			ProductDao productDao = new ProductDao();
			CategoryDao cateDao = new CategoryDao();

			CommentDao commentDao=new CommentDao();
			
			Product pro = productDao.findOne(Integer.parseInt(pid));
			
			
			List<evaluate> listcomment=commentDao.getAllComment(Integer.parseInt(pid));
			
			
			String cateId=String.valueOf(pro.getCategory().getcId());
			List<Product> list=productDao.getTop10Product(cateId);
			req.setAttribute("listComment", listcomment);
			req.setAttribute("p",pro);
		    //req.setAttribute("quantity",x);
		    req.setAttribute("listP", list);
		    
		    RequestDispatcher rq=req.getRequestDispatcher("/views/detail.jsp");
			rq.forward(req, resp);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	    //resp.sendRedirect(req.getContextPath() + "/detail");
		
	
		/*if(req.getParameter("add").equals("+")){ 
		    quantity += 1;
		}
		if(req.getParameter("add").equals("-")){
			quantity -= 1;
		}
		
		//req.setAttribute("quantity",quantity);
	    req.setAttribute("p",pro);
	    req.setAttribute("listCC", listC);
	     
		RequestDispatcher rq=req.getRequestDispatcher("/views/detail.jsp");
		rq.forward(req, resp);
		/*resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String pid=req.getParameter("pId");
		//Lấy tham số từ JSP
		ProductDao product = new ProductDao();
		CategoryDao cate = new CategoryDao();
		List<Category> listC = cate.getAllCategory();
		Product pro =product.getProductById(Integer.parseInt(pid));
		String quantity = req.getParameter("quantity");
		HttpSession httpSession = req.getSession();
		Object obj = httpSession.getAttribute("cart");
	
		
		if(obj != null) {
			@SuppressWarnings("unchecked")
			Map<Integer, CartItem> map = (Map<Integer, CartItem>) obj; //ép về kiểu của map
			CartItem existedCartItem = map.get(Integer.valueOf(pId));
			if(action.equals("add")) {
			existedCartItem.setCount(existedCartItem.getCount() + 1);
			} else {
				if (existedCartItem.getCount()==1) {
					map.remove(Integer.parseInt(pId));}
				existedCartItem.setCount(existedCartItem.getCount() - 1);
				}
			//Cập nhật lại session
			httpSession.setAttribute("cart", map);
		}
		req.setAttribute("p",pro);
	    req.setAttribute("listCC", listC);
		resp.sendRedirect(req.getContextPath()+"/detail");*/
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String pid=req.getParameter("pId");
		
		
		
		//String quantity = req.getParameter("quantity");
		//int x  = Integer.parseInt(quantity);
		ProductDao productDao = new ProductDao();
		CategoryDao cateDao = new CategoryDao();

		CommentDao commentDao=new CommentDao();
		
		Product pro = productDao.findOne(Integer.parseInt(pid));
		String content=req.getParameter("content");
		HttpSession session = req.getSession();
		User a = (User) session.getAttribute("acc");
		if(a!=null)
		{
			evaluate evaluate=new evaluate();
			evaluate.setContent(content);
			evaluate.setProduct(pro);
			evaluate.setUser(a);
			commentDao.insertComment(evaluate);
		}
		
		List<evaluate> listcomment=commentDao.getAllComment(Integer.parseInt(pid));
		req.setAttribute("listComment", listcomment);
		resp.sendRedirect("detail?pId="+pid);
	}
	
}

package adminController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDetailDao;
import dao.ProductDao;
import dao.ShopDao;
import dao.UserDao;
import entity.OrderDetail;
import entity.User;

@WebServlet(urlPatterns="/admin")
public class dashboardAdminController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		// total users, shops, products, earning
		ShopDao shopdao =new ShopDao();
		UserDao userdao = new UserDao();
		
		HttpSession session=req.getSession();
		User a=(User) session.getAttribute("acc");
		if(a==null || a.getIdRole()!=2)
		{
			resp.sendRedirect("/Shopee/login");
		}
		else
		{
			ProductDao productdao = new ProductDao();
			
			int totalUser = userdao.getTotalUser();
			int totalShop = shopdao.getTotalShop();
			int totalProduct = productdao.getTotalProduct();
			
			req.setAttribute("totalUser", totalUser);
			req.setAttribute("totalShop", totalShop);
			req.setAttribute("totalProduct", totalProduct);
			
					
			OrderDetailDao orderdetail = new OrderDetailDao();
			
			
			List<OrderDetail> listOrder = orderdetail.find7OrderArrByCreateAt();
			
//			int[]  arrStatus = null;
//			for(int i = 1 ;i<7;i++)
//			{
//			arrStatus[i-1] = orderdetail.countStatusByIdStatus(i);
//			}
//			req.setAttribute("arrStatus", arrStatus);
//			
			
			req.setAttribute("orderdetail", orderdetail);
			
			
			req.setAttribute("listOrder", listOrder);
			List<User> listUser = userdao.getAllUserArrByCreateAt();
			
			req.setAttribute("listUser", listUser);
			RequestDispatcher rq=req.getRequestDispatcher("/views/Admin.jsp");
			
			rq.forward(req, resp);
		}
		

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
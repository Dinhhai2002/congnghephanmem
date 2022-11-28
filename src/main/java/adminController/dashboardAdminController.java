package adminController;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDao;
import dao.OrderDetailDao;
import dao.ProductDao;
import dao.ShopDao;
import dao.ThongKeDao;
import dao.UserDao;
import entity.Order;
import entity.OrderDetail;
import entity.ThongKe;
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
			OrderDao order = new OrderDao();
			int doanhthu = orderdetail.getTongDoanhThu();			
			List<OrderDetail> listOrderDetail = orderdetail.findAll();
			List<Order> listOrder = order.findAll();
			req.setAttribute("orderdetail", orderdetail);
			req.setAttribute("order", orderdetail);
			req.setAttribute("doanhthu", doanhthu);
			
			
			req.setAttribute("listOrderDetail", listOrderDetail);
			req.setAttribute("listOrder", listOrder);
			
			List<User> listUser = userdao.getAllUserArrByCreateAt();
			
			req.setAttribute("listUser", listUser);
			
			long millis=System.currentTimeMillis();  
			Date date = new Date(millis);   
			String dateString = date.toString();
			ThongKeDao thongkedao = new ThongKeDao();
			List<ThongKe> listThongKe = thongkedao.getDoanhThu("2000-1-1",dateString);
			
			
			String fromday =req.getParameter("fromday");
			String today =req.getParameter("today");	

			
			List<ThongKe> listSelectThongKe = thongkedao.getDoanhThu(fromday, today);
			List<OrderDetail> listSelectOrderDetail = orderdetail.findbyDate(fromday,today);
			
			req.setAttribute("listThongKe2", listSelectThongKe);
			req.setAttribute("listThongKe", listThongKe);
			req.setAttribute("listSelectOrderDetail", listSelectOrderDetail);
			
			RequestDispatcher rq=req.getRequestDispatcher("/views/Admin.jsp");	
			rq.forward(req, resp);
		}
		

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
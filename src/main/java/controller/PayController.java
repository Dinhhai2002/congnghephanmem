package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDao;
import dao.CartItemDao;
import dao.OrderDao;
import dao.OrderDetailDao;
import dao.ProductDao;
import dao.ShopDao;
import dao.UserDao;
import entity.Cart;
import entity.CartItem;
import entity.Order;
import entity.OrderDetail;
import entity.OrderStatus;
import entity.Product;
import entity.Shop;
import entity.User;



@WebServlet(urlPatterns={"/member/pay"})
public class PayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		HttpSession httpSession = req.getSession();
		Object user = httpSession.getAttribute("acc");
		Object obj = httpSession.getAttribute("cart");
		User acc = (User) user;
		Map<Integer, CartItem> cartItem = extracted(obj);
		
		String payment = req.getParameter("payment");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		ShopDao shopDao = new  ShopDao();
		OrderDao orderDao = new OrderDao();
		OrderDetailDao orderDetailDao = new OrderDetailDao();
		CartItemDao cartItemDao = new CartItemDao();
		CartDao cartDao = new CartDao();
		OrderStatus orderStatus = new OrderStatus(1);
		
		
		
		
		Map<Integer, Order> orderCheck = new HashMap<Integer, Order>();
		Set<Integer> set = cartItem.keySet();
		
		for (Integer key : set) {
				Order order = new Order();
				order.setUser(acc);
				order.setuName(name);
				order.setuPhone(phone);
				order.setuAddress(address);
				order.setStatus(orderStatus);

				int shopId = cartItem.get(key).getCart().getShop().getShopId();
				System.out.println(orderCheck.containsKey(shopId));
				if(orderCheck.containsKey(shopId)==true) {
					order.setShop(cartItem.get(key).getCart().getShop());
					order.setAmountFromUser(orderCheck.get(shopId).getAmountFromUser()+
							cartItem.get(key).getCount()*cartItem.get(key).getProduct().getpPrice());
					orderCheck.replace(shopId, order);
				}else {
					order.setShop(cartItem.get(key).getCart().getShop());
					order.setAmountFromUser(cartItem.get(key).getCount()*cartItem.get(key).getProduct().getpPrice());
					orderCheck.put(shopId, order);
				}
			}
		
		
			Set<Integer> set1 = orderCheck.keySet();
			for (Integer key1 : set1){
				orderDao.create(orderCheck.get(key1));
				Order order = new Order();
				order = orderDao.findOneNew();
				
				for (Integer key : set) {
					CartItem cartItemSelected = new CartItem();
					cartItemSelected = cartItemDao.findCartItemSelected(key1, key);
					if(cartItemSelected!=null) {
						OrderDetail orderDetail = new OrderDetail(order,cartItemSelected.getProduct(),cartItemSelected.getCount()
								,cartItemSelected.getTotalPrice());
						
						orderDetailDao.create(orderDetail);
					}
				}				
			}
			
			for (Integer key : set) {
				cartItemDao.delete(key);
				cartDao.delete();
			}
			cartItem.clear();
			httpSession.setAttribute("cart", cartItem);
			RequestDispatcher rq=req.getRequestDispatcher("/views/buysucess.jsp");
			rq.forward(req, resp);
	}
	
		@SuppressWarnings("unchecked")
		private Map<Integer, CartItem> extracted(Object obj)
		{
			return (Map<Integer, CartItem>) obj;
		}
	
}

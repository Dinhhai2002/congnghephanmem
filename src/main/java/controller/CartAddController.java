package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connect.connect;
import dao.CartDao;
import dao.CartItemDao;
import dao.CategoryDao;
import dao.ProductDao;
import dao.ShopDao;
import dao.UserDao;
import entity.Cart;
import entity.CartItem;
import entity.Category;
import entity.Product1;
import entity.Shop;
import entity.User;

@WebServlet(urlPatterns={"/member/cart-add"})
public class CartAddController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Thiết lập tiếng việt
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		//Lấy tham số từ JSP
		String pId = req.getParameter("pId");
		String count = req.getParameter("quantity");
		//BƯỚC 1: Khởi tạo DAO
		ProductDao productDao = new ProductDao();
		CartDao cartDao = new CartDao();
		CartItemDao cartItemDao = new CartItemDao();
		ShopDao shopDao = new  ShopDao();
		//Gọi session để lấy tài khoản client và cart
		HttpSession httpSession = req.getSession();
		Object user = httpSession.getAttribute("acc");
		Object obj = httpSession.getAttribute("cart");
		User acc = (User) user;
		//Query sản phẩm vừa add từ trang detail
		Product1 product = productDao.findOne(Integer.parseInt(pId));
		//Query Shop bán product đó 
		Shop shop = shopDao.findOne(product.getShop().getShopId());
		//Kiểm tra coi đã có cart chứa user và shop chưa
		Cart cart = cartDao.findOneUserAndShop(acc, shop);
		//Nếu chưa tạo một cart mới vô database
		if(cart==null) {
			cartDao.create(acc, shop);
			cart = cartDao.findOneNew();
		}
		
		//Set giá trị cho cartitem
		CartItem cartItem = new CartItem();
		cartItem.setCart(cart);
		cartItem.setProduct(product);
		cartItem.setCount(Integer.parseInt(count));
		cartItem.setTotalPrice(product.getpPrice()*Integer.parseInt(count));
		
		//kiểm tra coi đã có product trong cartitem hay chưa
		CartItem existed = new CartItem();
		existed = cartItemDao.findOnecartIdAndproductId(cartItem);
		//Nếu chưa tạo một cái mới
		if(existed==null) {
			cartItemDao.create(cartItem);
		}else {
			//Nếu rồi update lại 
			cartItem.setId(existed.getId());
			cartItem.setCount(existed.getCount()+Integer.parseInt(count));
			cartItem.setTotalPrice(existed.getTotalPrice()+cartItem.getTotalPrice());
			cartItemDao.update(cartItem);
		}
		/*List<CartItem> listCartItem = cartItemDao.findAllByuId(acc.getuId());
		Map<Integer, CartItem> map1 = new HashMap<Integer, CartItem>();
		 for (int i = 0; i < listCartItem.size(); i++) {
			 map1.put(listCartItem.get(i).getProduct().getpId(), listCartItem.get(i));
	        }
		 httpSession.setAttribute("cart1", map1);*/
		
		
		/*if(user==null) {
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
		}
		else {
			@SuppressWarnings("unchecked")
			User acc = (User) user; //ép về kiểm của
			//Cập nhật lại session
			httpSession.setAttribute("acc", acc);
		}*/
		
		//Kiểm tra session
		//nếu null tạo một map chứa product
		if(obj ==null) {
			Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();
			map.put(cartItem.getProduct().getpId(), cartItem);
			httpSession.setAttribute("cart", map);
		}else {
			Map<Integer, CartItem> map = extracted(obj);
			CartItem existedCartItem = map.get(Integer.valueOf(pId));
			//Kiểm tra trong session có product này ko
			if(existedCartItem == null) {
				cartItem = cartItemDao.findOneByProductId(product.getpId());
				map.put(product.getpId(), cartItem); 
			} else {
				existedCartItem.setCount(existedCartItem.getCount() + Integer.parseInt(count));
			}		
			httpSession.setAttribute("cart", map);
 		}
		resp.sendRedirect(req.getContextPath() + "/member/cart");
		//RequestDispatcher rq=req.getRequestDispatcher("/views/cart.jsp");
		
	}
	
	@SuppressWarnings("unchecked")
	private Map<Integer, CartItem> extracted(Object obj)
	{
		return (Map<Integer, CartItem>) obj;
	}
	
}

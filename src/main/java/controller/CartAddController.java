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
import entity.Product;
import entity.Shop;
import entity.User;

@WebServlet(urlPatterns={"/member/cart-add"})
public class CartAddController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		Object user = httpSession.getAttribute("acc");
		if(user==null) {
			resp.sendRedirect(req.getContextPath() + "/login");	
		}else {
			String action = req.getParameter("action");
			if(action==null){
				addToCart(req,resp);
				RequestDispatcher rq=req.getRequestDispatcher("/views/cart.jsp");
				rq.forward(req, resp);		
			}else {
				addToCart(req,resp);
				resp.getWriter().write("true");
			}
		}
	}
	
	protected void addToCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
				Product product = productDao.findOne(Integer.parseInt(pId));
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
				if(existed==null) {
					cartItemDao.create(cartItem);
				}else {
					//Nếu rồi update lại 
					int quantity = Integer.parseInt(count)+ existed.getCount();
					if(quantity> existed.getProduct().getpQuantity()){
						resp.getWriter().write("overquantity");
						return;
					}
					cartItem.setId(existed.getId());
					cartItem.setCount(quantity);
					cartItem.setTotalPrice(existed.getTotalPrice()+cartItem.getTotalPrice());
					cartItemDao.update(cartItem);
				}
				
				
					//Nếu chưa tạo một cái mới
					
				
					
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
				}
	
	@SuppressWarnings("unchecked")
	private Map<Integer, CartItem> extracted(Object obj)
	{
		return (Map<Integer, CartItem>) obj;
	}
	
	
}

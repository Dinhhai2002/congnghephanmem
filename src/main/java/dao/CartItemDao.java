package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.connect;
import entity.Cart;
import entity.CartItem;
import entity.Product;
import entity.Shop;
import entity.User;

public class CartItemDao {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    //dung
	public void create(CartItem cartItem) {
		String sql = "INSERT INTO cartItems(cartId, productId, [count], totalPrice) VALUES (?,?,?,?)";
		try {
		conn = new connect().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		//ProductDao productDao = new ProductDao();
		//CartDao cartDao = new CartDao();
	
		//Product1 product = productDao.findOne(rs.getInt("pId"));
		//Cart cart = cartDao.findOne(rs.getInt("cartId"));
		
		ps.setInt(1, cartItem.getCart().getCartId());
		ps.setInt(2, cartItem.getProduct().getpId());
		ps.setInt(3, cartItem.getCount());
		ps.setFloat(4, cartItem.getTotalPrice());
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	//dung
	public void update(CartItem cartItem) {
		String sql = "UPDATE cartItems SET cartId = ?, productId = ?, [count]=?, totalPrice = ? WHERE id = ?";
				try {
					conn = new connect().getConnection();
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ps.setInt(1, cartItem.getCart().getCartId());
					ps.setInt(2, cartItem.getProduct().getpId());
					ps.setInt(3, cartItem.getCount());
					ps.setFloat(4, cartItem.getTotalPrice());
					ps.setInt(5, cartItem.getId());
					ps.executeUpdate();
				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
	}

	public void delete(int id) {
		String sql = "DELETE FROM cartItems WHERE productId = ?";
		try {
		conn = new connect().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	//dung
	public CartItem findOne(int id) {
		String sql = "SELECT * FROM cartItems WHERE id = ? ";
		try {
		conn = new connect().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			CartDao cartDao = new CartDao();
			ProductDao productDao = new ProductDao();
			Cart cart = cartDao.findOne(rs.getInt("cartId"));
			Product product = productDao.findOne(rs.getInt("productId"));
			
			CartItem cartItem = new CartItem();
			cartItem.setId(rs.getInt("id"));
			cartItem.setCart(cart);
			cartItem.setProduct(product);
			cartItem.setCount(rs.getInt("count"));
			cartItem.setTotalPrice(rs.getFloat("totalPrice"));
			return cartItem;
		}} catch (Exception e) {
		e.printStackTrace();}
		return null;
	}
	//dung
	public List<CartItem> findAll() {
		List<CartItem> cartItems = new ArrayList<CartItem>();
		String sql = "SELECT * FROM cartItems";
		try {
		conn = new connect().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			ProductDao productDao = new ProductDao();
			CartDao cartDao = new CartDao();
			Product product = productDao.findOne(rs.getInt("productId"));
			Cart cart = cartDao.findOne(rs.getInt("cartId"));
		
			CartItem cartItem = new CartItem();
			cartItem.setId(rs.getInt("id"));
			cartItem.setCart(cart);
			cartItem.setProduct(product);
			cartItem.setCount(rs.getInt("count"));
			cartItem.setTotalPrice(rs.getFloat("totalPrice"));
			cartItems.add(cartItem);
		}} catch (Exception e) {
		e.printStackTrace();}
		return cartItems;
	}

	public List<Cart> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	//tìm trong cartitem có đã có product đó chưa dung
	public CartItem findOnecartIdAndproductId(CartItem item) {
		String sql = "SELECT * FROM cartItems WHERE cartId = ? and productId = ?";
		try {
		conn = new connect().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, item.getCart().getCartId());
		ps.setInt(2, item.getProduct().getpId());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			ProductDao productDao = new ProductDao();
			CartDao cartDao = new CartDao();
		
			Product product = productDao.findOne(rs.getInt("productId"));
			Cart cart = cartDao.findOne(rs.getInt("cartId"));
			
			CartItem cartItem = new CartItem();
			cartItem.setId(rs.getInt("id"));
			cartItem.setCart(cart);
			cartItem.setProduct(product);
			cartItem.setCount(rs.getInt("count"));
			cartItem.setTotalPrice(rs.getFloat("totalPrice"));
			return cartItem;
		}} catch (Exception e) {
		e.printStackTrace();}
		return null;
	}
	public List<CartItem> findAllByuId(int uId) {
		List<CartItem> cartItems = new ArrayList<CartItem>();
		String sql = "Select cartItems.* From cart \r\n"
				+ "	inner join cartItems on cart.cartId=cartItems.cartId\r\n"
				+ "	Where cart.uId= ?";
		try {
		conn = new connect().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, uId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			ProductDao productDao = new ProductDao();
			CartDao cartDao = new CartDao();
			//CartDao cartDao = new CartDao();
			Product product = productDao.findOne(rs.getInt("productId"));
			Cart cart = cartDao.findOne(rs.getInt("cartId"));
		
			CartItem cartItem = new CartItem();
			cartItem.setId(rs.getInt("id"));
			cartItem.setCart(cart);
			cartItem.setProduct(product);
			cartItem.setCount(rs.getInt("count"));
			cartItem.setTotalPrice(rs.getFloat("totalPrice"));
			cartItems.add(cartItem);
		}} catch (Exception e) {
		e.printStackTrace();}
		return cartItems;
	}
	public CartItem findOneByProductId(int id) {
		String sql = "SELECT * FROM cartItems WHERE productId = ? ";
		try {
		conn = new connect().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			CartDao cartDao = new CartDao();
			ProductDao productDao = new ProductDao();
			Cart cart = cartDao.findOne(rs.getInt("cartId"));
			Product product = productDao.findOne(rs.getInt("productId"));
			
			CartItem cartItem = new CartItem();
			cartItem.setId(rs.getInt("id"));
			cartItem.setCart(cart);
			cartItem.setProduct(product);
			cartItem.setCount(rs.getInt("count"));
			cartItem.setTotalPrice(rs.getFloat("totalPrice"));
			return cartItem;
		}} catch (Exception e) {
		e.printStackTrace();}
		return null;
	}
	
	//Chọn CartItem mà Product trong cart được chọn
		public CartItem findCartItemSelected(int shopId, int pId) {
			String sql = "Select *  From cartItems "
					+ "inner join cart on cartItems.cartId = cart.cartId where cart.shopId = ? and cartItems.productId = ?";
			try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, shopId);
			ps.setInt(2, pId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductDao productDao = new ProductDao();
				CartDao cartDao = new CartDao();
				//CartDao cartDao = new CartDao();
				Product product = productDao.findOne(rs.getInt("productId"));
				Cart cart = cartDao.findOne(rs.getInt("cartId"));
				CartItem cartItem = new CartItem();
				cartItem.setId(rs.getInt("id"));
				cartItem.setCart(cart);
				cartItem.setProduct(product);
				cartItem.setCount(rs.getInt("count"));
				cartItem.setTotalPrice(rs.getFloat("totalPrice"));
				return cartItem;
			}} catch (Exception e) {
			e.printStackTrace();}
			return null;
		}

	public static void main(String[] args) {
		try {
			CartItemDao cartItemDao = new CartItemDao();
			ProductDao productDao = new ProductDao();
			ShopDao shopDao = new  ShopDao();
			Shop shop = shopDao.findOne(1);
			UserDao userDao = new  UserDao();
			User user = userDao.get(3);
			CartDao cartDao = new CartDao();
			//Cart cart = cartDao.findOneUserAndShop(user, shop);
			Cart cart = cartDao.findOne(1);
			Product product = productDao.findOne(1);
			CartItem cartItem = new CartItem();
			cartItem.setId(1);
			cartItem.setCart(cart);
			cartItem.setProduct(product);
			cartItem.setCount(3);
			cartItem.setTotalPrice(product.getpPrice()*3);
			List<CartItem> cartItem1 = cartItemDao.findAllByuId(3);
			//System.out.println(cartItem.toString());
			
			cartItemDao.update(cartItem);
			System.out.println(cartItem1.get(0).getProduct().getpImage());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

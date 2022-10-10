package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.connect;
import entity.Cart;
import entity.CartItem;
import entity.Order;
import entity.OrderStatus;
import entity.Product1;
import entity.Shop;
import entity.User;

public class OrderDao {
	

	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    //dung
	public	void create(Order order) {
		String sql = "INSERT INTO [order](uId, shopId, uName, uPhone, uAddress, status, amountFromUser, createAt) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, DEFAULT)";
		try {
		conn = new connect().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, order.getUser().getuId());
		ps.setInt(2, order.getShop().getShopId());
		ps.setString(3, order.getuName());
		ps.setString(4, order.getuPhone());
		ps.setString(5, order.getuAddress());
		ps.setInt(6, order.getStatus().getIdStatus());
		ps.setFloat(7, order.getAmountFromUser());
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}

	public void update(Order order) {
		String sql = "UPDATE [order] SET uId = ?, shopId = ?, uName = ?, uPhone = ?, uAddress = ? "
				+ ", status = ?, amountFromUser=?, createAt=DEFAULT WHERE orderId = ?";
				try {
					conn = new connect().getConnection();
					PreparedStatement ps = conn.prepareStatement(sql);
				
					ps.setInt(1, order.getUser().getuId());
					ps.setInt(2, order.getShop().getShopId());
					ps.setString(3, order.getuName());
					ps.setString(4, order.getuPhone());
					ps.setString(5, order.getuAddress());
					ps.setInt(6, order.getStatus().getIdStatus());
					ps.setFloat(7, order.getAmountFromUser());
					ps.setInt(8, order.getOrderId());
				ps.executeUpdate();
				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
	}

	public void delete() {
		String sql = "DELETE FROM cart WHERE EXISTS(\r\n"
				+ "	Select * From cart \r\n"
				+ "	left join cartItems on cart.cartId = cartItems.cartId\r\n"
				+ "	where cartItems.cartId is null)";
		try {
		conn = new connect().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}

	//dung
	public Order findOne(int id) {
		String sql = "SELECT * FROM [order] WHERE orderId = ? ";
		try {
		conn = new connect().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			UserDao userDao = new UserDao();
			ShopDao shopDao = new ShopDao();
			OrderStatusDao orderStatusDao = new OrderStatusDao();
			User user = userDao.get(rs.getInt("uId"));
			Shop shop = shopDao.findOne(rs.getInt("shopId"));
			OrderStatus orderStatus = orderStatusDao.findOne(rs.getInt("status"));
			
			Order order = new Order();
			order.setOrderId(rs.getInt("orderId"));
			order.setUser(user);
			order.setShop(shop);
			order.setuName(rs.getString("uName"));
			order.setuPhone(rs.getString("uPhone"));
			order.setuAddress(rs.getString("uAddress"));
			order.setStatus(orderStatus);
			order.setAmountFromUser(rs.getFloat("amountFromUser"));
			order.setCreateAt(rs.getDate("createAt"));
			return order;
		}} catch (Exception e) {
		e.printStackTrace();}
		return null;
	}

	public List<Cart> findAll() {
		List<Cart> carts = new ArrayList<Cart>();
		String sql = "SELECT * FROM Cart";
		try {
		conn = new connect().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		UserDao userDao = new UserDao();
		ShopDao shopDao = new ShopDao();
		User user = userDao.get(rs.getInt("uId"));
		Shop shops = shopDao.findOne(rs.getInt("shopId"));
		
		Cart cart = new Cart();
		cart.setCartId(rs.getInt("cartId"));
		cart.setUser(user);
		cart.setShop(shops);
		carts.add(cart);
		}} catch (Exception e) {
		e.printStackTrace();}
		return carts;
	}

	public List<Cart> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//dung
	public Order findOneNew() {
		String sql ="Select Top 1 * from [order] order by orderId DESC ";
		try {
		conn = new connect().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			UserDao userDao = new UserDao();
			ShopDao shopDao = new ShopDao();
			User user = userDao.get(rs.getInt("uId"));
			Shop shop = shopDao.findOne(rs.getInt("shopId"));
			OrderStatusDao orderStatusDao = new OrderStatusDao();
			OrderStatus orderStatus = orderStatusDao.findOne(rs.getInt("status"));
			Order order = new Order();
			order.setOrderId(rs.getInt("orderId"));
			order.setUser(user);
			order.setShop(shop);
			order.setuName(rs.getString("uName"));
			order.setuPhone(rs.getString("uPhone"));
			order.setuAddress(rs.getString("uAddress"));
			order.setStatus(orderStatus);
			order.setAmountFromUser(rs.getFloat("amountFromUser"));
			order.setCreateAt(rs.getDate("createAt"));
			return order;
		}} catch (Exception e) {
		e.printStackTrace();}
		return null;
	}
	//dung
	public Order findOneUserAndShop(User user, Shop shop) {
		String sql = "SELECT Top 1 * FROM [order] WHERE [uId] = ? and shopId = ? order by orderId DESC";
		try {
		conn = new connect().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,user.getuId());
		ps.setInt(2, shop.getShopId());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			OrderStatusDao orderStatusDao = new OrderStatusDao();
			OrderStatus orderStatus = orderStatusDao.findOne(rs.getInt("status"));
			
			Order order = new Order();
			order.setOrderId(rs.getInt("orderId"));
			order.setUser(user);
			order.setShop(shop);
			order.setuName(rs.getString("uName"));
			order.setuPhone(rs.getString("uPhone"));
			order.setuAddress(rs.getString("uAddress"));
			order.setStatus(orderStatus);
			order.setAmountFromUser(rs.getFloat("amountFromUser"));
			order.setCreateAt(rs.getDate("createAt"));
			return order;
		}} catch (Exception e) {
		e.printStackTrace();}
		return null;
	}
	public static void main(String[] args) {
		try {
			OrderDao orderDao = new OrderDao();
			ProductDao productDao = new ProductDao();
			ShopDao shopDao = new  ShopDao();
			Shop shop = shopDao.findOne(1);
			UserDao userDao = new  UserDao();
			User user = userDao.get(3);
			CartDao cartDao = new CartDao();
			//Cart cart = cartDao.findOneUserAndShop(user, shop);
			Cart cart = cartDao.findOne(1);
			Product1 product = productDao.findOne(1);
			CartItem cartItem = new CartItem();
			cartItem.setId(1);
			cartItem.setCart(cart);
			cartItem.setProduct(product);
			cartItem.setCount(3);
			cartItem.setTotalPrice(product.getpPrice()*3);
			Order order = new Order();
			order = orderDao.findOneUserAndShop(user, shop);
			//order.setAmountFromUser(0);
			//orderDao.update(order);
			System.out.println(order.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


}

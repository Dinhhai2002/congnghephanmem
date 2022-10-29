package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.connect;
import entity.Cart;
import entity.Shop;
import entity.User;

public class CartDao {

	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    //dung
	public	void create(User user, Shop shop) {
		String sql = "INSERT INTO cart(uId, shopId) VALUES (?,?)";
		try {
		conn = new connect().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		//UserDao userDao = new UserDao();
		//ShopDao shopDao = new ShopDao();
		//User user = userDao.get(rs.getInt("uId"));
		//Shop shop = shopDao.findOne(rs.getInt("shopId"));
		ps.setInt(1, user.getuId());
		ps.setInt(2, shop.getShopId());
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}

	public void update(Cart cart) {
		String sql = "UPDATE cart SET uId = ?, shopId = ? WHERE cartId = ?";
				try {
				conn = new connect().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				UserDao userDao = new UserDao();
				ShopDao shopDao = new ShopDao();
				User user = userDao.get(rs.getInt("uId"));
				Shop shop = shopDao.findOne(rs.getInt("shopId"));
				
				ps.setInt(1, user.getuId());
				ps.setInt(2, shop.getShopId());
				ps.setInt(2, cart.getCartId());
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
	public Cart findOne(int id) {
		String sql = "SELECT * FROM cart WHERE cartId = ? ";
		try {
		conn = new connect().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			UserDao userDao = new UserDao();
			ShopDao shopDao = new ShopDao();
			User user = userDao.get(rs.getInt("uId"));
			Shop shop = shopDao.findOne(rs.getInt("shopId"));
			
			Cart cart = new Cart();
			cart.setCartId(rs.getInt("cartId"));
			cart.setUser(user);
			cart.setShop(shop);
			return cart;
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
	
	public List<Integer> findAllIdCart() {
		int id;
		List<Integer> carts = new ArrayList<Integer>();
		String sql = "SELECT * FROM Cart";
		try {
		conn = new connect().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		id = rs.getInt("cartId");
		carts.add(id);
		}} catch (Exception e) {
		e.printStackTrace();}
		return carts;
	}

	public List<Cart> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//dung
	public Cart findOneNew() {
		String sql ="Select Top 1 * from cart order by cartId DESC";
		try {
		conn = new connect().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			UserDao userDao = new UserDao();
			ShopDao shopDao = new ShopDao();
			User user = userDao.get(rs.getInt("uId"));
			Shop shop = shopDao.findOne(rs.getInt("shopId"));
			
			Cart cart = new Cart();
			cart.setCartId(rs.getInt("cartId"));
			cart.setUser(user);
			cart.setShop(shop);
			return cart;
		}} catch (Exception e) {
		e.printStackTrace();}
		return null;
	}
	//dung
	public Cart findOneUserAndShop(User user, Shop shop) {
		String sql = "SELECT * FROM cart WHERE [uId] = ? and shopId = ?";
		try {
		conn = new connect().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,user.getuId());
		ps.setInt(2, shop.getShopId());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			
			Cart cart = new Cart();
			cart.setCartId(rs.getInt("cartId"));
			cart.setUser(user);
			cart.setShop(shop);
			return cart;
		}} catch (Exception e) {
		e.printStackTrace();}
		return null;
	}


}

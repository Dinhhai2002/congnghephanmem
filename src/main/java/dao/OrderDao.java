package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.connect;
import entity.Cart;
import entity.CartItem;
import entity.Category;
import entity.Order;
import entity.OrderStatus;
import entity.Product;
import entity.Shop;
import entity.User;

public class OrderDao {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// dung
	public void create(Order order) {
		String sql = "INSERT INTO [order](uId, shopId, uName, uPhone, uAddress, isPaidBefore, amountFromUser, amountFromShop,amountToShop,amountToShipper, createAt) "
				+ "VALUES (?, ?, ?, ?, ?, ?,?, ?,?,?, DEFAULT)";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, order.getUser().getuId());
			ps.setInt(2, order.getShop().getShopId());
			ps.setString(3, order.getuName());
			
			ps.setString(4, order.getuPhone());
			ps.setString(5, order.getuAddress());
			ps.setBoolean(6, order.isPaidBefore());
			ps.setFloat(7, order.getAmountFromUser());
			ps.setFloat(8, order.getAmountFromShop());
			ps.setFloat(9, order.getAmountToShop());
			ps.setFloat(10, order.getAmountToShipper());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void update(Order order) {
		String sql = "UPDATE [order] SET uId = ?, shopId = ?, uName = ?,delivery=?, uPhone = ?, uAddress = ? "
				+ ", isPaidBefore = ?, amountFromUser=?,amountFromShop=?,amountToShop=?, amountToShipper=?, createAt=DEFAULT WHERE orderId = ?";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, order.getUser().getuId());
			ps.setInt(2, order.getShop().getShopId());
			ps.setString(3, order.getuName());
			ps.setInt(4, order.getDelivery().getuId());
			ps.setString(5, order.getuPhone());
			ps.setString(6, order.getuAddress());
			ps.setBoolean(7, order.isPaidBefore());
			ps.setFloat(8, order.getAmountFromUser());
			ps.setFloat(9, order.getAmountFromShop());
			ps.setFloat(10, order.getAmountToShop());
			ps.setFloat(11, order.getAmountToShipper());
			ps.setInt(12, order.getOrderId());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete() {
		String sql = "DELETE FROM [order] WHERE EXISTS(Select * From [order] left join orderdetail on [order].orderId = orderdetail.orderId\r\n"
				+ "	where orderdetail.orderId is null)";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// dung
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
				User user = userDao.get(rs.getInt("uId"));
				User shipper = userDao.get(rs.getInt("deliveryId"));
				Shop shop = shopDao.findOne(rs.getInt("shopId"));

				Order order = new Order();
				order.setOrderId(rs.getInt("orderId"));
				order.setUser(user);
				order.setShop(shop);
				order.setuName(rs.getString("uName"));
				order.setDelivery(shipper);
				order.setuPhone(rs.getString("uPhone"));
				order.setuAddress(rs.getString("uAddress"));
				order.setPaidBefore(rs.getBoolean("isPaidBefore"));
				order.setAmountFromUser(rs.getFloat("amountFromUser"));
				order.setAmountFromShop(rs.getFloat("amountFromShop"));
				order.setAmountToShop(rs.getFloat("amountToShop"));
				order.setAmountToShipper(rs.getFloat("amountToShipper"));
				order.setCreateAt(rs.getDate("createAt"));
				return order;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Lấy tất cả đơn hàng của user hiện có
	public List<Order> findAllByuid(User user) {
		List<Order> orders = new ArrayList<Order>();
		String sql = "  Select orderdetail.productId, [order].status From [order] \r\n"
				+ "	inner join orderdetail on [order].orderId=orderdetail.orderId\r\n" + "	where [order].uId=?";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getuId());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserDao userDao = new UserDao();
				ShopDao shopDao = new ShopDao();
				user = userDao.get(rs.getInt("uId"));
				Shop shop = shopDao.findOne(rs.getInt("shopId"));

				Order order = new Order();
				order.setOrderId(rs.getInt("orderId"));
				order.setUser(user);
				order.setShop(shop);
				order.setuName(rs.getString("uName"));
				order.setuPhone(rs.getString("uPhone"));
				order.setuAddress(rs.getString("uAddress"));
				order.setPaidBefore(rs.getBoolean("isPaidBefore"));
				order.setAmountFromUser(rs.getFloat("amountFromUser"));
				order.setAmountFromShop(rs.getFloat("amountFromShop"));
				order.setAmountToShop(rs.getFloat("amountToShop"));
				order.setAmountToShipper(rs.getFloat("amountToShipper"));
				order.setCreateAt(rs.getDate("createAt"));
				orders.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}

	
	

	public List<Cart> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	// dung
	public Order findOneNew() {
		String sql = "Select Top 1 * from [order] order by orderId DESC";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserDao userDao = new UserDao();
				ShopDao shopDao = new ShopDao();
				User user = userDao.get(rs.getInt("uId"));
				User shipper = userDao.get(rs.getInt("deliveryId"));
				Shop shop = shopDao.findOne(rs.getInt("shopId"));
				Order order = new Order();
				order.setOrderId(rs.getInt("orderId"));
				order.setUser(user);
				order.setShop(shop);
				order.setuName(rs.getString("uName"));
				order.setDelivery(shipper);
				order.setuPhone(rs.getString("uPhone"));
				order.setuAddress(rs.getString("uAddress"));
				order.setPaidBefore(rs.getBoolean("isPaidBefore"));
				order.setAmountFromUser(rs.getFloat("amountFromUser"));
				order.setAmountFromShop(rs.getFloat("amountFromShop"));
				order.setAmountToShop(rs.getFloat("amountToShop"));
				order.setAmountToShipper(rs.getFloat("amountToShipper"));
				order.setCreateAt(rs.getDate("createAt"));
				return order;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// dung
	public Order findOneUserAndShop(User user, Shop shop) {
		String sql = "SELECT Top 1 * FROM [order] WHERE [uId] = ? and shopId = ? order by orderId DESC";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getuId());
			ps.setInt(2, shop.getShopId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserDao userDao = new UserDao();
				User shipper = userDao.get(rs.getInt("deliveryId"));
				Order order = new Order();
				order.setOrderId(rs.getInt("orderId"));
				order.setUser(user);
				order.setShop(shop);
				order.setuName(rs.getString("uName"));
				order.setDelivery(shipper);
				order.setuPhone(rs.getString("uPhone"));
				order.setuAddress(rs.getString("uAddress"));
				order.setPaidBefore(rs.getBoolean("isPaidBefore"));
				order.setAmountFromUser(rs.getFloat("amountFromUser"));
				order.setAmountFromShop(rs.getFloat("amountFromShop"));
				order.setAmountToShop(rs.getFloat("amountToShop"));
				order.setAmountToShipper(rs.getFloat("amountToShipper"));
				order.setCreateAt(rs.getDate("createAt"));
				return order;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int findIdOrder() {
		String sql = "select [order].orderId from [order] order by [order].orderId DESC";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				return rs.getInt(1)+1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static void main(String[] args) {
		try {
			OrderDao orderDao = new OrderDao();
			ProductDao productDao = new ProductDao();
			ShopDao shopDao = new ShopDao();
			Shop shop = shopDao.findOne(1);
			UserDao userDao = new UserDao();
			User user = userDao.get(3);
			CartDao cartDao = new CartDao();
			// Cart cart = cartDao.findOneUserAndShop(user, shop);
			Cart cart = cartDao.findOne(1);
			Product product = productDao.findOne(1);
			CartItem cartItem = new CartItem();
			cartItem.setId(1);
			cartItem.setCart(cart);
			cartItem.setProduct(product);
			cartItem.setCount(3);
			cartItem.setTotalPrice(product.getpPrice() * 3);
			Order order = new Order();
			// List<Order> listO = orderDao.findAll();
			// order.setAmountFromUser(0);
			// orderDao.update(order);
			 System.out.println(orderDao.findIdOrder());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

}

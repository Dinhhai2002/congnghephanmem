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
import entity.OrderDetail;
import entity.OrderStatus;
import entity.Product;
import entity.Shop;
import entity.User;

public class OrderDetailDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public void create(OrderDetail orderDetail) {
		String sql = "INSERT INTO [orderdetail](orderId, productId,[count],shipPrice, [totalPrice],[status],createAt)\r\n"
				+ "				VALUES (?, ?, ?, ?, ?, ?, DEFAULT)";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, orderDetail.getOrder().getOrderId());
			ps.setInt(2, orderDetail.getProduct().getpId());
			ps.setInt(3, orderDetail.getCount());
			ps.setFloat(4, orderDetail.getShipPrice());
			ps.setFloat(5, orderDetail.getTotalPrice());
			ps.setInt(6, orderDetail.getStatus().getIdStatus());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(OrderDetail orderDetail) {
		String sql = "UPDATE [orderdetail] SET orderId = ?, productId = ?, [count] = ?, shipPrice=?, [totalPrice] = ?, [status] = ? "
				+ ", createAt=DEFAULT WHERE id = ?";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, orderDetail.getOrder().getOrderId());
			ps.setInt(2, orderDetail.getProduct().getpId());
			ps.setInt(3, orderDetail.getCount());
			ps.setFloat(4, orderDetail.getShipPrice());
			ps.setFloat(5, orderDetail.getTotalPrice());
			ps.setInt(6, orderDetail.getStatus().getIdStatus());
			ps.setInt(7, orderDetail.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public OrderDetail findOne(int id) {
		String sql = "SELECT * FROM [orderdetail] WHERE id = ? ";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderDao orderDao = new OrderDao();
				ProductDao productDao = new ProductDao();
				OrderStatusDao orderStatusDao = new OrderStatusDao();

				Order order = orderDao.findOne(rs.getInt("orderId"));
				Product product = productDao.findOne(rs.getInt("productId"));
				OrderStatus orderStatus = orderStatusDao.findOne(rs.getInt("status"));
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setId(id);
				orderDetail.setOrder(order);
				orderDetail.setProduct(product);
				orderDetail.setCount(rs.getInt("count"));
				orderDetail.setCount(rs.getInt("shipPrice"));
				orderDetail.setTotalPrice(rs.getInt("totalPrice"));
				orderDetail.setStatus(orderStatus);
				orderDetail.setCreateAt(rs.getDate("createAt"));
				return orderDetail;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * public int count (User user) { String sql =
	 * "Select COUNT(*)as [count] From [order]\r\n" +
	 * "  				inner join orderdetail on [order].orderId=orderdetail.orderId\r\n"
	 * + "  				where [order].uId=?"; try { conn = new
	 * connect().getConnection(); PreparedStatement ps = conn.prepareStatement(sql);
	 * ps.setInt(1, user.getuId()); ResultSet rs = ps.executeQuery(); while
	 * (rs.next()) { int x = rs.getInt(0); return x; } } catch (Exception e) {
	 * e.printStackTrace(); } return 7; }
	 */

	// Lấy tất cả đơn hàng của user hiện có
	public List<OrderDetail> findAllByuid(User user) {
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		String sql = "Select Top 3 * From [order] \r\n"
				+ "	inner join orderdetail on [order].orderId=orderdetail.orderId\r\n" + "	where [order].uId=?";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getuId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderDao orderDao = new OrderDao();
				ProductDao productDao = new ProductDao();
				OrderStatusDao orderStatusDao = new OrderStatusDao();

				Order order = orderDao.findOne(rs.getInt("orderId"));
				Product product = productDao.findOne(rs.getInt("productId"));
				OrderStatus orderStatus = orderStatusDao.findOne(rs.getInt("status"));

				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setId(rs.getInt("id"));
				orderDetail.setOrder(order);
				orderDetail.setProduct(product);
				orderDetail.setCount(rs.getInt("count"));
				orderDetail.setCount(rs.getInt("shipPrice"));
				orderDetail.setTotalPrice(rs.getInt("totalPrice"));
				orderDetail.setStatus(orderStatus);
				orderDetail.setCreateAt(rs.getDate("createAt"));
				orderDetails.add(orderDetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderDetails;
	}

	
	public List<OrderDetail> findAllByShopId(Shop shop) {
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		String sql = "Select Top 6 * From [order] inner join orderdetail on [order].orderId=orderdetail.orderId where [order].shopId=?";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, shop.getShopId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderDao orderDao = new OrderDao();
				ProductDao productDao = new ProductDao();
				OrderStatusDao orderStatusDao = new OrderStatusDao();

				Order order = orderDao.findOne(rs.getInt("orderId"));
				Product product = productDao.findOne(rs.getInt("productId"));
				OrderStatus orderStatus = orderStatusDao.findOne(rs.getInt("status"));

				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setId(rs.getInt("id"));
				orderDetail.setOrder(order);
				orderDetail.setProduct(product);
				orderDetail.setCount(rs.getInt("count"));
				orderDetail.setCount(rs.getInt("shipPrice"));
				orderDetail.setTotalPrice(rs.getInt("totalPrice"));
				orderDetail.setStatus(orderStatus);
				orderDetail.setCreateAt(rs.getDate("createAt"));
				orderDetails.add(orderDetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderDetails;
	}
	
	public List<OrderDetail> findAllByProductId(int pId) {
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		String sql = "Select * From [order] inner join orderdetail on [order].orderId=orderdetail.orderId where [orderdetail].productId=?";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderDao orderDao = new OrderDao();
				ProductDao productDao = new ProductDao();
				OrderStatusDao orderStatusDao = new OrderStatusDao();

				Order order = orderDao.findOne(rs.getInt("orderId"));
				Product product = productDao.findOne(rs.getInt("productId"));
				OrderStatus orderStatus = orderStatusDao.findOne(rs.getInt("status"));

				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setId(rs.getInt("id"));
				orderDetail.setOrder(order);
				orderDetail.setProduct(product);
				orderDetail.setCount(rs.getInt("count"));
				orderDetail.setCount(rs.getInt("shipPrice"));
				orderDetail.setTotalPrice(rs.getInt("totalPrice"));
				orderDetail.setStatus(orderStatus);
				orderDetail.setCreateAt(rs.getDate("createAt"));
				orderDetails.add(orderDetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderDetails;
	}

	public List<OrderDetail> deleteOrderByProductId(int pId) {
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		String sql = "delete from [orderdetail] where [orderdetail].[productId]= ?";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pId);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderDetails;
	}

	public int countStatusByIdStatus(int status){
		String query = "Select count(status) From [orderdetail] where [status]=?";
		try {
			conn = new connect().getConnection();
	         ps = conn.prepareStatement(query);
	         ps.setInt(1, status);
	         rs = ps.executeQuery();
	         while (rs.next()) {
	          	return rs.getInt(1);
	          }
	 		} catch (Exception e) {
	 			// TODO: handle exception
	 		}
	 	return -1;
	}
	public List<OrderDetail> findNext3Order(User user, int amount) {

		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		String sql = "Select * From [order] \r\n"
				+ "	inner join orderdetail on [order].orderId=orderdetail.orderId where [order].uId=?\r\n"
				+ "	ORDER BY orderdetail.id OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getuId());
			ps.setInt(2, amount);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderDao orderDao = new OrderDao();
				ProductDao productDao = new ProductDao();
				OrderStatusDao orderStatusDao = new OrderStatusDao();

				Order order = orderDao.findOne(rs.getInt("orderId"));
				Product product = productDao.findOne(rs.getInt("productId"));
				OrderStatus orderStatus = orderStatusDao.findOne(rs.getInt("status"));

				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setId(rs.getInt("id"));
				orderDetail.setOrder(order);
				orderDetail.setProduct(product);
				orderDetail.setCount(rs.getInt("count"));
				orderDetail.setCount(rs.getInt("shipPrice"));
				orderDetail.setTotalPrice(rs.getInt("totalPrice"));
				orderDetail.setStatus(orderStatus);
				orderDetail.setCreateAt(rs.getDate("createAt"));
				orderDetails.add(orderDetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderDetails;
	}
	
	public List<OrderDetail> findNext3OrderOfShop(Shop shop, int amount) {
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		String sql = "Select * From [order] \r\n"
				+ "	inner join orderdetail on [order].orderId=orderdetail.orderId where [order].shopId=?\r\n"
				+ "	ORDER BY orderdetail.id OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, shop.getShopId());
			ps.setInt(2, amount);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderDao orderDao = new OrderDao();
				ProductDao productDao = new ProductDao();
				OrderStatusDao orderStatusDao = new OrderStatusDao();

				Order order = orderDao.findOne(rs.getInt("orderId"));
				Product product = productDao.findOne(rs.getInt("productId"));
				OrderStatus orderStatus = orderStatusDao.findOne(rs.getInt("status"));

				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setId(rs.getInt("id"));
				orderDetail.setOrder(order);
				orderDetail.setProduct(product);
				orderDetail.setCount(rs.getInt("count"));
				orderDetail.setCount(rs.getInt("shipPrice"));
				orderDetail.setTotalPrice(rs.getInt("totalPrice"));
				orderDetail.setStatus(orderStatus);
				orderDetail.setCreateAt(rs.getDate("createAt"));
				orderDetails.add(orderDetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderDetails;
	}
	
	public List<OrderDetail> findAllByStatus(int status) {
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		String sql = "Select Top 6 * From [order]\r\n"
				+ "inner join orderdetail on [order].orderId=orderdetail.orderId\r\n"
				+ "where orderdetail.status=?";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, status);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderDao orderDao = new OrderDao();
				ProductDao productDao = new ProductDao();
				OrderStatusDao orderStatusDao = new OrderStatusDao();

				Order order = orderDao.findOne(rs.getInt("orderId"));
				Product product = productDao.findOne(rs.getInt("productId"));
				OrderStatus orderStatus = orderStatusDao.findOne(rs.getInt("status"));

				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setId(rs.getInt("id"));
				orderDetail.setOrder(order);
				orderDetail.setProduct(product);
				orderDetail.setCount(rs.getInt("count"));
				orderDetail.setCount(rs.getInt("shipPrice"));
				orderDetail.setTotalPrice(rs.getInt("totalPrice"));
				orderDetail.setStatus(orderStatus);
				orderDetail.setCreateAt(rs.getDate("createAt"));
				orderDetails.add(orderDetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderDetails;
	}

	public List<OrderDetail> findAllByStatusOfUser(User user, int status) {
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		String sql = "Select Top 3 * From [order]\r\n"
				+ "inner join orderdetail on [order].orderId=orderdetail.orderId\r\n"
				+ "where [order].uId=?  and orderdetail.status=?";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getuId());
			ps.setInt(2, status);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderDao orderDao = new OrderDao();
				ProductDao productDao = new ProductDao();
				OrderStatusDao orderStatusDao = new OrderStatusDao();

				Order order = orderDao.findOne(rs.getInt("orderId"));
				Product product = productDao.findOne(rs.getInt("productId"));
				OrderStatus orderStatus = orderStatusDao.findOne(rs.getInt("status"));

				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setId(rs.getInt("id"));
				orderDetail.setOrder(order);
				orderDetail.setProduct(product);
				orderDetail.setCount(rs.getInt("count"));
				orderDetail.setCount(rs.getInt("shipPrice"));
				orderDetail.setTotalPrice(rs.getInt("totalPrice"));
				orderDetail.setStatus(orderStatus);
				orderDetail.setCreateAt(rs.getDate("createAt"));
				orderDetails.add(orderDetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderDetails;
	}
	public List<OrderDetail> findNext3OrderOfUser(User user, int amount) {
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		String sql = "Select * From [order] \r\n"
				+ "	inner join orderdetail on [order].orderId=orderdetail.orderId where [order].uId=?\r\n"
				+ "	ORDER BY orderdetail.id OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getuId());
			ps.setInt(2, amount);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderDao orderDao = new OrderDao();
				ProductDao productDao = new ProductDao();
				OrderStatusDao orderStatusDao = new OrderStatusDao();

				Order order = orderDao.findOne(rs.getInt("orderId"));
				Product product = productDao.findOne(rs.getInt("productId"));
				OrderStatus orderStatus = orderStatusDao.findOne(rs.getInt("status"));

				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setId(rs.getInt("id"));
				orderDetail.setOrder(order);
				orderDetail.setProduct(product);
				orderDetail.setCount(rs.getInt("count"));
				orderDetail.setCount(rs.getInt("shipPrice"));
				orderDetail.setTotalPrice(rs.getInt("totalPrice"));
				orderDetail.setStatus(orderStatus);
				orderDetail.setCreateAt(rs.getDate("createAt"));
				orderDetails.add(orderDetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderDetails;
	}
	
	public List<OrderDetail> findAllByStatusOfShipper(User user, int status) {
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		String sql = "Select Top 3 * From [order]\r\n"
				+ "inner join orderdetail on [order].orderId=orderdetail.orderId\r\n"
				+ "where [order].deliveryId=?  and orderdetail.status=?";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getuId());
			ps.setInt(2, status);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderDao orderDao = new OrderDao();
				ProductDao productDao = new ProductDao();
				OrderStatusDao orderStatusDao = new OrderStatusDao();

				Order order = orderDao.findOne(rs.getInt("orderId"));
				Product product = productDao.findOne(rs.getInt("productId"));
				OrderStatus orderStatus = orderStatusDao.findOne(rs.getInt("status"));

				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setId(rs.getInt("id"));
				orderDetail.setOrder(order);
				orderDetail.setProduct(product);
				orderDetail.setCount(rs.getInt("count"));
				orderDetail.setCount(rs.getInt("shipPrice"));
				orderDetail.setTotalPrice(rs.getInt("totalPrice"));
				orderDetail.setStatus(orderStatus);
				orderDetail.setCreateAt(rs.getDate("createAt"));
				orderDetails.add(orderDetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderDetails;
	}
	
	public List<OrderDetail> findAllByStatusOfShop(Shop shop, int status) {
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		String sql = "Select Top 6 * From [order]\r\n"
				+ "inner join orderdetail on [order].orderId=orderdetail.orderId\r\n"
				+ "where [order].shopId=?  and orderdetail.status=?";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, shop.getShopId());
			ps.setInt(2, status);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderDao orderDao = new OrderDao();
				ProductDao productDao = new ProductDao();
				OrderStatusDao orderStatusDao = new OrderStatusDao();

				Order order = orderDao.findOne(rs.getInt("orderId"));
				Product product = productDao.findOne(rs.getInt("productId"));
				OrderStatus orderStatus = orderStatusDao.findOne(rs.getInt("status"));

				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setId(rs.getInt("id"));
				orderDetail.setOrder(order);
				orderDetail.setProduct(product);
				orderDetail.setCount(rs.getInt("count"));
				orderDetail.setCount(rs.getInt("shipPrice"));
				orderDetail.setTotalPrice(rs.getInt("totalPrice"));
				orderDetail.setStatus(orderStatus);
				orderDetail.setCreateAt(rs.getDate("createAt"));
				orderDetails.add(orderDetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderDetails;
	}

//Select Top 4 * From [orderdetail] order by id DESC
	public List<OrderDetail> findNext3OrderByStatus(User user, int status, int amount) {
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		String sql = " Select * From [order] \r\n"
				+ "	inner join orderdetail on [order].orderId=orderdetail.orderId\r\n"
				+ "	where [order].uId= ? and orderdetail.status= ?  ORDER BY orderdetail.id OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getuId());
			ps.setInt(2, status);
			ps.setInt(3, amount);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderDao orderDao = new OrderDao();
				ProductDao productDao = new ProductDao();
				OrderStatusDao orderStatusDao = new OrderStatusDao();

				Order order = orderDao.findOne(rs.getInt("orderId"));
				Product product = productDao.findOne(rs.getInt("productId"));
				OrderStatus orderStatus = orderStatusDao.findOne(rs.getInt("status"));

				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setId(rs.getInt("id"));
				orderDetail.setOrder(order);
				orderDetail.setProduct(product);
				orderDetail.setCount(rs.getInt("count"));
				orderDetail.setCount(rs.getInt("shipPrice"));
				orderDetail.setTotalPrice(rs.getInt("totalPrice"));
				orderDetail.setStatus(orderStatus);
				orderDetail.setCreateAt(rs.getDate("createAt"));
				orderDetails.add(orderDetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderDetails;
	}

	
	public List<OrderDetail> findNext3ShipperOrderByStatus(User user, int status, int amount) {
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		String sql = " Select * From [order] \r\n"
				+ "	inner join orderdetail on [order].orderId=orderdetail.orderId\r\n"
				+ "	where [order].deliveryId= ? and orderdetail.status= ?  ORDER BY orderdetail.id OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getuId());
			ps.setInt(2, status);
			ps.setInt(3, amount);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderDao orderDao = new OrderDao();
				ProductDao productDao = new ProductDao();
				OrderStatusDao orderStatusDao = new OrderStatusDao();

				Order order = orderDao.findOne(rs.getInt("orderId"));
				Product product = productDao.findOne(rs.getInt("productId"));
				OrderStatus orderStatus = orderStatusDao.findOne(rs.getInt("status"));

				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setId(rs.getInt("id"));
				orderDetail.setOrder(order);
				orderDetail.setProduct(product);
				orderDetail.setCount(rs.getInt("count"));
				orderDetail.setCount(rs.getInt("shipPrice"));
				orderDetail.setTotalPrice(rs.getInt("totalPrice"));
				orderDetail.setStatus(orderStatus);
				orderDetail.setCreateAt(rs.getDate("createAt"));
				orderDetails.add(orderDetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderDetails;
	}


	// select all order status
	
	
	public List<OrderDetail> find7OrderArrByCreateAt() {
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		String sql = " Select top 7 * From [order] \r\n"
				+ "	inner join orderdetail on [order].orderId=orderdetail.orderId\r\n"
				+ "	order by [order].[createAt] DESC";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderDao orderDao = new OrderDao();
				ProductDao productDao = new ProductDao();
				OrderStatusDao orderStatusDao = new OrderStatusDao();

				Order order = orderDao.findOne(rs.getInt("orderId"));
				Product product = productDao.findOne(rs.getInt("productId"));
				OrderStatus orderStatus = orderStatusDao.findOne(rs.getInt("status"));

				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setId(rs.getInt("id"));
				orderDetail.setOrder(order);
				orderDetail.setProduct(product);
				orderDetail.setCount(rs.getInt("count"));
				orderDetail.setCount(rs.getInt("shipPrice"));
				orderDetail.setTotalPrice(rs.getInt("totalPrice"));
				orderDetail.setStatus(orderStatus);
				orderDetail.setCreateAt(rs.getDate("createAt"));
				orderDetails.add(orderDetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderDetails;
	}
	public List<OrderDetail> findAllOrderArrByCreateAt() {
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		String sql = " Select * From [order] \r\n"
				+ "	inner join orderdetail on [order].orderId=orderdetail.orderId\r\n"
				+ "	order by [order].[createAt] DESC";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderDao orderDao = new OrderDao();
				ProductDao productDao = new ProductDao();
				OrderStatusDao orderStatusDao = new OrderStatusDao();

				Order order = orderDao.findOne(rs.getInt("orderId"));
				Product product = productDao.findOne(rs.getInt("productId"));
				OrderStatus orderStatus = orderStatusDao.findOne(rs.getInt("status"));

				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setId(rs.getInt("id"));
				orderDetail.setOrder(order);
				orderDetail.setProduct(product);
				orderDetail.setCount(rs.getInt("count"));
				orderDetail.setCount(rs.getInt("shipPrice"));
				orderDetail.setTotalPrice(rs.getInt("totalPrice"));
				orderDetail.setStatus(orderStatus);
				orderDetail.setCreateAt(rs.getDate("createAt"));
				orderDetails.add(orderDetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderDetails;
	}
	

	public List<OrderDetail> findNext3ShopOrderByStatus(Shop shop, int status, int amount) {
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		String sql = " Select * From [order] \r\n"
				+ "	inner join orderdetail on [order].orderId=orderdetail.orderId\r\n"
				+ "	where [order].shopId= ? and orderdetail.status= ?  ORDER BY orderdetail.id OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, shop.getShopId());
			ps.setInt(2, status);
			ps.setInt(3, amount);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderDao orderDao = new OrderDao();
				ProductDao productDao = new ProductDao();
				OrderStatusDao orderStatusDao = new OrderStatusDao();

				Order order = orderDao.findOne(rs.getInt("orderId"));
				Product product = productDao.findOne(rs.getInt("productId"));
				OrderStatus orderStatus = orderStatusDao.findOne(rs.getInt("status"));

				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setId(rs.getInt("id"));
				orderDetail.setOrder(order);
				orderDetail.setProduct(product);
				orderDetail.setCount(rs.getInt("count"));
				orderDetail.setCount(rs.getInt("shipPrice"));
				orderDetail.setTotalPrice(rs.getInt("totalPrice"));
				orderDetail.setStatus(orderStatus);
				orderDetail.setCreateAt(rs.getDate("createAt"));
				orderDetails.add(orderDetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderDetails;
	}

	

	//update status
	public void update(int id, int idStatus) {
		String sql = "UPDATE [orderdetail] SET [status] = ? "
				+ ", createAt=DEFAULT WHERE id = ?";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idStatus);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateShipper(User user, int id) {
		String sql = "UPDATE [order] SET deliveryId = ? WHERE orderId = ?";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getuId());
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int count(int status){
		String query = "SELECT COUNT(*) FROM orderdetail \r\n"
				+ "Where orderdetail.status = ?";
		try {
			conn = new connect().getConnection();
	         ps = conn.prepareStatement(query);
	         ps.setInt(1, status);
	         rs = ps.executeQuery();
	         while (rs.next()) {
	          	return rs.getInt(1);
	          }
	 		} catch (Exception e) {
	 			// TODO: handle exception
	 		}
	 	return -1;
	}
	
	public static void main(String[] args) {
		try {
			OrderDetailDao orderDetailDao = new OrderDetailDao();
			UserDao userDao = new UserDao();
			User user = userDao.get(3);
			
			List<OrderDetail> listO = orderDetailDao.findAllByuid(user);
			OrderDetail orderDetail = new OrderDetail();
			
			//List<OrderDetail> listO = orderDetailDao.findNext3OrderByStatus(user, 1, 3);
			//order.setAmountFromUser(0);
			//orderDao.update(order);
			System.out.println(orderDetailDao.count(1));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

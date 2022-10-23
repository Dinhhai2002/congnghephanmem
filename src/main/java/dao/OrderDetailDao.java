	package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.connect;
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
    
    public	void create(OrderDetail orderDetail) {
		String sql = "INSERT INTO [orderdetail](orderId, productId,[count],[totalPrice],[status],createAt)\r\n"
				+ "				VALUES (?, ?, ?, ?, ?, DEFAULT)";
		try {
		conn = new connect().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, orderDetail.getOrder().getOrderId());
		ps.setInt(2, orderDetail.getProduct().getpId());
		ps.setInt(3, orderDetail.getCount());
		ps.setFloat(4, orderDetail.getTotalPrice());
		ps.setInt(5, orderDetail.getStatus().getIdStatus());
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
    
    public void update(OrderDetail orderDetail) {
		String sql = "UPDATE [orderdetail] SET orderId = ?, productId = ?, [count] = ?, [totalPrice] = ?, [status] = ? "
				+ ", createAt=DEFAULT WHERE id = ?";
				try {
					conn = new connect().getConnection();
					PreparedStatement ps = conn.prepareStatement(sql);
				
					ps.setInt(1, orderDetail.getOrder().getOrderId());
					ps.setInt(2, orderDetail.getProduct().getpId());
					ps.setInt(3, orderDetail.getCount());
					ps.setFloat(4, orderDetail.getTotalPrice());
					ps.setInt(5, orderDetail.getStatus().getIdStatus());
					ps.setInt(6, orderDetail.getId());
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
			orderDetail.setTotalPrice(rs.getInt("totalPrice"));
			orderDetail.setStatus(orderStatus);
			orderDetail.setCreateAt(rs.getDate("createAt"));
			return orderDetail;
		}} catch (Exception e) {
		e.printStackTrace();}
		return null;
	}
  //Lấy tất cả đơn hàng của user hiện có
  	public List<OrderDetail> findAllByuid(User user) {
  		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
  		String sql = "Select * From [order] \r\n"
  				+ "	inner join orderdetail on [order].orderId=orderdetail.orderId\r\n"
  				+ "	where [order].uId=?";
  		try {
  		conn = new connect().getConnection();
  		PreparedStatement ps = conn.prepareStatement(sql);
  		ps.setInt(1,user.getuId());
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
			orderDetail.setTotalPrice(rs.getInt("totalPrice"));
			orderDetail.setStatus(orderStatus);
			orderDetail.setCreateAt(rs.getDate("createAt"));
			orderDetails.add(orderDetail);
  		}} catch (Exception e) {
  		e.printStackTrace();}
  		return orderDetails;
  	}
  	
  	public List<OrderDetail> findAllByStatus(User user, int status) {
  		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
  		String sql = "Select * From [order] \r\n"
  				+ "	inner join orderdetail on [order].orderId=orderdetail.orderId\r\n"
  				+ "	where [order].uId=? and orderdetail.status=?";
  		try {
  		conn = new connect().getConnection();
  		PreparedStatement ps = conn.prepareStatement(sql);
  		ps.setInt(1,user.getuId());
  		ps.setInt(2,status);
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
			orderDetail.setTotalPrice(rs.getInt("totalPrice"));
			orderDetail.setStatus(orderStatus);
			orderDetail.setCreateAt(rs.getDate("createAt"));
			orderDetails.add(orderDetail);
  		}} catch (Exception e) {
  		e.printStackTrace();}
  		return orderDetails;
  	}
//Select Top 4 * From [orderdetail] order by id DESC

}

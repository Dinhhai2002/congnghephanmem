package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connect.connect;
import entity.Order;
import entity.OrderDetail;

public class OrderDetailDao {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public	void create(OrderDetail orderDetail) {
		String sql = "INSERT INTO [orderdetail](orderId, productId,[count],[totalPrice],createAt)\r\n"
				+ "				VALUES (?, ?, ?, ?, DEFAULT)";
		try {
		conn = new connect().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, orderDetail.getOrder().getOrderId());
		ps.setInt(2, orderDetail.getProduct().getpId());
		ps.setInt(3, orderDetail.getCount());
		ps.setFloat(4, orderDetail.getTotalPrice());
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}

}

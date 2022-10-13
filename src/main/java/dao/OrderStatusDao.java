package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connect.connect;
import entity.Cart;
import entity.CartItem;
import entity.Order;
import entity.OrderStatus;
import entity.Product;
import entity.Shop;
import entity.User;

public class OrderStatusDao {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public OrderStatus findOne(int id) {
		String sql = "SELECT * FROM orderStatus WHERE id = ? ";
		try {
		conn = new connect().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {				
			OrderStatus orderStatus = new OrderStatus();
			orderStatus.setIdStatus(rs.getInt("id"));
			orderStatus.setNameStatus(rs.getString("statusName"));
			return orderStatus;
		}} catch (Exception e) {
		e.printStackTrace();}
		return null;
	}
    
    public static void main(String[] args) {
		try {
			OrderStatusDao orderDao = new OrderStatusDao();
			OrderStatus o = orderDao.findOne(1);
			
			System.out.println(o.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connect.connect;
import entity.Shop;
import entity.User;

public class ShopDao {

	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
 public Shop findOne(int id) {
        //dung
	 String sql = "SELECT * FROM shop WHERE shopId = ? ";
		try {
		conn = new connect().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		Shop shop = new Shop();
		UserDao users = new UserDao();
		
		User user = users.get(rs.getInt("uId"));
		shop.setShopId(rs.getInt("shopId"));
		shop.setShopName(rs.getString("shopName"));
		shop.setUser(user);
		shop.seteWallet(rs.getInt("eWallet"));
		shop.setShopImage(rs.getString("shopImage"));
		shop.setShopDecription(rs.getString("shopDecription"));
		shop.setCreateAt(rs.getDate("createAt"));
		shop.setActive(rs.getBoolean("isActive"));
		shop.setDelete(rs.getBoolean("isDelete"));
		return shop;
		}} catch (Exception e) {
		e.printStackTrace();}
		return null;
    }
 public int getShopIdByuId(int uId) {
		String query = "select shopId from [user] inner join shop on shop.[uId] = [user].[uId]\r\n"
				+ "where [user].[uId] = ?";
		try {
			conn = new connect().getConnection();
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, uId);
	        rs = ps.executeQuery();
	        while (rs.next()) {
	        	return rs.getInt(1);
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}

}

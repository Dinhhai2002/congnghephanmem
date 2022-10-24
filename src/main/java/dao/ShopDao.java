package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connect.connect;
import entity.Category;
import entity.Product;
import entity.Shop;
import entity.User;

public class ShopDao {

	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
 public Shop findOne(int id) {
	 String sql = "SELECT * FROM shop WHERE shopId = ? ";
		try {
		conn = new connect().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		Shop shop = new Shop();
		UserDao users = new UserDao();
		Category category=new Category();
		
		
		User user = users.get(rs.getInt("uId"));
		shop.setShopId(rs.getInt("shopId"));
		shop.setShopName(rs.getString("shopName"));
		shop.setUser(user);
		shop.setCategory(category);
		shop.seteWallet(rs.getInt("eWallet"));
		shop.setShopImage(rs.getString("shopImage"));
		shop.setShopDecription(rs.getString("shopDecription"));
		shop.setShopAddress(rs.getString("shopAddress"));
		shop.setCreateAt(rs.getDate("createAt"));
		shop.setActive(rs.getBoolean("isActive"));
		shop.setDelete(rs.getBoolean("isDelete"));
		return shop;
		}} catch (Exception e) {
		e.printStackTrace();}
		return null;
    }
 public Shop checkNameShop(String shopName) {
     //dung
	 String sql = "SELECT * FROM shop WHERE shopName = ? ";
		try {
		conn = new connect().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, shopName);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		Shop shop = new Shop();
		UserDao users = new UserDao();
		Category category=new Category();
		
		
		User user = users.get(rs.getInt("uId"));
		shop.setShopId(rs.getInt("shopId"));
		shop.setShopName(rs.getString("shopName"));
		shop.setUser(user);
		shop.setCategory(category);
		shop.seteWallet(rs.getInt("eWallet"));
		shop.setShopImage(rs.getString("shopImage"));
		shop.setShopDecription(rs.getString("shopDecription"));
		shop.setShopAddress(rs.getString("shopAddress"));
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
 public void insertShop(Shop shop) {
		String query = "insert into shop values(?,?,?,null,?,?,?,getdate(),null,1,0)";
		try {
			conn = new connect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, shop.getShopName());
			ps.setInt(2, shop.getUser().getuId());
			ps.setInt(3, shop.getCategory().getcId());
			ps.setString(4, shop.getShopImage());
			ps.setString(5, shop.getShopDecription());
			ps.setString(6, shop.getShopAddress());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

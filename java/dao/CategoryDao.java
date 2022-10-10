package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.connect;
import entity.Cart;
import entity.Category;
import entity.Shop;
import entity.User;

public class CategoryDao {
	
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public Category findOne(int cateId) {
		String sql = "SELECT * FROM category WHERE cateId = ? ";
		try {
		conn = new connect().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, cateId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
		Category category = new Category();
		category.setcId(rs.getInt("cId"));
		category.setcName(rs.getString("cName"));
		return category;
		}} catch (Exception e) {
		e.printStackTrace();}
		return null;
	}
	 public List<Category> findAll() {
		 List<Category> categorys = new ArrayList<Category>();
			String sql = "SELECT * FROM category";
			try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
			Category category = new Category();
			category.setcId(rs.getInt("cId"));
			category.setcName(rs.getString("cName"));
			categorys.add(category);
			}} catch (Exception e) {
			e.printStackTrace();}
			return categorys;
	    }
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.connect;
import entity.Category;
import entity.Product;
import entity.Shop;
import entity.User;
import entity.evaluate;

public class CommentDao {
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public void insertComment(evaluate evaluate) {
		String query = "insert into evaluate values(?,?,?)";
		try {
			conn = new connect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, evaluate.getContent());
			ps.setInt(2, evaluate.getProduct().getpId());
			ps.setInt(3, evaluate.getUser().getuId());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public List<evaluate> getAllComment(int pid) {
		List<evaluate> evaluates = new ArrayList<evaluate>();
		String sql = "SELECT * FROM evaluate where pId=?";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductDao productDao = new ProductDao();
				UserDao userDao = new UserDao();
				Product product = productDao.findOne(rs.getInt("pId"));
				User user = userDao.get(rs.getInt("uId"));

				evaluate evaluate = new evaluate();
				evaluate.setId(rs.getInt("id"));
				evaluate.setContent(rs.getString("content"));
				evaluate.setProduct(product);
				evaluate.setUser(user);
				
				evaluates.add(evaluate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return evaluates;
	}
	
}

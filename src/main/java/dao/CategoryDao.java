package dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.connect;
import entity.Cart;
import entity.Category;
import entity.Product;
import entity.Shop;
import entity.User;
import utils.Constant;

public class CategoryDao {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public Category findOne(int cateId) {
		String sql = "SELECT * FROM category WHERE cId = ? ";
		try {
			conn = new connect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cateId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setcId(rs.getInt("cId"));
				category.setcName(rs.getString("cName"));
				category.setcImage(rs.getString("cImage"));
				category.setCreateAt(rs.getDate("createAt"));
				category.setUpdateAt(rs.getDate("updateAt"));
				return category;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Category> getAllCategory() {
		List<Category> list = new ArrayList<>();
		String query = "select * from Category";
		try {
			conn = new connect().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Category(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public void insertCategory(Category category) {
		String query = "insert into category values(?, ?, default, null)";
		try {
			conn = new connect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, category.getcName());
			ps.setString(2, category.getcImage());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteCategory(int id) {
		String query = "delete from category where cId=?";
		try {
			conn = new connect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateCategory(Category category) {
		String query = "update category set cName=?, cImage=?, updateAt=GETDATE() \r\n" + "where cId = ? ";
		try {
			conn = new connect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, category.getcName());
			ps.setString(2, category.getcImage());
			ps.setInt(3, category.getcId());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void editUpdateCategory(Category newCategory) {
		Category oldCategory = findOne(newCategory.getcId());
		oldCategory.setcName(newCategory.getcName());
		if (newCategory.getcImage() != null) {
			String fileName = oldCategory.getcImage();
			File file = new File(Constant.dir + "/category/" + fileName);
			if (file.exists()) {
				file.delete();
			}
			oldCategory.setcImage(newCategory.getcImage());
		}
		updateCategory(oldCategory);
	}
}

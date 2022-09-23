package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.connect;
import entity.Category;
import entity.Product;

public class DAO {
	
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from product";
        try {
            conn = new connect().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<Product> getProductbyCateId(String cateId) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product where cateId=?";
        try {
            conn = new connect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,cateId );
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<Product> SearchProduct(String txtS) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product where pName like ?";
        try {
            conn = new connect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,"%"+txtS+"%" );
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from Category";
        try {
            conn = new connect().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public int getTotalProduct() {
		String query = "select count(*) from product";
		try {
			conn = new connect().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
            	return rs.getInt(1);
            }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
    public int pageSize = 3;
    public List<Product> pagingProduct(int index) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product\r\n"
        		+ "order by pId\r\n"
        		+ "offset ? rows fetch next ? rows only;";
        
        try {
            conn = new connect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index-1)*pageSize);
            ps.setInt(2, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    /*public static void main(String[] args) {
		DAO dao = new DAO();
		//List<Product> list = dao.pagingProduct(1);
		int count = dao.getTotalProduct();
		//for(Product o: list) {
			System.out.println(count);
		//}
	}*/
}

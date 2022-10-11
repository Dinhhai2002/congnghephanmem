package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.connect;
import entity.Category;
import entity.Product1;
import entity.Shop;

public class ProductDao {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product1> findAll() {
    	List<Product1> products = new ArrayList<Product1>();
		String sql = "SELECT * FROM dbo.product";
		try {
		conn = new connect().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			CategoryDao categoryDao = new CategoryDao();
			ShopDao shopDao = new ShopDao();
			Category category = categoryDao.findOne(rs.getInt("cateId"));
			Shop shop = shopDao.findOne(rs.getInt("shopId"));
			
			Product1 product = new Product1();		
			product.setpId(rs.getInt("pId"));
			product.setpName(rs.getString("pName"));
			product.setpPrice(rs.getInt("pPrice"));
			product.setpImage(rs.getString("pImage"));
			product.setpDescription(rs.getString("pDescription"));
			product.setpQuantity(rs.getInt("pQuantity"));
			product.setCategory(category);
			product.setShop(shop);
			product.setCreateAt(rs.getDate("createAt"));
			products.add(product);
		}} catch (Exception e) {
		e.printStackTrace();}
		return products;
    }
  
    public List<Product1> getProductbyCateId(String cateId) {
        List<Product1> products = new ArrayList<>();
        String query = "select * from product where cateId=?";
        try {
            conn = new connect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,cateId );
            rs = ps.executeQuery();
            while (rs.next()) {
            	CategoryDao categoryDao = new CategoryDao();
    			ShopDao shopDao = new ShopDao();
    			Category category = categoryDao.findOne(rs.getInt("cateId"));
    			Shop shop = shopDao.findOne(rs.getInt("shopId"));
    			
    			Product1 product = new Product1();		
    			product.setpId(rs.getInt("pId"));
    			product.setpName(rs.getString("pName"));
    			product.setpPrice(rs.getInt("pPrice"));
    			product.setpImage(rs.getString("pImage"));
    			product.setpDescription(rs.getString("pDescription"));
    			product.setpQuantity(rs.getInt("pQuantity"));
    			product.setCategory(category);
    			product.setShop(shop);
    			product.setCreateAt(rs.getDate("createAt"));
    			products.add(product);
            }
        } catch (Exception e) {
        }
        return products;
    }
    public List<Product1> SearchProduct(String txtS) {
        List<Product1> products = new ArrayList<>();
        String query = "select * from product where pName like ?";
        try {
            conn = new connect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,"%"+txtS+"%" );
            rs = ps.executeQuery();
            while (rs.next()) {
            	CategoryDao categoryDao = new CategoryDao();
    			ShopDao shopDao = new ShopDao();
    			Category category = categoryDao.findOne(rs.getInt("cateId"));
    			Shop shop = shopDao.findOne(rs.getInt("shopId"));
    			
    			Product1 product = new Product1();		
    			product.setpId(rs.getInt("pId"));
    			product.setpName(rs.getString("pName"));
    			product.setpPrice(rs.getInt("pPrice"));
    			product.setpImage(rs.getString("pImage"));
    			product.setpDescription(rs.getString("pDescription"));
    			product.setpQuantity(rs.getInt("pQuantity"));
    			product.setCategory(category);
    			product.setShop(shop);
    			product.setCreateAt(rs.getDate("createAt"));
    			products.add(product);
            }
        } catch (Exception e) {
        }
        return products;
    }
    public Product1 findOne(int id) {
    	String sql = "SELECT * FROM product WHERE pId = ? ";
		try {
		conn = new connect().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			CategoryDao categoryDao = new CategoryDao();
			ShopDao shopDao = new ShopDao();
			Category category = categoryDao.findOne(rs.getInt("cateId"));
			Shop shop = shopDao.findOne(rs.getInt("shopId"));
			
			Product1 product = new Product1();		
			product.setpId(rs.getInt("pId"));
			product.setpName(rs.getString("pName"));
			product.setpPrice(rs.getInt("pPrice"));
			product.setpImage(rs.getString("pImage"));
			product.setpDescription(rs.getString("pDescription"));
			product.setpQuantity(rs.getInt("pQuantity"));
			product.setCategory(category);
			product.setShop(shop);
			product.setCreateAt(rs.getDate("createAt"));
		return product;
		}} catch (Exception e) {
		e.printStackTrace();}
		return null;
    }
}

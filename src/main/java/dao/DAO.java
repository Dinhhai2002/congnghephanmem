package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import connect.connect;
import entity.Category;
import entity.Product;
import entity.user;

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
    public Product getProductById(String id) {
        
        String query = "select * from product where Pid=?";
        try {
            conn = new connect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,id );
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9));
            }
        } catch (Exception e) {
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
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public user Login(String user,String pass) {
   	 String query = "select * from [user] where [uName]=? and [uPassword]=?";
        try {
            conn = new connect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            
            rs = ps.executeQuery();
            while (rs.next()) {
             return new user(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));}
        } catch (Exception e) {
        }
        return null;
   }
    public void SignUp(String user,String pass,String email,String Address,String phoneNumber) {
      	 String query = "insert into [user] values(?,?,0,0,?,?,?)";
           try {
               conn = new connect().getConnection();
               ps = conn.prepareStatement(query);
               ps.setString(1, user);
               ps.setString(2, pass);
               ps.setString(3, email);
               ps.setString(4, Address);
               ps.setString(5, phoneNumber);
               ps.executeUpdate();
               
           } catch (Exception e) {
           }
           
      }
       public user CheckAccount(String user) {
         	 String query = "select * from [user] where [uName]=?";
              try {
                  conn = new connect().getConnection();
                  ps = conn.prepareStatement(query);
                  ps.setString(1, user);
                  rs = ps.executeQuery();
                  while (rs.next()) {
                	  return new user(rs.getInt(1),
                              rs.getString(2),
                              rs.getString(3),
                              rs.getInt(4),
                              rs.getInt(5),
                              rs.getString(6),
                              rs.getString(7),
                              rs.getString(8));}
              } catch (Exception e) {
              }
              return null;
         }
       
       //check account forgotPassword
       public user CheckAccountforgotPassword(String user,String email) {
       	 String query = "select * from [user] where [uName]=? and uEmail=?";
            try {
                conn = new connect().getConnection();
                ps = conn.prepareStatement(query);
                ps.setString(1, user);
                ps.setString(2,email );
                rs = ps.executeQuery();
                while (rs.next()) {
              	  return new user(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getInt(4),
                            rs.getInt(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8));}
            } catch (Exception e) {
            }
            return null;
       }
       
       //update passWord 
       public void updatePassword(String passWord,String username,String email) {
        	 String query = "update [user] set uPassword = ? where [uName]=? and uEmail = ? ";
             try {
                 conn = new connect().getConnection();
                 ps = conn.prepareStatement(query);
                 ps.setString(1, passWord);
                 ps.setString(2, username);
                 ps.setString(3, email);
                 ps.executeUpdate();
                 
             } catch (Exception e) {
             }
             
        }
       
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import connect.connect;
import entity.Category;
import entity.Product;
import entity.User;

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
                        rs.getDate(9),
                        rs.getDate(10)));
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
                        rs.getDate(9),
                        rs.getDate(10)));
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
                        rs.getDate(9),
                        rs.getDate(10)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public Product getProductById(String id) {
        
        String query = "select * from product where pId=?";
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
                        rs.getDate(9),
                        rs.getDate(10));
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
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getDate(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public User Login(String user,String pass) {
   	 String query = "select * from [user] where [uName]=? and [uPassword]=?";
        try {
            conn = new connect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            
            rs = ps.executeQuery();
            while (rs.next()) {
             return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                       rs.getDate(12));

            }
        } catch (Exception e) {
        }
        return null;
   }
    
    public void SignUp(String user,String fullname,String email,String Address,String password,String phoneNumber) {
      	 String query = "insert into [user] values(?,?,?,?,?,?,null,1,0,null,getdate())";
           try {
               conn = new connect().getConnection();
               ps = conn.prepareStatement(query);
               ps.setString(1, user);
               ps.setString(2, fullname);
               ps.setString(3, email);
               ps.setString(4, Address);
               ps.setString(5, password);
               ps.setString(6, phoneNumber);
               ps.executeUpdate();
               
           } catch (Exception e) {
           }
           
      }
    public user CheckAccountUpdate(String user,String fullname,String email,String Address,String phoneNumber) {
     	 String query = "select * from [user] where [uName]=? and [uFullName]=? and uEmail=? and uAddress=? and uPhone=?";
          try {
              conn = new connect().getConnection();
              ps = conn.prepareStatement(query);
              ps.setString(1, user);
              ps.setString(2, fullname);
              ps.setString(3, email);
              ps.setString(4, Address);
              ps.setString(5, phoneNumber);
              
              rs = ps.executeQuery();
              while (rs.next()) {
            	  return new user(rs.getInt(1),
                          rs.getString(2),
                          rs.getString(3),
                          rs.getString(4),
                          rs.getString(5),
                          rs.getString(6),
                          rs.getString(7),
                          rs.getInt(8),
                          rs.getInt(9),
                          rs.getInt(10),
                          rs.getString(11),
                         rs.getDate(12)
                         );
              }
          } catch (Exception e) {
          }
          return null;
     }
    public void UpdateAccount(String uId,String user,String fullname,String email,String Address,String phoneNumber) {
     	 String query = "update [user]\r\n" + 
     	 		"set uName=?,uFullName=?,uEmail=?,uAddress=?,uPhone=?\r\n" + 
     	 		"where uId=?";
          try {
              conn = new connect().getConnection();
              ps = conn.prepareStatement(query);
              ps.setString(1, user);
              ps.setString(2, fullname);
              ps.setString(3, email);
              ps.setString(4, Address);
              ps.setString(5, phoneNumber);
              ps.setString(6,uId);
              ps.executeUpdate();
              
          } catch (Exception e) {
          }
          
     }
   public void UpdatePassWordAccount(String id,String pass) {
    	 String query = "update [user]\r\n" + 
    	 		"set uPassword=?\r\n" + 
    	 		"where uId=?";
         try {
             conn = new connect().getConnection();
             ps = conn.prepareStatement(query);
             ps.setString(1, pass);
             ps.setString(2, id);
             
             ps.executeUpdate();
             
         } catch (Exception e) {
         }
         
    }
   public int numberAccount(String user,String email) {
    	 String query = "select count(*) from [user] where uName=? and uEmail=?";
         try {
             conn = new connect().getConnection();
             ps = conn.prepareStatement(query);
             ps.setString(1, user);
             ps.setString(2, email);              
             rs=ps.executeQuery();
             while (rs.next()) {
             	return rs.getInt(1);
             }
                       } catch (Exception e) {         }
         return 0;
         
    }
   public int numberAccountUpdate(String user) {
  	 String query = "select count(*) from [user] where uName=? ";
       try {
           conn = new connect().getConnection();
           ps = conn.prepareStatement(query);
           ps.setString(1, user);
                         
           rs=ps.executeQuery();
           while (rs.next()) {
           	return rs.getInt(1);
           }
                     } catch (Exception e) {         }
       return 0;
       
  }
   //check password account
   public user checkpasswordAccount(String id,String pass) {
   	 String query = "select * from [user] where uId=? and [uPassword]=?";
        try {
            conn = new connect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
            	return new user(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                       rs.getDate(12) );
            }
        } catch (Exception e) {
        }
        return null;
   }
 
    
       public User CheckAccount(String user) {
         	 String query = "select * from [user] where [uName]=?";
              try {
                  conn = new connect().getConnection();
                  ps = conn.prepareStatement(query);
                  ps.setString(1, user);
                  rs = ps.executeQuery();
                  while (rs.next()) {
                	  return new User(rs.getInt(1),
                			  rs.getString(2),
                              rs.getString(3),
                              rs.getString(4),
                              rs.getString(5),
                              rs.getString(6),
                              rs.getString(7),
                              rs.getInt(8),
                              rs.getInt(9),
                              rs.getInt(10),
                              rs.getString(11),
                             rs.getDate(12) );

                  }
              } catch (Exception e) {
              }
              return null;
         }
       
       //check account forgotPassword
       public User CheckAccountforgotPassword(String user,String email) {
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
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getInt(8),
                            rs.getInt(9),
                            rs.getInt(10),
                            rs.getString(11),
                           rs.getDate(12));

                }
            } catch (Exception e) {
            }
            return null;
       }
       
     //check account forgotPassword
       public user CheckAccountforgotPasswordSMS(String user,String phoneNumber) {
       	 String query = "select * from [user] where [uName]=? and uPhone =?";
            try {
                conn = new connect().getConnection();
                ps = conn.prepareStatement(query);
                ps.setString(1, user);
                ps.setString(2,phoneNumber );
                rs = ps.executeQuery();
                while (rs.next()) {
                	return new user(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getInt(8),
                            rs.getInt(9),
                            rs.getInt(10),
                            rs.getString(11),
                           rs.getDate(12));
                }
            } catch (Exception e) {
            }
            return null;
       }
     //check account Email
       public user CheckEmail(String email) {
       	 String query = "select * from [user] where  uEmail =?";
            try {
                conn = new connect().getConnection();
                ps = conn.prepareStatement(query);
                ps.setString(1, email);
                rs = ps.executeQuery();
                while (rs.next()) {
                	return new user(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getInt(8),
                            rs.getInt(9),
                            rs.getInt(10),
                            rs.getString(11),
                           rs.getDate(12));
                }
            } catch (Exception e) {
            }
            return null;
       }
     //check account PhoneNumber
       public user CheckPhoneNumber(String phoneNumber) {
       	 String query = "select * from [user] where  uPhone =?";
            try {
                conn = new connect().getConnection();
                ps = conn.prepareStatement(query);
                ps.setString(1, phoneNumber);
               
                rs = ps.executeQuery();
                while (rs.next()) {
                	return new user(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getInt(8),
                            rs.getInt(9),
                            rs.getInt(10),
                            rs.getString(11),
                           rs.getDate(12));
                }
            } catch (Exception e) {
            }
            return null;
       }
       //login with google
       public void insertAcountGoogle(String user,String email,String image) {
        	 String query = "insert into [user] values(?,null,?,null,null,null,null,1,1,?,getdate())";
             try {
                 conn = new connect().getConnection();
                 ps = conn.prepareStatement(query);
                 ps.setString(1, user);
                 ps.setString(2, email);
                 ps.setString(3, image);
                 
                 ps.executeUpdate();
                 
             } catch (Exception e) {
             }
             
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
     //update passWord 
       public void updatePasswordSMS(String passWord,String username,String phonenumber) {
        	 String query = "update [user] set uPassword = ? where [uName]=? and uPhone = ? ";
             try {
                 conn = new connect().getConnection();
                 ps = conn.prepareStatement(query);
                 ps.setString(1, passWord);
                 ps.setString(2, username);
                 ps.setString(3, phonenumber);
                 ps.executeUpdate();
                 
             } catch (Exception e) {
             }
             
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
    public int pageSize = 10;
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
                        rs.getDate(9),
                        rs.getDate(10)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
}
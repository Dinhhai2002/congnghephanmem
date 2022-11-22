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

public class UserDao {

	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
 public User get(int id) {
        //dung
	 String sql = "SELECT * FROM [user] WHERE uId = ? ";
		try {
		conn = new connect().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		User user = new User();
		user.setuId(rs.getInt("uId"));
		user.setuName(rs.getString("uName"));
		user.setuFullName(rs.getString("uFullName"));
		user.setuEmail(rs.getString("uEmail"));
		user.setuAddress(rs.getString("uAddress"));
		user.setuPassword(rs.getString("uPassword"));
		user.setuPhone(rs.getString("uPhone"));
		user.setIdRole(rs.getInt("idRole"));
		user.setuImage(rs.getString("uImage"));
		user.setCreateAt(rs.getDate("createAt"));
		return user;
		}} catch (Exception e) {
		e.printStackTrace();}
		return null;
    }
 
 
 
 public User getshipper(int id) {
	 String sql = "SELECT * FROM [user] WHERE idRole = ? ";
		try {
		conn = new connect().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		User user = new User();
		user.setuId(rs.getInt("uId"));
		user.setuName(rs.getString("uName"));
		user.setuFullName(rs.getString("uFullName"));
		user.setuEmail(rs.getString("uEmail"));
		user.setuAddress(rs.getString("uAddress"));
		user.setuPassword(rs.getString("uPassword"));
		user.setuPhone(rs.getString("uPhone"));
		user.setIdRole(rs.getInt("idRole"));
		user.setuImage(rs.getString("uImage"));
		user.setCreateAt(rs.getDate("createAt"));
		return user;
		}} catch (Exception e) {
		e.printStackTrace();}
		return null;
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
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                       rs.getDate(12));

            }
        } catch (Exception e) {
        }
        return null;
   }
 public int getTotalUser() {
		String query = "select count(*) from [user]";
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
 public List<User> getAllUserArrByCreateAt() {
		List<User> users = new ArrayList<>();
		String query = "select * from [user] order by [createAt] DESC";

		try {
			conn = new connect().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {			
				User user = new User();
				user.setuId(rs.getInt("uId"));
				user.setuName(rs.getString("uName"));
				user.setuFullName(rs.getNString("uFullName"));
				user.setuEmail(rs.getString("uEmail"));
				user.setuAddress(rs.getString("uAddress"));
				user.setuPassword(rs.getString("uPassword"));
				user.setuPhone(rs.getString("uPhone"));
				user.setIdRole(rs.getInt("idRole"));
				user.setIsAccountGoogle(rs.getInt("isAccountGoogle"));
				user.setuImage(rs.getString("uImage"));
				user.setCreateAt(rs.getDate("createAt"));
				users.add(user);
			}
		} catch (Exception e) {
		}
		return users;
	}
 public void deleteUser(String id) {
	 String query = "Delete from [user] where uId = ?";
	 try {
			conn = new connect().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {			
				ps.setString(1,id);
				ps.executeUpdate();
			}
		} catch (Exception e) {
		}
 }
 public User getUserById(String id) {
	 String query ="select * from [user] where [uId] = ?";
			 try {
					conn = new connect().getConnection();
					ps = conn.prepareStatement(query);
					ps.setString(1,id);
					rs = ps.executeQuery();
					while (rs.next()) {			
						return new User(rs.getInt(1),
								rs.getString(2),
		                        rs.getString(3),
		                        rs.getString(4),
		                        rs.getString(5),
		                        rs.getString(6),
		                        rs.getString(7),
		                        rs.getString(8),
		                        rs.getInt(9),
		                        rs.getInt(10),
		                        rs.getString(11),
		                       rs.getDate(12));
					}
				} catch (Exception e) {
				}
			return null;
 }
public void editUser(String uId,String fullname,String email,String Address,String phoneNumber) {
	 String query = "update [user]\r\n" + 
 	 		"uFullName=?,uEmail=?,uAddress=?,uPhone=?\r\n" + 
 	 		"where uId=?";
      try {
          conn = new connect().getConnection();
          ps = conn.prepareStatement(query);
          ps.setString(1, fullname);
          ps.setString(2, email);
          ps.setString(3, Address);
          ps.setString(4, phoneNumber);
          ps.setString(5,uId);
          ps.executeUpdate();
          
      } catch (Exception e) {
      }
      
 }
 
    
    public void SignUp(String user,String fullname,String email,String Address,String fullAddress,String password,String phoneNumber) {
      	 String query = "insert into [user] values(?,?,?,?,?,?,?,1,0,null,getdate())";
           try {
               conn = new connect().getConnection();
               ps = conn.prepareStatement(query);
               ps.setString(1, user);
               ps.setString(2, fullname);
               ps.setString(3, email);
               ps.setString(4, Address);
               ps.setString(5, fullAddress);
               
               ps.setString(6, password);
               ps.setString(7, phoneNumber);
               ps.executeUpdate();
               
           } catch (Exception e) {
           }
           
      }
    public User CheckAccountUpdate(String user,String fullname,String email,String Address,String phoneNumber) {
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
            	  return new User(rs.getInt(1),
            			  rs.getString(2),
                          rs.getString(3),
                          rs.getString(4),
                          rs.getString(5),
                          rs.getString(6),
                          rs.getString(7),
                          rs.getString(8),
                          rs.getInt(9),
                          rs.getInt(10),
                          rs.getString(11),
                         rs.getDate(12));
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

    public void UpdateAccountManager(int uId) {
    	 String query = "update [user]\r\n" + 
    	 		"set idRole=3\r\n" + 
    	 		"where uId=?";
         try {
             conn = new connect().getConnection();
             ps = conn.prepareStatement(query);
             ps.setInt(1, uId);
             
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
   public User checkpasswordAccount(String id,String pass) {
   	 String query = "select * from [user] where uId=? and [uPassword]=?";
        try {
            conn = new connect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
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
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                       rs.getDate(12));
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
                              rs.getString(8),
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
       public User CheckAccountforgotPassword(String user,String email) {
       	 String query = "select * from [user] where [uName]=? and uEmail=?";
            try {
                conn = new connect().getConnection();
                ps = conn.prepareStatement(query);
                ps.setString(1, user);
                ps.setString(2,email );
                rs = ps.executeQuery();
                while (rs.next()) {

                	return new User(rs.getInt(1),
                			rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8),
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
       public User CheckAccountforgotPasswordSMS(String user,String phoneNumber) {
       	 String query = "select * from [user] where [uName]=? and uPhone =?";
            try {
                conn = new connect().getConnection();
                ps = conn.prepareStatement(query);
                ps.setString(1, user);
                ps.setString(2,phoneNumber );
                rs = ps.executeQuery();
                while (rs.next()) {
                	return new User(rs.getInt(1),
                			rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8),
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
       public User CheckEmail(String email) {
       	 String query = "select * from [user] where  uEmail =?";
            try {
                conn = new connect().getConnection();
                ps = conn.prepareStatement(query);
                ps.setString(1, email);
                rs = ps.executeQuery();
                while (rs.next()) {
                	return new User(rs.getInt(1),
                			rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8),
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
       public User CheckPhoneNumber(String phoneNumber) {
       	 String query = "select * from [user] where  uPhone =?";
            try {
                conn = new connect().getConnection();
                ps = conn.prepareStatement(query);
                ps.setString(1, phoneNumber);
               
                rs = ps.executeQuery();
                while (rs.next()) {
                	return new User(rs.getInt(1),
                			rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8),
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



	

}

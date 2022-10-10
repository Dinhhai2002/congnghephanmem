package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connect.connect;
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
		user.seteWallet(rs.getInt("eWallet"));
		user.setuImage(rs.getString("uImage"));
		user.setCreateAt(rs.getDate("createAt"));
		return user;
		}} catch (Exception e) {
		e.printStackTrace();}
		return null;
    }

}

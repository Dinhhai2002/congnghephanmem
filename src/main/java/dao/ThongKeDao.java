

package dao;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.connect;
import entity.Order;
import entity.OrderDetail;
import entity.OrderStatus;
import entity.Product;
import entity.ThongKe;

public class ThongKeDao{
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public ThongKeDao(){
		
	}
	
	public List<ThongKe> getDoanhThu(String curDay) {
		List<ThongKe> thongkes = new ArrayList<ThongKe>();
		String query = "select sum(totalPrice) as total,createAt as createAt from orderdetail WHERE [createAt] BETWEEN CAST('2000-1-1' as DATE) AND CAST(? as DATE) group by createAt";
		try {
			conn = new connect().getConnection();
			ps.setString(1, curDay);
	         ps = conn.prepareStatement(query);
	         rs = ps.executeQuery();
         while (rs.next()) {
         	ThongKe thongke = new ThongKe();
         	thongke.setTotal(rs.getInt(1));
         	thongke.setCreateAt(rs.getDate(2));
         	thongkes.add(thongke);
         }
		} catch (Exception e) {
		}
		return thongkes;
	}
	public List<ThongKe> getDoanhThu(String fromday, String today){
		
		List<ThongKe> thongkes = new ArrayList<ThongKe>();
		String query = "select sum(totalPrice) as total,createAt from orderdetail WHERE [createAt] BETWEEN CAST(? as DATE) AND CAST(? as DATE) group by createAt ";
		try {
			conn = new connect().getConnection();
	         ps = conn.prepareStatement(query);
	         ps.setString(1, fromday);
	         ps.setString(2, today);
	         rs = ps.executeQuery();
         while (rs.next()) {
         	ThongKe thongke = new ThongKe();
         	thongke.setTotal(rs.getInt(1));
         	thongke.setCreateAt(rs.getDate(2));
         	thongkes.add(thongke);
         }
		} catch (Exception e) {
		}
		return thongkes;
		
		
		
		
	}
	
	
	}

	
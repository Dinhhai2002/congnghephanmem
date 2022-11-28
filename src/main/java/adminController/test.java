package adminController;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import dao.OrderDetailDao;
import dao.ThongKeDao;
import dao.UserDao;
import entity.OrderDetail;
import entity.ThongKe;
import entity.User;

public class test {
		public static void main(String[] args) {
			long millis=System.currentTimeMillis();  
			Date date = new Date(millis);       
			String dateString= date.toString();
		    System.out.println(dateString);   
	}
}

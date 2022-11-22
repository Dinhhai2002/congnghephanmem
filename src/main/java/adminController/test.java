package adminController;

import java.util.List;

import dao.OrderDetailDao;
import dao.UserDao;
import entity.OrderDetail;
import entity.User;

public class test {
		public static void main(String[] args) {
		
		
		OrderDetailDao orderdetail = new OrderDetailDao();
		
		int arrStatus[] = null;
		for(int i = 1 ;i<7;i++)
		{
			arrStatus[i-1] = orderdetail.countStatusByIdStatus(i);
			System.out.print(arrStatus[i-1]);
		}		
	}
}

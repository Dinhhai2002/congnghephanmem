package adminController;

import dao.UserDao;
import entity.User;

public class test {
	public static void main(String[] args) {
		UserDao userdao = new UserDao();
		User user = userdao.getUserById("3");
		System.out.println(user);
	}
}

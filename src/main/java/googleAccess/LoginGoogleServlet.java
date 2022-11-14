package googleAccess;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import entity.User;

@WebServlet(urlPatterns="/logingoogle")
	
	public class LoginGoogleServlet extends HttpServlet {
	  private static final long serialVersionUID = 1L;
	  public LoginGoogleServlet() {
	    super();
	  }
	  
	  /*
	   * check count Account(username,email)
	   * if(count==1)->đẩy về trang home
	   * else ->insert account->đẩy về trang home
	   * */
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	    String code = request.getParameter("code");
	    if (code == null || code.isEmpty()) {
	      RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
	      dis.forward(request, response);
	    } else {
	      String accessToken = GoogleUtils.getToken(code);
	      GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
	      String username=googlePojo.getName();
	      String email=googlePojo.getEmail();
	      String image=googlePojo.getPicture();
	      UserDao userDao= new UserDao();
	      int NumberAccountGoogle=userDao.numberAccount(username, email);
	    	User checkAccountGoogle=userDao.CheckAccountforgotPassword(username, email);
	      if(NumberAccountGoogle==1 && checkAccountGoogle.getIsAccountGoogle()==1)
	      {
	    	  HttpSession session=request.getSession();
				session.setAttribute("acc", checkAccountGoogle);
				RequestDispatcher dis = request.getRequestDispatcher("/home?index=1");
			      dis.forward(request, response);
	      }
	      else if(NumberAccountGoogle==0){
	    	  userDao.insertAcountGoogle(username, email,image);
	    	 
	    	  HttpSession session=request.getSession();
				session.setAttribute("acc", userDao.CheckAccountforgotPassword(username, email));
				RequestDispatcher dis = request.getRequestDispatcher("/home");
			      dis.forward(request, response);
	    	  
	      }
	      else {
	    	  response.sendRedirect("/Shopee/login");
	      }
	      //request.setAttribute("id", googlePojo.getId());
	      //request.setAttribute("name", googlePojo.getName());
	      //request.setAttribute("email", googlePojo.getEmail());
	     
	    }
	  }
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	    doGet(request, response);
	  }
}

package controller;

import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import dao.UserDao;
import entity.User;

@WebServlet(urlPatterns = {"/forgotPasswordSMS"})
public class forgotPasswordSMSController extends HttpServlet  {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/forgotpasswordSMS.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phoneNumber = request.getParameter("phoneNumber");
		String username=request.getParameter("username");
		
		int otpvalue = 0;
		HttpSession mySession = request.getSession();
		if(phoneNumber!=null && !phoneNumber.equals("") && username!=null && !username.equals("")) {
			UserDao userDao = new UserDao();
			User a=userDao.CheckAccountforgotPasswordSMS(username, phoneNumber);
			if(a!=null)
			{
				try {
				// sending otp
				Random rand = new Random();
				otpvalue = rand.nextInt(1255650);
				String ACCOUNT_SID = "AC1aa9c2ef6405f7650058de3a0c0bcbbc"; //Find your Account Sid and Auth Token at https://www.twilio.com/console
				 String AUTH_TOKEN = "8f3232acb2e21df3be4e6e6958683f36";
				String messageBody = "your OTP is: "+otpvalue;
		        //String to = jTextFieldTo.getText().toString();
				

		        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		       
		        Message message = Message.creator(
		            new com.twilio.type.PhoneNumber("+84"+phoneNumber),               
		            new com.twilio.type.PhoneNumber("+19207108508"),    
		            messageBody).setMediaUrl(Arrays.asList(URI.create("https://demo.twilio.com/owl.png"))).create();						
			        		
		        
		        
		        System.out.println(message.getSid());
				
				}
				catch (Exception e) {
					throw new RuntimeException(e);
				}
				request.setAttribute("message","OTP is sent to your email id");
				//request.setAttribute("connection", con);
				mySession.setAttribute("otp",otpvalue); 
				mySession.setAttribute("phoneNumber",phoneNumber);
				mySession.setAttribute("username",username);
				response.sendRedirect("/Shopee/ValidateOtp");
				
				//request.setAttribute("status", "success");
			}
			else {
				request.setAttribute("mess", "số điện thoại hoặc tài khoản không chính xác");
				request.getRequestDispatcher("/views/forgotpasswordSMS.jsp").forward(request, response);
			}
		}
		else {
			request.getRequestDispatcher("/views/forgotpasswordSMS.jsp").forward(request, response);
		}
	}
	
}

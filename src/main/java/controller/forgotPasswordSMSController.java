package controller;

import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.Properties;
import java.util.Random;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Message;

import dao.UserDao;
import entity.User;
@WebServlet(urlPatterns="/forgotPasswordSMS")
public class forgotPasswordSMSController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/forgotpasswordSMS.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phoneNumber = request.getParameter("phoneNumber");
		String username=request.getParameter("username");
		RequestDispatcher dispatcher = null;
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
		            new com.twilio.type.PhoneNumber("+84"+phoneNumber),                //Recipient(s)
		            new com.twilio.type.PhoneNumber("+19207108508"),    //Sender Phone No. - Find your Twilio phone number at https://www.twilio.com/console
		            messageBody)
		        .setMediaUrl(										//MMS, Comment out this and the next line if you don't want to attach picture to your message.
		        		Arrays.asList(URI.create("https://demo.twilio.com/owl.png")))
		        .create();
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

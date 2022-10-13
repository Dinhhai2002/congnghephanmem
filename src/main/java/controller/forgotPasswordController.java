package controller;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import entity.User;

@WebServlet(urlPatterns="/forgotPasswordEmail")

public class forgotPasswordController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/forgotPassword.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String username=request.getParameter("username");
		RequestDispatcher dispatcher = null;
		int otpvalue = 0;
		HttpSession mySession = request.getSession();
		
		if(email!=null && !email.equals("") && username!=null && !username.equals("")) {
			UserDao userDao = new UserDao();
			User a=userDao.CheckAccountforgotPassword(username, email);
			if(a!=null)
			{
				// sending otp
				Random rand = new Random();
				otpvalue = rand.nextInt(1255650);

				String to = email;// change accordingly
				// Get the session object
				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.socketFactory.port", "465");
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.port", "465");
				Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("trandinhhai200902@gmail.com", "bazqhigbxbwjwbts");// Put your email
																										// id and
																										// password here
					}
				});
				// compose message
				try {
					MimeMessage message = new MimeMessage(session);
					message.setFrom(new InternetAddress(email));// change accordingly
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
					message.setSubject("Hello");
					message.setText("your OTP is: " + otpvalue);
					// send message
					Transport.send(message);
					System.out.println("message sent successfully");
				}

				catch (MessagingException e) {
					throw new RuntimeException(e);
				}
				dispatcher = request.getRequestDispatcher("/views/EnterOtp.jsp");
				request.setAttribute("message","OTP is sent to your email id");
				//request.setAttribute("connection", con);
				mySession.setAttribute("otp",otpvalue); 
				mySession.setAttribute("email",email);
				mySession.setAttribute("username",username);
				response.sendRedirect("/Shopee/ValidateOtp");
				//request.setAttribute("status", "success");
			}
			else {
				request.setAttribute("mess", "tên gmail hoặc tài khoản không chính xác");
				request.getRequestDispatcher("/views/forgotPassword.jsp").forward(request, response);
			}
		}
		else {
			request.getRequestDispatcher("/views/forgotPassword.jsp").forward(request, response);
		}
	}
}

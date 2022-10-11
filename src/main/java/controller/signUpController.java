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

import dao.DAO;
import entity.User;

@WebServlet(urlPatterns="/register")

public class signUpController extends HttpServlet {
	
	private static final long serialVersionUID = 4823215816154221221L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String username=request.getParameter("user");
		String fullname=request.getParameter("fullname");
		String pass=request.getParameter("pass");
		String repass=request.getParameter("re_pass");
		String email=request.getParameter("email");
		String phoneNumber=request.getParameter("phoneNumber");
		String address=request.getParameter("address");
		
		RequestDispatcher dispatcher = null;
		int otpvalue = 0;
		HttpSession mySession = request.getSession();
		
		if(email!=null && !email.equals("") && username!=null && !username.equals("") && pass.equals(repass)&& pass!=null && repass!=null) {
			DAO dao=new DAO();
			User a=dao.CheckAccountforgotPassword(username, email);
			if(a==null)
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
				dispatcher = request.getRequestDispatcher("/views/EnterOtpSignUp.jsp");
				request.setAttribute("message","OTP is sent to your email id");
				//request.setAttribute("connection", con);
				mySession.setAttribute("otp",otpvalue); 
				mySession.setAttribute("email",email);
				mySession.setAttribute("username",username);
				mySession.setAttribute("fullname", fullname);
				mySession.setAttribute("password", pass);
				mySession.setAttribute("phoneNumber", phoneNumber);
				mySession.setAttribute("address", address);
				dispatcher.forward(request, response);
				//request.setAttribute("status", "success");
			}
			else {
				request.getRequestDispatcher("/views/register.jsp").forward(request, response);
			}
		}
		else {
			request.getRequestDispatcher("/views/register.jsp").forward(request, response);
		}
//		if(pass!=null && repass!=null && pass.equals(repass))
//		{
//			DAO dao =new DAO();
//			user a=dao.CheckAccount(username);
//			if(a==null)
//			{
//				dao.SignUp(username, pass,email,address,phoneNumber);
//				req.getRequestDispatcher("/home").forward(req, resp);
//				
//			}
//			else {
//				req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
//			}	
//		}
//		else {
//			req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
//		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}

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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import entity.user;

@WebServlet(urlPatterns="/myAccount")
public class myAccountController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/MyAccount.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		int otpvalue = 0;
		HttpSession mySession=req.getSession();
		
		String id=req.getParameter("id");
		String emailSession=req.getParameter("SessionEmail");
		String username=req.getParameter("username");
		String usernameSession=req.getParameter("usernameSession");
		String phoneNumberSession=req.getParameter("phoneNumberSession");
		String fullName=req.getParameter("fullName");
		String phoneNumber=req.getParameter("phoneNumber");
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		
		DAO dao=new DAO();
		user checkPhoneNumber=dao.CheckPhoneNumber(phoneNumber);
		user checkEmail=dao.CheckEmail(email);
		int numberAccountUpdate=dao.numberAccountUpdate(username);
		user a=dao.CheckAccountUpdate(username, fullName, email, address, phoneNumber);
		if((a==null && phoneNumber.equals(phoneNumberSession) && username.equals(usernameSession) && emailSession.equals(email) && numberAccountUpdate==1)||(a==null && !phoneNumber.equals(phoneNumberSession) && checkPhoneNumber==null && username.equals(usernameSession) && emailSession.equals(email) && numberAccountUpdate==1))
		{
			dao.UpdateAccount(id, username, fullName, email, address, phoneNumber);
			mySession.setAttribute("acc", dao.CheckAccountUpdate(username, fullName, email, address, phoneNumber));		
			req.setAttribute("mess", "Cập nhật thành công");
			resp.sendRedirect("/Shopee/myAccount");
		}
		else if((a==null && phoneNumber.equals(phoneNumberSession) && !emailSession.equals(email) && checkEmail==null && username.equals(usernameSession) && numberAccountUpdate==1 )||(a==null && !phoneNumber.equals(phoneNumberSession) && checkPhoneNumber==null && !emailSession.equals(email) && checkEmail==null && !username.equals(usernameSession) && numberAccountUpdate==0 ) ) {
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
			
			req.setAttribute("message","OTP is sent to your email id");
			//request.setAttribute("connection", con);
			mySession.setAttribute("otp",otpvalue); 
			mySession.setAttribute("id", id);
			mySession.setAttribute("email",email);
			mySession.setAttribute("username",username);
			mySession.setAttribute("fullname", fullName);
			mySession.setAttribute("phoneNumber", phoneNumber);
			mySession.setAttribute("address", address);
			resp.sendRedirect("/Shopee/ValidateOtpUpdateAccount");
			//request.setAttribute("status", "success");
		}
		else {
			req.setAttribute("mess", "Email đã tồn tại hoặc thông tin chỉnh sửa không phù hợp");
			req.getRequestDispatcher("/views/MyAccount.jsp").forward(req, resp);
		}
	}
}

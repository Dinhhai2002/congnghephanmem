package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.sshd.common.mac.HMACMD5;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.CartDao;
import dao.CartItemDao;
import dao.OrderDao;
import dao.OrderDetailDao;
import dao.ProductDao;
import dao.ShopDao;
import dao.UserDao;
import entity.Cart;
import entity.CartItem;
import entity.Order;
import entity.OrderDetail;
import entity.OrderStatus;
import entity.Product;
import entity.Shop;
import entity.User;
import momo.MomoModel;
import utils.Constant;
import utils.Decode;

import org.apache.commons.codec.digest.HmacUtils;



@WebServlet(urlPatterns={"/pay/result"})
public class PayResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String result=req.getParameter("resultCode");
		if(result.equals("0")) {
			req.setAttribute("Result", "Đặt hàng thành công");
			RequestDispatcher rq=req.getRequestDispatcher("/views/buysucess.jsp");
			rq.forward(req, resp);
		}else {
			req.setAttribute("Result", "Đặt hàng thất bại");
			RequestDispatcher rq=req.getRequestDispatcher("/views/buysucess.jsp");
			rq.forward(req, resp);
		}
		
		
	}
	
		
	
}

package controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.CartDao;
import dao.CartItemDao;
import dao.OrderDao;
import dao.OrderDetailDao;
import dao.ProductDao;
import dao.UserDao;
import entity.CartItem;
import entity.Order;
import entity.OrderDetail;
import entity.OrderStatus;
import entity.Product;
import entity.User;
import momo.MomoModel;
import momo.ResultMoMo;
import utils.Constant;
import utils.Decode;

@WebServlet(urlPatterns = { "/member/pay" })
public class PayController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		HttpSession httpSession = req.getSession();
		Object user = httpSession.getAttribute("acc");
		Object obj = httpSession.getAttribute("cart");
		User acc = (User) user;
		ObjectMapper mapper = new ObjectMapper();
		Map<Integer, CartItem> cartItem = extracted(obj);

		String payment = req.getParameter("payment");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		OrderDao orderDao = new OrderDao();
		ProductDao productDao = new ProductDao();
		OrderDetailDao orderDetailDao = new OrderDetailDao();
		CartItemDao cartItemDao = new CartItemDao();
		CartDao cartDao = new CartDao();
		UserDao userDao = new UserDao();

		Map<Integer, Order> orderCheck = new HashMap<Integer, Order>();
		Set<Integer> set = cartItem.keySet();
		String orderId = "";
		//String orderInfor = "";
		double amount=0;
		for (Integer key : set) {
			Order order = new Order();
			order.setUser(acc);
			order.setuName(name);
			order.setuPhone(phone);
			order.setuAddress(address);
			order.setPaidBefore(false);
			
			order.setAmountToShipper(10000);
			
			int shopId = cartItem.get(key).getCart().getShop().getShopId();
			if (orderCheck.containsKey(shopId) == true) {
				order.setShop(cartItem.get(key).getCart().getShop());
				order.setAmountFromUser(orderCheck.get(shopId).getAmountFromUser()
						+ cartItem.get(key).getCount() * cartItem.get(key).getProduct().getpPrice());
				orderCheck.replace(shopId, order);
				
			} else {
				order.setShop(cartItem.get(key).getCart().getShop());
				order.setAmountFromUser(cartItem.get(key).getCount() * cartItem.get(key).getProduct().getpPrice());
				orderCheck.put(shopId, order);
			}
			amount += cartItem.get(key).getTotalPrice();
			
		}
		System.out.print(amount);
		int iamount = (int) amount+10000;
		orderId += "shoppppp"+orderDao.findIdOrder();

		//Date date = new Date(System.currentTimeMillis());
		if (payment.equals("online")) {
			
			Set<Integer> set1 = orderCheck.keySet();
			for (Integer key1 : set1) {
				float x= orderCheck.get(key1).getAmountFromUser();
				orderCheck.get(key1).setAmountFromUser(x);//--Tiền user trả 
				orderCheck.get(key1).setAmountFromShop((float) ((x)*0.005));//Tiền shop trả cho hệ thống
				orderCheck.get(key1).setAmountToShop(x-(float) ((x)*0.005));//Tiền Shop được nhận
				orderCheck.get(key1).setPaidBefore(true);
				orderDao.create(orderCheck.get(key1));
				Order order = new Order();
				order = orderDao.findOneNew();
				for (Integer key : set) {
					CartItem cartItemSelected = new CartItem();
					cartItemSelected = cartItemDao.findCartItemSelected(key1, key);
					if (cartItemSelected != null) {
						OrderStatus orderStatus = new OrderStatus(1);
						OrderDetail orderDetail = new OrderDetail(order, cartItemSelected.getProduct(),
								cartItemSelected.getCount(),10000, cartItemSelected.getTotalPrice(), orderStatus);
						orderDetailDao.create(orderDetail);
						Product product = new Product(cartItemSelected.getProduct().getpId(),
								cartItemSelected.getProduct().getpQuantity() - cartItemSelected.getCount());
						productDao.updateQuantity(product);
					}
				}
			}
			for (Integer key : set) {
				cartItemDao.delete(key);
				cartDao.delete();
			}
			cartItem.clear();
			httpSession.setAttribute("cart", cartItem);
			
			MomoModel jsonRequest = new MomoModel();
			jsonRequest.setPartnerCode(Constant.IDMOMO);
			jsonRequest.setOrderId(orderId);
			jsonRequest.setStoreId(orderId);
			jsonRequest.setRedirectUrl(Constant.redirectUrl);
			jsonRequest.setIpnUrl(Constant.ipnUrl);
			jsonRequest.setAmount(String.valueOf(iamount));
			jsonRequest.setOrderInfo("HoaDonDienTuShopee");
			jsonRequest.setRequestId(orderId);
			jsonRequest.setOrderType(Constant.orderType);
			jsonRequest.setRequestType(Constant.requestType);
			jsonRequest.setTransId("1");
			jsonRequest.setResultCode("200");
			jsonRequest.setMessage("");
			jsonRequest.setPayType(Constant.payType);
			jsonRequest.setResponseTime("300000");
			jsonRequest.setExtraData("");

			String decode = "accessKey=" + Constant.accessKey + "&amount=" + jsonRequest.amount + "&extraData="
					+ jsonRequest.extraData + "&ipnUrl=" + Constant.ipnUrl + "&orderId=" + orderId + "&orderInfo="
					+ jsonRequest.orderInfo + "&partnerCode=" + jsonRequest.getPartnerCode() + "&redirectUrl="
					+ Constant.redirectUrl + "&requestId=" + jsonRequest.getRequestId() + "&requestType="
					+ Constant.requestType;
			String signature = Decode.encode(Constant.serectkey, decode);
			jsonRequest.setSignature(signature);
			String json = mapper.writeValueAsString(jsonRequest);
			HttpClient client = HttpClient.newHttpClient();
			String respUrl = "";
			ResultMoMo res = new ResultMoMo();
			try {
				HttpRequest request = HttpRequest.newBuilder().uri(new URI(Constant.Url))
						.POST(HttpRequest.BodyPublishers.ofString(json)).headers("Content-Type", "application/json")
						.build();
				HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
				res = mapper.readValue(response.body(), ResultMoMo.class);
			} catch (InterruptedException | URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (res != null) {
				
				resp.sendRedirect(res.payUrl);
			} else {
				req.setAttribute("Result", "Đặt hàng thất bại");
				RequestDispatcher rq=req.getRequestDispatcher("/views/buysucess.jsp");
				rq.forward(req, resp);
			}

		} else {
			
			
			Set<Integer> set1 = orderCheck.keySet();
			for (Integer key1 : set1) {
				float x= orderCheck.get(key1).getAmountFromUser();
				orderCheck.get(key1).setAmountFromUser(x);//--Tiền user trả 
				orderCheck.get(key1).setAmountFromShop((float) ((x)*0.005));//Tiền shop trả cho hệ thống
				orderCheck.get(key1).setAmountToShop(x-(float) ((x)*0.005));//Tiền Shop được nhận
				
				orderDao.create(orderCheck.get(key1));
				Order order = new Order();
				order = orderDao.findOneNew();
				for (Integer key : set) {
					CartItem cartItemSelected = new CartItem();
					cartItemSelected = cartItemDao.findCartItemSelected(key1, key);
					if (cartItemSelected != null) {
						OrderStatus orderStatus = new OrderStatus(1);
						OrderDetail orderDetail = new OrderDetail(order, cartItemSelected.getProduct(),
								cartItemSelected.getCount(),10000, cartItemSelected.getTotalPrice(), orderStatus);
						orderDetailDao.create(orderDetail);
						Product product = new Product(cartItemSelected.getProduct().getpId(),
								cartItemSelected.getProduct().getpQuantity() - cartItemSelected.getCount());
						productDao.updateQuantity(product);
					}
				}
			}
			for (Integer key : set) {
				cartItemDao.delete(key);
				cartDao.delete();
			}
			cartItem.clear();
			httpSession.setAttribute("cart", cartItem);
			req.setAttribute("Result", "Đặt hàng thành công");
			RequestDispatcher rq = req.getRequestDispatcher("/views/buysucess.jsp");
			rq.forward(req, resp);
		}
	}
	@SuppressWarnings("unchecked")
	private Map<Integer, CartItem> extracted(Object obj) {
		return (Map<Integer, CartItem>) obj;
	}
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		System.out.print(userDao.getshipper(4));
	}

}

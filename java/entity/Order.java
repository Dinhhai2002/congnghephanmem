package entity;

import java.util.Date;

public class Order {
	private int orderId;
	private User user;
	private Shop shop;
	private String uName;
	private String uPhone;
	private String uAddress;
	private OrderStatus status;
	private float amountFromUser;
	private Date createAt;
	public Order() {
		super();
	}
	public Order(User user, Shop shop, String uName, String uPhone, String uAddress, OrderStatus status,
			float amountFromUser, Date createAt) {
		super();
		this.user = user;
		this.shop = shop;
		this.uName = uName;
		this.uPhone = uPhone;
		this.uAddress = uAddress;
		this.status = status;
		this.amountFromUser = amountFromUser;
		this.createAt = createAt;
	}
	public Order(int orderId, User user, Shop shop, String uName, String uPhone, String uAddress, OrderStatus status,
			float amountFromUser, Date createAt) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.shop = shop;
		this.uName = uName;
		this.uPhone = uPhone;
		this.uAddress = uAddress;
		this.status = status;
		this.amountFromUser = amountFromUser;
		this.createAt = createAt;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPhone() {
		return uPhone;
	}
	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}
	public String getuAddress() {
		return uAddress;
	}
	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public float getAmountFromUser() {
		return amountFromUser;
	}
	public void setAmountFromUser(float amountFromUser) {
		this.amountFromUser = amountFromUser;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", user=" + user.getuId() + ", shop=" + shop.getShopId() + ", uName=" + uName + ", uPhone="
				+ uPhone + ", uAddress=" + uAddress + ", status=" + status.getIdStatus() + ", amountFromUser=" + amountFromUser
				+ ", createAt=" + createAt + "]";
	}
	
	
	
}

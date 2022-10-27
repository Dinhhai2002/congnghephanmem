package entity;

import java.util.Date;

public class Order {
	private int orderId;
	private User user;
	private Shop shop;
	private String uName;
	private String uPhone;
	private String uAddress;
	private boolean isPaidBefore; 
	//private OrderStatus status;
	private float amountFromUser;
	private Date createAt;
	public Order() {
		super();
	}
	public Order(int orderId, User user, Shop shop, String uName, String uPhone, String uAddress, boolean isPaidBefore,
			float amountFromUser, Date createAt) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.shop = shop;
		this.uName = uName;
		this.uPhone = uPhone;
		this.uAddress = uAddress;
		this.isPaidBefore = isPaidBefore;
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
	public boolean isPaidBefore() {
		return isPaidBefore;
	}
	public void setPaidBefore(boolean isPaidBefore) {
		this.isPaidBefore = isPaidBefore;
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
		return "Order [orderId=" + orderId + ", user=" + user + ", shop=" + shop + ", uName=" + uName + ", uPhone="
				+ uPhone + ", uAddress=" + uAddress + ", isPaidBefore=" + isPaidBefore + ", amountFromUser="
				+ amountFromUser + ", createAt=" + createAt + "]";
	}
	
}

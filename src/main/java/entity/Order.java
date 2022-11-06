package entity;

import java.util.Date;

public class Order {
	private int orderId;
	private User user;
	private Shop shop;
	private String uName;
	private User delivery;
	private String uPhone;
	private String uAddress;
	private boolean isPaidBefore; 
	private float amountFromUser;
	private float amountFromShop;
	private float amountToShop;
	private float amountToShipper;
	private Date createAt;
	public Order() {
		super();
	}
	public Order(int orderId, User user, Shop shop, String uName, User delivery, String uPhone, String uAddress,
			boolean isPaidBefore, float amountFromUser, float amountFromShop, float amountToShop, float amountToShipper,
			Date createAt) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.shop = shop;
		this.uName = uName;
		this.delivery = delivery;
		this.uPhone = uPhone;
		this.uAddress = uAddress;
		this.isPaidBefore = isPaidBefore;
		this.amountFromUser = amountFromUser;
		this.amountFromShop = amountFromShop;
		this.amountToShop = amountToShop;
		this.amountToShipper = amountToShipper;
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
	public User getDelivery() {
		return delivery;
	}
	public void setDelivery(User delivery) {
		this.delivery = delivery;
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
	public float getAmountFromShop() {
		return amountFromShop;
	}
	public void setAmountFromShop(float amountFromShop) {
		this.amountFromShop = amountFromShop;
	}
	public float getAmountToShop() {
		return amountToShop;
	}
	public void setAmountToShop(float amountToShop) {
		this.amountToShop = amountToShop;
	}
	public float getAmountToShipper() {
		return amountToShipper;
	}
	public void setAmountToShipper(float amountToShipper) {
		this.amountToShipper = amountToShipper;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", user=" + user + ", shop=" + shop + ", uName=" + uName + ", delivery="
				+ delivery + ", uPhone=" + uPhone + ", uAddress=" + uAddress + ", isPaidBefore=" + isPaidBefore
				+ ", amountFromUser=" + amountFromUser + ", amountFromShop=" + amountFromShop + ", amountToShop="
				+ amountToShop + ", amountToShipper=" + amountToShipper + ", createAt=" + createAt + "]";
	}
	
	
}

package entity;

import java.util.Date;

public class Shop {
	private int shopId;
	private String shopName;
	private User user;
	private Category category;
	private String shopImage;
	private String shopDecription;
	private String shopAddress;
	private Date createAt;
	private boolean isActive;
	private boolean isDelete;
	public Shop() {
		super();
	}
	public Shop(int shopId, String shopName, User user, Category category, String shopImage, String shopDecription,
			String shopAddress, Date createAt, boolean isActive, boolean isDelete) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
		this.user = user;
		this.category = category;
		this.shopImage = shopImage;
		this.shopDecription = shopDecription;
		this.shopAddress = shopAddress;
		this.createAt = createAt;
		this.isActive = isActive;
		this.isDelete = isDelete;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getShopImage() {
		return shopImage;
	}
	public void setShopImage(String shopImage) {
		this.shopImage = shopImage;
	}
	public String getShopDecription() {
		return shopDecription;
	}
	public void setShopDecription(String shopDecription) {
		this.shopDecription = shopDecription;
	}
	public String getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	@Override
	public String toString() {
		return "Shop [shopId=" + shopId + ", shopName=" + shopName + ", user=" + user + ", category=" + category
				+ ", shopImage=" + shopImage + ", shopDecription=" + shopDecription + ", shopAddress=" + shopAddress
				+ ", createAt=" + createAt + ", isActive=" + isActive + ", isDelete=" + isDelete + "]";
	}
	
	
	
}

package entity;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Date;

public class Product {
	private int pId;
	private String pName;
	private float pPrice;
	private String pImage;
	private String pDescription;
	private int pQuantity;
	private int cateID;
	private int shopId;
	private Date createAt;
	private Date updateAt;
	public Product() {
		super();
	}
	public Product(int pId, String pName, float pPrice, String pImage, String pDescription, int pQuantity, int cateID,
			int shopId, Date createAt, Date updateAt) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pImage = pImage;
		this.pDescription = pDescription;
		this.pQuantity = pQuantity;
		this.cateID = cateID;
		this.shopId = shopId;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public float getpPrice() {
		return pPrice;
	}
	public void setpPrice(float pPrice) {
		this.pPrice = pPrice;
	}
	public String getpImage() {
		return pImage;
	}
	public void setpImage(String pImage) {
		this.pImage = pImage;
	}
	public String getpDescription() {
		return pDescription;
	}
	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}
	public int getpQuantity() {
		return pQuantity;
	}
	public void setpQuantity(int pQuantity) {
		this.pQuantity = pQuantity;
	}
	public int getCateID() {
		return cateID;
	}
	public void setCateID(int cateID) {
		this.cateID = cateID;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pName=" + pName + ", pPrice=" + pPrice + ", pImage=" + pImage
				+ ", pDescription=" + pDescription + ", pQuantity=" + pQuantity + ", cateID=" + cateID + ", shopId="
				+ shopId + ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}
	
	
	
	
}
package entity;

public class Product {
	private int pId;
	private String pName;
	private float pPrice;
	private String pImage;
	private String pDescription;
	private int pQuantity;
	private int cateID;
	private int isAdd;
	private int sellId;
	public Product() {
		super();
	}
	public Product(int pId, String pName, float pPrice, String pImage, String pDescription, int pQuantity, int cateID,
			int isAdd, int sellId) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pImage = pImage;
		this.pDescription = pDescription;
		this.pQuantity = pQuantity;
		this.cateID = cateID;
		this.isAdd = isAdd;
		this.sellId = sellId;
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
	public int getIsAdd() {
		return isAdd;
	}
	public void setIsAdd(int isAdd) {
		this.isAdd = isAdd;
	}
	public int getSellId() {
		return sellId;
	}
	public void setSellId(int sellId) {
		this.sellId = sellId;
	}
	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pName=" + pName + ", pPrice=" + pPrice + ", pImage=" + pImage
				+ ", pDescription=" + pDescription + ", pQuantity=" + pQuantity + ", cateID=" + cateID + ", isAdd="
				+ isAdd + ", sellId=" + sellId + "]";
	}
	
	
	
	
	
}

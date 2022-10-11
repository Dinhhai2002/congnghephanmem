package entity;

import java.util.Date;

public class Category {
	private int cId;
	private String cName;
	private String cImage;
	private Date createAt;
	private Date updateAt;
	public Category() {
		super();
	}
	public Category(int cId, String cName, String cImage, Date createAt, Date updateAt) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cImage = cImage;
		this.createAt = createAt;
		this.updateAt = updateAt;

	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}


	public String getcImage() {
		return cImage;
	}
	public void setcImage(String cImage) {
		this.cImage = cImage;
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
		return "Category [cId=" + cId + ", cName=" + cName + ", cImage=" + cImage + ", createAt=" + createAt
				+ ", updateAt=" + updateAt + "]";
	}
	
	
	
	
	

}

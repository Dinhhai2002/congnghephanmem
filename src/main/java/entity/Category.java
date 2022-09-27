package entity;

import java.util.Date;

public class Category {
	private int cId;
	private String cName;
	private Date createAt;
	private Date updateAt;
	public Category() {
		super();
	}
	public Category(int cId, String cName, Date createAt, Date updateAt) {
		super();
		this.cId = cId;
		this.cName = cName;
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
		return "Category [cId=" + cId + ", cName=" + cName + ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}
	
	
	
}

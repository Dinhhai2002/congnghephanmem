package entity;

public class Category {
	private int cateId;
	private String cateName;
	public Category() {
		super();
	}
	public Category(int cateId, String cateName) {
		super();
		this.cateId = cateId;
		this.cateName = cateName;
	}
	public int getCateId() {
		return cateId;
	}
	public void setCateId(int cateId) {
		this.cateId = cateId;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	@Override
	public String toString() {
		return "Category [cateId=" + cateId + ", cateName=" + cateName + "]";
	}
	
	
}

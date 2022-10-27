package entity;

public class evaluate {
	private int id;
	private String content;
	private Product product;
	private User user;
	public evaluate() {
		super();
	}
	public evaluate(int id, String content, Product product, User user) {
		super();
		this.id = id;
		this.content = content;
		this.product = product;
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "evaluate [id=" + id + ", content=" + content + ", product=" + product + ", user=" + user + "]";
	}
	
	
}

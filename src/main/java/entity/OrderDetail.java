package entity;

import java.util.Date;

public class OrderDetail {
	private int id;
	private Order order;//order id
	private Product product; //product id
	private int count;
	private float totalPrice;
	private Date createAt;
	public OrderDetail() {
		super();
	}
	
	public OrderDetail(Order order, Product product, int count, float totalPrice) {
		super();
		this.order = order;
		this.product = product;
		this.count = count;
		this.totalPrice = totalPrice;
	}

	public OrderDetail(int id, Order order, Product product, int count, float totalPrice, Date createAt) {
		super();
		this.id = id;
		this.order = order;
		this.product = product;
		this.count = count;
		this.totalPrice = totalPrice;
		this.createAt = createAt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", order=" + order + ", product=" + product + ", count=" + count
				+ ", totalPrice=" + totalPrice + ", createAt=" + createAt + "]";
	}
	
	
}

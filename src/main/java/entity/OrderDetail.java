package entity;

import java.util.Date;

public class OrderDetail {
	private int id;
	private Order order;//order id
	private Product product; //product id
	private int count;
	private float totalPrice;
	private OrderStatus status;
	private Date createAt;
	public OrderDetail() {
		super();
	}
	
	public OrderDetail(Order order, Product product, int count, float totalPrice, OrderStatus status) {
		super();
		this.order = order;
		this.product = product;
		this.count = count;
		this.totalPrice = totalPrice;
		this.status = status;
	}

	public OrderDetail(int id, Order order, Product product, int count, float totalPrice, OrderStatus status,
			Date createAt) {
		super();
		this.id = id;
		this.order = order;
		this.product = product;
		this.count = count;
		this.totalPrice = totalPrice;
		this.status = status;
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
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", order=" + order.getOrderId() + ", product=" + product.getpId() + ", count=" + count
				+ ", totalPrice=" + totalPrice + ", status=" + status + ", createAt=" + createAt + "]";
	}
	
}
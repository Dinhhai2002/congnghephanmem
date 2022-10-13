package entity;

public class CartItem {
	private int id;
	private Cart cart;
	private Product product;
	private int count;
	private float totalPrice;
	public CartItem() {
		super();
	}
	public CartItem(int id, Cart cart, Product product, int count, float totalPrice) {
		super();
		this.id = id;
		this.cart = cart;
		this.product = product;
		this.count = count;
		this.totalPrice = totalPrice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
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
	@Override
	public String toString() {
		return "CartItem [id=" + id + ", cart=" + cart + ", product=" + product.getpId() + ", count=" + count + ", totalPrice="
				+ totalPrice + "]";
	}
	
	
	
}
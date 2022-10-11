package entity;

public class Cart {
	private int cartId;
	private User user;
	private Shop shop;
	public Cart() {
		super();
	}
	
	public Cart(User user, Shop shop) {
		super();
		this.user = user;
		this.shop = shop;
	}

	public Cart(int cartId, entity.User user, Shop shop) {
		super();
		this.cartId = cartId;
		this.user = user;
		this.shop = shop;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", user=" + user.getuId() + ", shop=" + shop.getShopId() + "]";
	}
	
	
	
}

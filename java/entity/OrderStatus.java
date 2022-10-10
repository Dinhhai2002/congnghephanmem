package entity;

public class OrderStatus {
	private int idStatus;
	private String nameStatus;
	public OrderStatus() {
		super();
	}
	
	public OrderStatus(int idStatus) {
		super();
		this.idStatus = idStatus;
	}

	public OrderStatus(int idStatus, String nameStatus) {
		super();
		this.idStatus = idStatus;
		this.nameStatus = nameStatus;
	}
	public int getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}
	public String getNameStatus() {
		return nameStatus;
	}
	public void setNameStatus(String nameStatus) {
		this.nameStatus = nameStatus;
	}
	@Override
	public String toString() {
		return "OrderStatus [idStatus=" + idStatus + ", nameStatus=" + nameStatus + "]";
	}
	
	
}

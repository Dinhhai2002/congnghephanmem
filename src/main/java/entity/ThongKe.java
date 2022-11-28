package entity;

import java.util.Date;

public class ThongKe {

	private int total;
	private Date createAt;
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	public ThongKe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ThongKe(int total, Date createAt) {
		this.total=total;
		this.createAt=createAt;
	}
}

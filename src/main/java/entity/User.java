package entity;

import java.util.Date;

public class User {
	private int uId;
	private String uName;
	private String uFullName;
	private String uEmail;
	private String uAddress;
	private String uPassword;
	private String uPhone;
	private int idRole;
	private int eWallet;
	private String uImage;
	private Date createAt;
	//private Date updateAt;
	public User() {
		super();
	}
	public User(int uId, String uName, String uFullName, String uEmail, String uAddress, String uPassword,
			String uPhone, int idRole, int eWallet, String uImage, Date createAt) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uFullName = uFullName;
		this.uEmail = uEmail;
		this.uAddress = uAddress;
		this.uPassword = uPassword;
		this.uPhone = uPhone;
		this.idRole = idRole;
		this.eWallet = eWallet;
		this.uImage = uImage;
		this.createAt = createAt;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuFullName() {
		return uFullName;
	}
	public void setuFullName(String uFullName) {
		this.uFullName = uFullName;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getuAddress() {
		return uAddress;
	}
	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	public String getuPhone() {
		return uPhone;
	}
	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}
	public int getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public int geteWallet() {
		return eWallet;
	}
	public void seteWallet(int eWallet) {
		this.eWallet = eWallet;
	}
	public String getuImage() {
		return uImage;
	}
	public void setuImage(String uImage) {
		this.uImage = uImage;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	@Override
	public String toString() {
		return "User [uId=" + uId + ", uName=" + uName + ", uFullName=" + uFullName + ", uEmail=" + uEmail
				+ ", uAddress=" + uAddress + ", uPassword=" + uPassword + ", uPhone=" + uPhone + ", idRole=" + idRole
				+ ", eWallet=" + eWallet + ", uImage=" + uImage + ", createAt=" + createAt + "]";
	}
	
	
}

package entity;

import java.util.Date;

public class user {
	private int uId;
	private String uName;
	private String uFullName;
	private String uEmail;
	private String uAddress;
	private String uPassword;
	private String uPhone;
	private int eWallet;
	private int idRole;
	private int isAccountGoogle;
	private String uImage;
	private Date createAt;
	private Date updateAt;
	public user() {
		super();
	}
	public user(int uId, String uName, String uFullName, String uEmail, String uAddress, String uPassword,
			String uPhone, int eWallet, int idRole, int isAccountGoogle, String uImage, Date createAt, Date updateAt) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uFullName = uFullName;
		this.uEmail = uEmail;
		this.uAddress = uAddress;
		this.uPassword = uPassword;
		this.uPhone = uPhone;
		this.eWallet = eWallet;
		this.idRole = idRole;
		this.isAccountGoogle = isAccountGoogle;
		this.uImage = uImage;
		this.createAt = createAt;
		this.updateAt = updateAt;
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
	public int geteWallet() {
		return eWallet;
	}
	public void seteWallet(int eWallet) {
		this.eWallet = eWallet;
	}
	public int getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public int getIsAccountGoogle() {
		return isAccountGoogle;
	}
	public void setIsAccountGoogle(int isAccountGoogle) {
		this.isAccountGoogle = isAccountGoogle;
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
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	@Override
	public String toString() {
		return "user [uId=" + uId + ", uName=" + uName + ", uFullName=" + uFullName + ", uEmail=" + uEmail
				+ ", uAddress=" + uAddress + ", uPassword=" + uPassword + ", uPhone=" + uPhone + ", eWallet=" + eWallet
				+ ", idRole=" + idRole + ", isAccountGoogle=" + isAccountGoogle + ", uImage=" + uImage + ", createAt="
				+ createAt + ", updateAt=" + updateAt + "]";
	}
	
	
	
	
	
	
}

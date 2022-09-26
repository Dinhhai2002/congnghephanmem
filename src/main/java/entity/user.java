package entity;

public class user {
	private int uId;
	private String uName;
	private String uPassword;
	private int isSell;
	private int isAdmin;
	private String uEmail;
	private String uAddress;
	private String uPhone;
	public user() {
		super();
	}
	public user(int uId, String uName, String uPassword, int isSell, int isAdmin, String uEmail, String uAddress,
			String uPhone) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uPassword = uPassword;
		this.isSell = isSell;
		this.isAdmin = isAdmin;
		this.uEmail = uEmail;
		this.uAddress = uAddress;
		this.uPhone = uPhone;
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
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	public int getIsSell() {
		return isSell;
	}
	public void setIsSell(int isSell) {
		this.isSell = isSell;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
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
	public String getuPhone() {
		return uPhone;
	}
	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}
	@Override
	public String toString() {
		return "user [uId=" + uId + ", uName=" + uName + ", uPassword=" + uPassword + ", isSell=" + isSell
				+ ", isAdmin=" + isAdmin + ", uEmail=" + uEmail + ", uAddress=" + uAddress + ", uPhone=" + uPhone + "]";
	}
	
	
	
	
}

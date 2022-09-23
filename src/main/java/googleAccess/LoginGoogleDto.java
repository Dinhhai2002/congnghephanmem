package googleAccess;



public class LoginGoogleDto {
	private String id;
	private String email;
	
	private String name;
	
	private String link;
	

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	

	public String toString() {
		return

		"GooglePojo [id=" + this.id + ", email=" + this.email + ", verified_email=" + ", name="
				+ this.name +"]";
	}
}

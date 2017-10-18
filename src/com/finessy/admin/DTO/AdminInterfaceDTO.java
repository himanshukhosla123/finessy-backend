package com.finessy.admin.DTO;

public class AdminInterfaceDTO {
	
	private String username;
	private String password;
	private String photo;
	private String role;
	
	public AdminInterfaceDTO() {}

	public AdminInterfaceDTO(String username, String password, String photo, String role) {
		super();
		this.username = username;
		this.password = password;
		this.photo = photo;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "AdminInterfaceDTO [username=" + username + ", password=" + password + ", photo=" + photo + ", role="
				+ role + "]";
	}

}

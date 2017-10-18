package com.finessy.admin.DTO;

public class StudentFormDTO {
	
	private int student_id;
	private String password;
	private String email;
	
	public StudentFormDTO() {}

	public StudentFormDTO(int student_id, String password, String email) {
		super();
		this.student_id = student_id;
		this.password = password;
		this.email = email;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "StudentFormDTO [student_id=" + student_id + ", password=" + password + ", email=" + email + "]";
	}

}

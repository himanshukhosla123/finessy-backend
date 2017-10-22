package com.finessy.admin.DTO;

public class StudentFormDTO {
	
	private int studentId;
	private String password;
	private String email;
	
	public StudentFormDTO() {}

	public StudentFormDTO(String password, String email) {
		super();
		this.password = password;
		this.email = email;
	}

	public StudentFormDTO(int studentId, String password, String email) {
		super();
		this.studentId = studentId;
		this.password = password;
		this.email = email;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
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
		return "StudentFormDTO [studentId=" + studentId + ", password=" + password + ", email=" + email + "]";
	}

}

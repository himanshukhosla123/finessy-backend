package com.finessy.admin.DTO;

public class NotificationsDTO {
	
	private int studentId;
	private int universityId;
	private String courseCode;
	
	public NotificationsDTO() {}

	public NotificationsDTO(int studentId, int universityId, String courseCode) {
		super();
		this.studentId = studentId;
		this.universityId = universityId;
		this.courseCode = courseCode;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getUniversityId() {
		return universityId;
	}

	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	@Override
	public String toString() {
		return "NotificationsDTO [studentId=" + studentId + ", universityId=" + universityId + ", courseCode="
				+ courseCode + "]";
	}

}

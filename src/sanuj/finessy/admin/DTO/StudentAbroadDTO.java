package sanuj.finessy.admin.DTO;

public class StudentAbroadDTO {
	
	private int studentId;
	private int universityId;
	private String courseCode;
	
	public StudentAbroadDTO() {}

	@Override
	public String toString() {
		return "StudentAbroadDTO [studentId=" + studentId + ", universityId=" + universityId + ", courseCode="
				+ courseCode + "]";
	}

	public StudentAbroadDTO(int studentId, int universityId, String courseCode) {
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
	
	

}

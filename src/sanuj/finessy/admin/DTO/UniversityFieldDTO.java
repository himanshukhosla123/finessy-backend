package sanuj.finessy.admin.DTO;

public class UniversityFieldDTO {
  
	private int fieldId;
	private int universityId;
	private String courseCode;
	
	
	public UniversityFieldDTO() {
	}

	@Override
	public String toString() {
		return "UniversityFieldDTO [fieldId=" + fieldId + ", universityId=" + universityId + ", courseCode="
				+ courseCode + "]";
	}

	public UniversityFieldDTO(int fieldId, int universityId, String courseCode) {
		this.fieldId = fieldId;
		this.universityId = universityId;
		this.courseCode = courseCode;
	}

	
	public int getFieldId() {
		return fieldId;
	}

	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
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

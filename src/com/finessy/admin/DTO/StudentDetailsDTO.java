package com.finessy.admin.DTO;

public class StudentDetailsDTO {

	private int studentId;
	private String studentName;
	private int age;
	private String lookingFor;
	private String country;
	private String plannedYearOfHigherStudies;
	private String workEx;
	private String toeflIelts;
	private String gpa;
	private String examScores;
	private String verbalScores;
	private String otherDetails;
	
	public StudentDetailsDTO() {}

	public StudentDetailsDTO(int studentId, String studentName, int age, String lookingFor, String country,
			String plannedYearOfHigherStudies, String workEx, String toeflIelts, String gpa, String examScores,
			String verbalScores, String otherDetails) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.age = age;
		this.lookingFor = lookingFor;
		this.country = country;
		this.plannedYearOfHigherStudies = plannedYearOfHigherStudies;
		this.workEx = workEx;
		this.toeflIelts = toeflIelts;
		this.gpa = gpa;
		this.examScores = examScores;
		this.verbalScores = verbalScores;
		this.otherDetails = otherDetails;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLookingFor() {
		return lookingFor;
	}

	public void setLookingFor(String lookingFor) {
		this.lookingFor = lookingFor;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPlannedYearOfHigherStudies() {
		return plannedYearOfHigherStudies;
	}

	public void setPlannedYearOfHigherStudies(String plannedYearOfHigherStudies) {
		this.plannedYearOfHigherStudies = plannedYearOfHigherStudies;
	}

	public String getWorkEx() {
		return workEx;
	}

	public void setWorkEx(String workEx) {
		this.workEx = workEx;
	}

	public String getToeflIelts() {
		return toeflIelts;
	}

	public void setToeflIelts(String toeflIelts) {
		this.toeflIelts = toeflIelts;
	}

	public String getGpa() {
		return gpa;
	}

	public void setGpa(String gpa) {
		this.gpa = gpa;
	}

	public String getExamScores() {
		return examScores;
	}

	public void setExamScores(String examScores) {
		this.examScores = examScores;
	}

	public String getVerbalScores() {
		return verbalScores;
	}

	public void setVerbalScores(String verbalScores) {
		this.verbalScores = verbalScores;
	}

	public String getOtherDetails() {
		return otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

	@Override
	public String toString() {
		return "StudentDTO [studentId=" + studentId + ", studentName=" + studentName + ", age="
				+ age + ", lookingFor=" + lookingFor + ", country=" + country + ", plannedYearOfHigherStudies="
				+ plannedYearOfHigherStudies + ", workEx=" + workEx + ", toeflIelts=" + toeflIelts + ", gpa=" + gpa
				+ ", examScores=" + examScores + ", verbalScores=" + verbalScores + ", otherDetails=" + otherDetails
				+ "]";
	}

}

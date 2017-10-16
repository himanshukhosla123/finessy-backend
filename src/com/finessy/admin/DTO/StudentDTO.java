package com.finessy.admin.DTO;

public class StudentDTO {

//	student_id` INT(10) NOT NULL AUTO_INCREMENT,
//	  `student_name` VARCHAR(50) NOT NULL,
//	  `email` VARCHAR(50) NOT NULL,
//	  `age` INT(3) NOT NULL,
//	  `looking_for` VARCHAR(10) NULL,
//	  `country` VARCHAR(30) NOT NULL,
//	  `planned_year_of_higher_study` VARCHAR(4) NOT NULL,
//	  `work_ex` VARCHAR(50) NULL,
//	  `toefl/ielts` VARCHAR(10) NULL,
//	  `gpa` VARCHAR(2) NULL,
//	  `exam_scores` VARCHAR(5) NULL,
//	  `verbal_scores` VARCHAR(5) NULL,
//	  `other_details` VARCHAR(150) NOT NULL,
	
	private int studentId;
	private String studentName;
	private String email;
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
	
	public StudentDTO() {
		
	}

	public StudentDTO(int studentId, String studentName, String email, int age, String lookingFor, String country,
			String plannedYearOfHigherStudies, String workEx, String toeflIelts, String gpa, String examScores,
			String verbalScores, String otherDetails) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

}

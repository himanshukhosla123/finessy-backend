package com.finessy.admin.QueriesSQL;

public interface StudentDetailsSQL {
    
	String ADD_STUDENT = "INSERT INTO student_details(`student_id`, `student_name`, `age`, `looking_for`,"
			+ "`country`, `planned_year_of_higher_study`, `work_ex`, `toefl/ielts`, `gpa`, `exam_scores`, `verbal_scores`,"
			+ " `other_details`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
	
	String READ_ALL_STUDENT = "SELECT * FROM student_details;";
	
	String READ_STUDENT = "SELECT * FROM student_details WHERE student_id=?;";
	
	String UPDATE_STUDENT = "UPDATE student_details SET student_name=? age=? looking_for=? country=?"
			+ " planned_year_of_higher_study=? work_ex=? toefl/ielts=? gpa=? exam_scores=? verbal_scores=? other_details=?"
			+ " WHERE student_id=?;";
	
	String DELETE_STUDENT = "DELETE FROM student_details WHERE student_id=?;";

}

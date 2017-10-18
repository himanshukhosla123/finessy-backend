package com.finessy.admin.QueriesSQL;

public interface StudentFormSQL {
	
	String ADD_STUDENT_FORM = "INSERT INTO student_form(`student_id`, `password`, `email`) VALUES(?,?,?);";
	
	String READ_ALL_STUDENT_FORM = "SELECT * FROM student_form;";
	
	String READ_STUDENT_FORM = "SELECT * FROM student_form WHERE student_id=?;";
	
	String UPDATE_STUDENT_FORM = "UPDATE student_form SET student_id=? password=? email=? WHERE student_id=?;";
	
	String DELETE_STUDENT_FORM = "DELETE FROM student_form WHERE student_id=?;";

}

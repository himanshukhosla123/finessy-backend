package com.finessy.admin.QueriesSQL;

public interface ProgramDetailsSQL {
	
	String ADD_PROGRAM = "INSERT INTO program_details(`university_id`, `degree`, `field_id`, `intake_available`, `program_application_deadline`,"
			+ " `requirements`) VALUES(?,?,?,?,?,?);";
	
	String READ_ALL_PROGRAM = "SELECT * FROM program_details;";
	
	String READ_PROGRAM = "SELECT * FROM program_details WHERE university_id=? OR field_id=?;";
	
	String UPDATE_PROGRAM = "UPDATE program_details SET degree=? intake_available=? program_application_deadline=?"
			+ " requirements=? WHERE university_id OR field_id=?;";
	
	String DELETE_PROGRAM = "DELETE FROM program_details WHERE university_id=? OR field_id=?;";

}

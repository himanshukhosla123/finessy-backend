package com.finessy.admin.QueriesSQL;

public interface UniversityDetailsSQL {
    
	String ADD_UNIVERSITY = "INSERT INTO university_details(`university_name`, `campus_size`, `founded`, `type`,"
			+ " `map_location`, `symbol`, `endowment`, `graduate_employbility_ranking`, `total_students`,"
			+ " `total_undergraduate_students`, `total_graduate_students`, `ranking`, `percentage_of_international_students`,"
			+ " `student_groups`, `safety_issues`, `acceptance_rate`, `contact_details`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
	
	String READ_ALL_UNIVERSITY = "SELECT * FROM university_details;";
	
	String READ_UNIVERSITY = "SELECT * FROM university_details WHERE university_id=?;";
	
	String UPDATE_UNIVERSITY = "UPDATE university_details SET university_name=? campus_size=? founded=? type=?"
			+ " map_location=? symbol=? endowment=? graduate_employbility_ranking=? total_students=? total_undergraduate_students=?"
			+ " total_graduate_students=? ranking=? percentage_of_international_students=? student_groups=? safety_issues=?"
			+ " acceptance_rate=? contact_details=? WHERE university_id=?;";
	
	String DELETE_UNIVERSITY = "DELETE FROM university_details WHERE university_id=?;";

}

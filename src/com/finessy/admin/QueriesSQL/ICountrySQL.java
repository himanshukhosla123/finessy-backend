package com.finessy.admin.QueriesSQL;

public interface ICountrySQL {
    
	String ADD_COUNTRY = "INSERT INTO country_details(`country_id`, `country_name`, `no_of_students`,"
			+ " `international_students_percent`, `status`, `happiness_index`, `languages_spoken`, `political_stability`,"
			+ " `climate`, `safety_index`, `disaster_prone`, `student_satisfaction_index`, `ease_of_settlement`,"
			+ " `ease_of_business`, `expense_for_international_students`, `best_thing`, `smoking_drinking_laws`,"
			+ " `currency_strength`, `student_friendly_cities`, `cuisines_available`, `peculiar_laws`, `unknown_facts`)"
			+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
	
	String READ_ALL_COUNTRY = "SELECT * FROM country_details;";
	
	String READ_COUNTRY = "SELECT * FROM country_details WHERE country_id=?;";
	
	String UPDATE_COUNTRY = "UPDATE country_details SET country_id=? country_name=? no_of_students=?"
			+ " international_students_percent=? status=? happiness_index=? languages_spoken=? political_stability=?"
			+ " climate=? safety_index=? disaster_prone=? student_satisfaction_index=? ease_of_settlement=? ease_of_business=?"
			+ " expense_for_international_students=? best_thing=? smoking_drinking_laws=? currency_strength=?"
			+ " student_friendly_cities=? cuisines_available=? peculiar_laws=? unknown_facts=? WHERE country_id=?;";
	
	String DELETE_COUNTRY = "DELETE FROM country_details WHERE country_id=?;";

}

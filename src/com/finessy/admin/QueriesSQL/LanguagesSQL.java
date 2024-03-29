package com.finessy.admin.QueriesSQL;

public interface LanguagesSQL {
	
	String ADD_LANGUAGE = "INSERT INTO languages(`country_id`, `languages_spoken`) VALUES(?,?);";
	
	String READ_ALL_LANGUAGE = "SELECT * FROM languages;";
	
	String READ_LANGUAGE = "SELECT * FROM languages WHERE country_id=?;";
	
//	MAY NOT BE NECESSARY - FIRST DELETE THEN ADD
	String UPDATE_LANGUAGE = "UPDATE languages SET languages_spoken=? WHERE university_id=?;";
	
	String DELETE_LANGUAGE = "DELETE FROM languages WHERE country_id=?;";

}

package com.finessy.admin.QueriesSQL;

public interface FieldFactsSQL {
	
	String ADD_FIELD_FACTS = "INSERT INTO field_facts(`field_id`, `best_market`, `salary_after`, `scope_in_each_country`, `types_of_jobs`,"
			+ " `their_salaries`, `number_of_students`, `number_of_students_interested`, `current_trends`, `value_of_degree_to_work`,"
			+ " `to_get_hired`) VALUES(?,?,?,?,?,?,?,?,?,?,?);";
	
	String READ_ALL_FIELD_FACTS = "SELECT * FROM field_facts;";
	
	String READ_FIELD_FACTS = "SELECT * FROM field_facts WHERE field_id=?;";
	
	String UPDATE_FIELD_FACTS = "UPDATE field_facts SET field_id=? best_market=? salary_after=? scope_in_each_country=? types_of_jobs=?"
			+ " their_salaries=? number_of_students=? number_of_students_interested=? current_trends=? value_of_degree_to_work=?"
			+ " to_get_hired=? WHERE field_id=?;";
	
	String DELETE_FIELD_FACTS = "DELETE FROM field_facts WHERE field_id=?;";

}

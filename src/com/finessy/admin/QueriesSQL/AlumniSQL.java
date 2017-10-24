package com.finessy.admin.QueriesSQL;

public interface AlumniSQL {
	
	String ADD_ALUMNI = "INSERT INTO alumni(`university_id`, `famous_alumni`, `image`) VALUES(?,?,?);";
	
	String READ_ALL_ALUMNI = "SELECT * FROM alumni;";
	
	String READ_ALUMNI = "SELECT * FROM alumni WHERE university_id=?;";
	
	String UPDATE_ALUMNI = "UPDATE alumni SET famous_alumni=? image=? WHERE university_id=?;";
	
	String DELETE_ALUMNI = "DELETE FROM alumni WHERE university_id=?;";

}

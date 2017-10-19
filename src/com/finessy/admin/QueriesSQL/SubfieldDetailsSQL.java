package com.finessy.admin.QueriesSQL;

public interface SubfieldDetailsSQL {
	
	String ADD_SUBFIELD = "INSERT INTO subfield_details(`discipline`, `program`, `jobs`) VALUES(?,?,?);";
	
	String READ_ALL_SUBFIELD = "SELECT * FROM subfield_details;";
	
	String READ_SUBFIELD = "SELECT * FROM subfield_details WHERE field_id=?;";
	
	String UPDATE_SUBFIELD = "UPDATE subfield_details SET discipline=? program=? jobs=? WHERE field_id=?;";
	
	String DELETE_SUBFIELD = "DELETE FROM subfield_details WHERE field_id=?;";

}

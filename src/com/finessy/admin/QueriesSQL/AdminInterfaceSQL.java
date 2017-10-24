package com.finessy.admin.QueriesSQL;

public interface AdminInterfaceSQL {
	
	String ADD_USER = "INSERT INTO admin_interface(`username`, `password`, `photo`, `role`) VALUES(?,?,?,?);";
	
	String READ_ALL_USER = "SELECT * FROM admin_interface;";
	
	String READ_USER = "SELECT * FROM admin_interface WHERE username=?;";
	
	String UPDATE_USER = "UPDATE admin_interface SET password=? photo=? role=? WHERE username=?;";
	
	String DELETE_USER = "DELETE FROM admin_interface WHERE username=?;";

}

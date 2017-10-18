package com.finessy.admin.QueriesSQL;

public class NotificationsSQL {
	
	String ADD_NOTIFICATION = "INSERT INTO notifications(`student_id`, `university_id`, `course_code`) VALUES(?,?,?);";
	
	String READ_ALL_NOTIFICATION = "SELECT * FROM notifications;";
	
	String READ_NOTIFICATION = "SELECT * FROM notifications WHERE student_id=? OR university_id=? OR course_code=?;";
	
	String UPDATE_NOTIFICATION = "UPDATE notifications SET student_id=? university_id=? course_code=? WHERE student_id=? OR university_id=? OR course_code=?;";
	
	String DELETE_NOTIFICATION = "DELETE FROM notifications WHERE student_id=? OR university_id=? OR course_code=?;";

}
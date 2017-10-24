package sanuj.finessy.admin.QueriesSQL;

public interface StudentAbroadSQL {

	String ADD_STUDENT_ABROAD = "INSERT INTO student_abroad(student_id, university_id, course_code) VALUES(?,?,?);";
	
	String READ_STUDENT_ABROAD = "SELECT * FROM student_abroad WHERE student_id=?;";

	String UPDATE_STUDENT_ABROAD = "UPDATE student_abroad SET university_id=?, course_code=? WHERE student_id=?;";
	
	String DELETE_STUDENT_ABROAD = "DELETE FROM student_abroad WHERE student_id=?;";
	
	String READ_ALL_STUDENT_ABROAD = "SELECT * FROM student_abroad;";
}

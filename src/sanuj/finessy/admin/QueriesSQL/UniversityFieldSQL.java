package sanuj.finessy.admin.QueriesSQL;

public interface UniversityFieldSQL {

	String ADD_UNIVERSITY_FIELD = "INSERT INTO university_field(field_id, university_id, course_code) VALUES(?,?,?);";
	
	String READ_UNIVERSITY_FIELD = "SELECT * FROM university_field WHERE field_id=?;";
	
	String UPDATE_UNIVERSITY_FIELD = "UPDATE university_field SET university_id=?, course_code=? WHERE field_id=?;";
	
	String DELETE_UNIVERSITY_FIELD = " DELETE FROM university_field WHERE field_id=?;";
	
	String READ_ALL_UNIVERSITY_FIELD = "SELECT * FROM university_field;";
}

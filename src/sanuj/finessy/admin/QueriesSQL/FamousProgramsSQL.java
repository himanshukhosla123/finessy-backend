package sanuj.finessy.admin.QueriesSQL;

public interface FamousProgramsSQL {

	String ADD_FAMOUS_PROGRAMS = "INSERT INTO famous_programs(university_id, famous_programs) VALUES(?,?);";
	
	String READ_FAMOUS_PROGRAMS = "SELECT * FROM famous_programs WHERE university_id=?;";
	
	String UPDATE_FAMOUS_PROGRAMS = "UPDATE famous_programs SET famous_programs=? WHERE university_id=?;";
	
	String DELETE_FAMOUS_PROGRAMS = "DELETE FROM famous_programs WHERE university_id=?;";
	
	String READ_ALL_FAMOUS_PROGRAMS = "SELECT * FROM famous_programs;";
}

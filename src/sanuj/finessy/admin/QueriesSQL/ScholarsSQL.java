package sanuj.finessy.admin.QueriesSQL;

public interface ScholarsSQL {

	String ADD_SCHOLARS = "INSERT INTO scholars(university_id, scholars) VALUES(?,?);";
	
	String READ_SCHOLARS = "SELECT * FROM scholars WHERE university_id=?;";
	
	String UPDATE_SCHOLARS = "UPDATE scholars SET scholars=? WHERE university_id=?;";
	
	String DELETE_SCHOLARS = "DELETE FROM scholars WHERE university_id=?;";
	
	String READ_ALL_SCHOLARS = "SELECT * FROM scholars;";
}

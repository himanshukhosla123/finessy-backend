package sanuj.finessy.admin.QueriesSQL;

public interface CommentDetailsSQL {
	
	String ADD_COMMENT = "INSERT INTO comment_details(content, student_id) VALUES(?,?);";
	
	String READ_ALL_COMMENT = "SELECT * FROM comment_details;";
	
	String READ_COMMENT = "SELECT * FROM comment_details WHERE comment_id=?;";
	
	String UPDATE_COMMENT = "UPDATE comment_details SET content=? WHERE comment_id=?;";
	
	String DELETE_COMMENT = "DELETE FROM comment_details WHERE comment_id=?;";

}

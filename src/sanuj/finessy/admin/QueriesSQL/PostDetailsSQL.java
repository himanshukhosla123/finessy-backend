package sanuj.finessy.admin.QueriesSQL;

public interface PostDetailsSQL {

	String ADD_POST_DETAILS = "INSERT INTO post_details(content, thumbnail) VALUES(?,?);";
	
	String READ_POST_DETAILS = "SELECT * FROM post_details WHERE post_id=?;";
	
	String UPDATE_POST_DETAILS = "UPDATE post_details SET content=?, thumbnail=? WHERE post_id=?;";
	
	String DELETE_POST_DETAILS = "DELETE FROM post_details WHERE post_id=?;";
	
	String READ_ALL_POST_DETAILS = "SELECT * FROM post_details;";
}

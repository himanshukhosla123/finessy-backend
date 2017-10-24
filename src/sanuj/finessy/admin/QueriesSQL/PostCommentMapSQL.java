package sanuj.finessy.admin.QueriesSQL;

public interface PostCommentMapSQL {
	
	String ADD_POST_COMMENT_MAP = "INSERT INTO post_comment_map(post_id, comment_id) VALUES(?,?);";
	
	String READ_POST_COMMENT_MAP = "SELECT * FROM post_comment_map WHERE post_id=?;";
	
	String UPDATE_POST_COMMENT_MAP = "UPDATE post_comment_map SET comment_id=? WHERE post_id=?;";
	
	String DELETE_POST_COMMENT_MAP = "DELETE FROM post_comment_map WHERE post_id=?;";
	
	String READ_ALL_POST_COMMENT_MAP = "SELECT * FROM post_comment_map";

}

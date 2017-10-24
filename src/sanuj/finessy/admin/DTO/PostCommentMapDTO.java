package sanuj.finessy.admin.DTO;

public class PostCommentMapDTO {

	private int postId;
	private int commentId;
	
	public PostCommentMapDTO() {}

	@Override
	public String toString() {
		return "PostCommentMapDTO [postId=" + postId + ", commentId=" + commentId + "]";
	}

	public PostCommentMapDTO(int postId, int commentId) {
		this.postId = postId;
		this.commentId = commentId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	
	
}

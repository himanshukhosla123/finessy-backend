package sanuj.finessy.admin.DTO;

public class PostDetailsDTO {

	private int postId;
	private String content;
	private String thumbnail;
	private String date;
	private String time;
	
	public PostDetailsDTO() {}

		
	@Override
	public String toString() {
		return "PostDetailsDTO [postId=" + postId + ", content=" + content + ", thumbnail=" + thumbnail + ", date="
				+ date + ", time=" + time + "]";
	}

    
	
	public PostDetailsDTO(int postId, String content, String thumbnail, String date, String time) {
		this.postId = postId;
		this.content = content;
		this.thumbnail = thumbnail;
		this.date = date;
		this.time = time;
	}


	public PostDetailsDTO(String content, String thumbnail) {
		this.content = content;
		this.thumbnail = thumbnail;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}
	
	
}

package sanuj.finessy.admin.DTO;

import java.sql.Date;
import java.sql.Time;

public class CommentDetailsDTO {

	private int commentId;
	private String content;
	private int studentId;
	private Date date;
	private Time time;
	
	public CommentDetailsDTO() {}

	public CommentDetailsDTO(int commentId, String content, int studentId, Date date, Time time) {
		this.commentId = commentId;
		this.content = content;
		this.studentId = studentId;
		this.date = date;
		this.time = time;
	}

	public CommentDetailsDTO(String content, int studentId) {
		this.content = content;
		this.studentId = studentId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "CommentDetailsDTO [commentId=" + commentId + ", content=" + content + ", studentId=" + studentId
				+ ", date=" + date + ", time=" + time + "]";
	}
	
}

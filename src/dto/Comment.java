package dto;

import java.util.Date;

public class Comment {
	private int commentId;
	private int postId;
	private String writer;
	private String password;
	private Date date;
	private String content;
	private int visible;
	
	public Comment() {}
	public Comment(int commentId, int postId, String writer, String password, Date date, String content, int visible) {
		this.commentId = commentId;
		this.postId = postId;
		this.writer = writer;
		this.password = password;
		this.date = date;
		this.content = content;
		this.visible = visible;
	}
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getVisible() {
		return visible;
	}
	public void setVisible(int visible) {
		this.visible = visible;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}

package dto;

import java.util.Date;

public class Post {
	private int postId;
	private int categoryId;
	private Date date;
	private Date modifiedDate;
	private int number;
	private String title;
	private String content;
	private boolean secret;
	private int viewCnt;
	private int commentCnt;
	private int evaluationCnt;
	
	public Post() {}
	public Post(int postId, int categoryId, Date date, Date modifiedDate, int number, String title, boolean secret, 
			int viewCnt, int commentCnt, int evaluationCnt) {
		this(postId, categoryId, date, modifiedDate, number, title, null, secret, viewCnt, commentCnt, evaluationCnt);
	}
	public Post(int postId, int categoryId, String title, String content, boolean secret) {
		this(postId, categoryId, null, null, 0, title, content, secret, 0, 0, 0);
	}
	public Post(int categoryId, String title, String content, boolean secret) {
		this(0, categoryId, null, null, 0, title, content, secret, 0, 0, 0);
	}
	public Post(int postId, int categoryId, Date date, Date modifiedDate, int number, String title, String content,
			boolean secret, int viewCnt, int commentCnt, int evaluationCnt) {
		this.postId = postId;
		this.categoryId = categoryId;
		this.date = date;
		this.modifiedDate = modifiedDate;
		this.number = number;
		this.title = title;
		this.content = content;
		this.secret = secret;
		this.viewCnt = viewCnt;
		this.commentCnt = commentCnt;
		this.evaluationCnt = evaluationCnt;
	}

	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public boolean isSecret() {
		return secret;
	}
	public void setSecret(boolean secret) {
		this.secret = secret;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public int getCommentCnt() {
		return commentCnt;
	}
	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}
	public int getEvaluationCnt() {
		return evaluationCnt;
	}
	public void setEvaluationCnt(int evaluationCnt) {
		this.evaluationCnt = evaluationCnt;
	}
}

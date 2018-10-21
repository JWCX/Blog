package dto;

import java.util.Date;

public class View {
	private int viewId;
	private Post postId;
	private Visitor visitorId;
	private Date date;
	
	public View() {}
	public View(int viewId, Post postId, Visitor visitorId, Date date) {
		this.viewId = viewId;
		this.postId = postId;
		this.visitorId = visitorId;
		this.date = date;
	}
	
	public int getViewId() {
		return viewId;
	}
	public void setViewId(int viewId) {
		this.viewId = viewId;
	}
	public Post getPostId() {
		return postId;
	}
	public void setPostId(Post postId) {
		this.postId = postId;
	}
	public Visitor getVisitorId() {
		return visitorId;
	}
	public void setVisitorId(Visitor visitorId) {
		this.visitorId = visitorId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}

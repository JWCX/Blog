package dto;

public class Evaluation {
	private int evaluationId;
	private Post postId;
	private Visitor visitorId;
	private int value;
	
	public Evaluation() {}
	public Evaluation(int evaluationId, Post postId, Visitor visitorId, int value) {
		this.evaluationId = evaluationId;
		this.postId = postId;
		this.visitorId = visitorId;
		this.value = value;
	}
	
	public int getEvaluationId() {
		return evaluationId;
	}
	public void setEvaluationId(int evaluationId) {
		this.evaluationId = evaluationId;
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
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}

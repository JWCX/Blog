package dto;

public class Tagged {
	private Post postId;
	private Tag TagId;
	
	public Tagged() {}
	public Tagged(Post postId, Tag tagId) {
		this.postId = postId;
		TagId = tagId;
	}
	
	public Post getPostId() {
		return postId;
	}
	public void setPostId(Post postId) {
		this.postId = postId;
	}
	public Tag getTagId() {
		return TagId;
	}
	public void setTagId(Tag tagId) {
		TagId = tagId;
	}
}

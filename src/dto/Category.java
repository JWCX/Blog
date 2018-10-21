package dto;

public class Category {
	private int categoryId;
	private int groupId;
	private int depth;
	private int order;
	private int type;
	private String name;

	public Category() {}
	public Category(int categoryId, int groupId, int depth, int order, int type, String name) {
		this.categoryId = categoryId;
		this.groupId = groupId;
		this.depth = depth;
		this.order = order;
		this.type = type;
		this.name = name;
	}

	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}

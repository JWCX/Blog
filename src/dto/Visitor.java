package dto;

public class Visitor {
	private int visitorId;
	private String ip;
	private int visitCnt;
	
	public Visitor() {}
	public Visitor(int visitorId, String ip, int visitCnt) {
		this.visitorId = visitorId;
		this.ip = ip;
		this.visitCnt = visitCnt;
	}
	
	public int getVisitorId() {
		return visitorId;
	}
	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getVisitCnt() {
		return visitCnt;
	}
	public void setVisitCnt(int visitCnt) {
		this.visitCnt = visitCnt;
	}
}

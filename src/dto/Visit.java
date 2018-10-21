package dto;

import java.util.Date;

public class Visit {
	private int visitId;
	private Visitor visitorId;
	private Date date;
	
	public Visit() {}
	public Visit(int visitId, Visitor visitorId, Date date) {
		this.visitId = visitId;
		this.visitorId = visitorId;
		this.date = date;
	}
	
	public int getVisitId() {
		return visitId;
	}
	public void setVisitId(int visitId) {
		this.visitId = visitId;
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

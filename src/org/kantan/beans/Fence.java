package org.kantan.beans;

import javax.ws.rs.FormParam;

public class Fence {
	
	private String chilEmailId; 
	private String parentEmailId;	
	private String refCoordinates; 
	//private String radiousCoordinates;
	private long radious;
		
	public String getChilEmailId() {
		return chilEmailId;
	}
	public void setChilEmailId(String chilEmailId) {
		this.chilEmailId = chilEmailId;
	}
	public String getParentEmailId() {
		return parentEmailId;
	}
	public void setParentEmailId(String parentEmailId) {
		this.parentEmailId = parentEmailId;
	}
	public String getRefCoordinates() {
		return refCoordinates;
	}
	public void setRefCoordinates(String refCoordinates) {
		this.refCoordinates = refCoordinates;
	}
	public long getRadious() {
		return radious;
	}
	public void setRadious(long radious) {
		this.radious = radious;
	}
}

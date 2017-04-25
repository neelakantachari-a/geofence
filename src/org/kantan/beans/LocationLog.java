package org.kantan.beans;

import java.sql.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="locationLog")
public class LocationLog {

	private String chilEmailId;
	private String coordinates;
	private Date loggedAt;	
	private long awayFromFence;
	
	public String getChilEmailId() {
		return chilEmailId;
	}
	@XmlElement
	public void setChilEmailId(String chilEmailId) {
		this.chilEmailId = chilEmailId;
	}
	public String getCoordinates() {
		return coordinates;
	}
	@XmlElement
	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	public Date getLoggedAt() {
		return loggedAt;
	}
	@XmlElement
	public void setLoggedAt(Date loggedAt) {
		this.loggedAt = loggedAt;
	}
}

package org.kantan.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Child {

	@Override
	public String toString() {
		return "Child [childEmailId=" + childEmailId + ", parentEmailId=" + parentEmailId + ", refCoordinates="
				+ refCoordinates + ", radius=" + radius + "]";
	}
	private String childEmailId;
	private String parentEmailId;
	private String refCoordinates;
	private long radius;
	
	public String getChildEmailId() {
		return childEmailId;
	}
	@XmlElement
	public void setChildEmailId(String childEmailId) {
		this.childEmailId = childEmailId;
	}
	public String getParentEmailId() {
		return parentEmailId;
	}
	@XmlElement
	public void setParentEmailId(String parentEmailId) {
		this.parentEmailId = parentEmailId;
	}
	public String getRefCoordinates() {
		return refCoordinates;
	}
	@XmlElement
	public void setRefCoordinates(String refCoordinates) {
		this.refCoordinates = refCoordinates;
	}
	public long getRadius() {
		return radius;
	}
	@XmlElement
	public void setRadius(long radius) {
		this.radius = radius;
	}
}

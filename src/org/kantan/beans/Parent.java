package org.kantan.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="user")
public class Parent {

	private String emailId;
	private String mobileNum;
	private String pwd;
	private int verified;
	
	public String getEmailId() {
		return emailId;
	}
	@XmlElement
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNum() {
		return mobileNum;
	}
	@XmlElement
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	public String getPwd() {
		return pwd;
	}
	@XmlElement
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getVerified() {
		return verified;
	}
	@XmlElement
	public void setVerified(int verified) {
		this.verified = verified;
	}	
}
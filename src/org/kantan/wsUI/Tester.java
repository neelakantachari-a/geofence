package org.kantan.wsUI;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.net.InetAddress;
import java.net.UnknownHostException;
public class Tester {

	private Client client;
	
	private String REGISTER_REST_SERVICE_URL = "http://192.168.0.103:9999/geoFence/rest/service/register";
	private String getUser_REST_SERVICE_URL = "http://192.168.0.103:9999/geoFence/rest/service/child/";
	private String ADDCHILD_REST_SERVICE_URL = "http://192.168.0.103:9999/geoFence/rest/locations/addChildAndFence";
	private String ADDLOCATIONS_REST_SERVICE_URL = "http://192.168.0.103:9999/geoFence/rest/locations/logLocation";
	private String GETLOCATION_REST_SERVICE_URL = "http://192.168.0.103:9999/geoFence/rest/locations/getlocation/";
	//private String ip="http/"+tester
	
	private static final String SUCCESS_RESULT = "<result>success</result>";
	private static final String PASS = "pass";
	private static final String FAIL = "fail";

	private void init() {
		this.client = ClientBuilder.newClient();
	}
	 /* private static void myIP(String a[]){
		     
	        try {
	        	InetAddress ipAddr = InetAddress.getLocalHost();
	            String s= ipAddr.getHostAddress().toString();
	            } catch (UnknownHostException ex) {
	            ex.printStackTrace();
	        }
	    }*/

	public static void main(String[] args) {
		Tester tester = new Tester();
		
		tester.init();

		//tester.testGetChild();
		//tester.registerTest();
		//tester.addChildAndFenceTest();
		//tester.logLocationTest();
		//tester.getLocationsTest();
		
		
	}

	private void testGetChild() {
		String childDetails = (String) client.target(getUser_REST_SERVICE_URL).path("/{childEmailId}")
				.resolveTemplate("childEmailId", "sagarkh7@gmail.com").request(MediaType.APPLICATION_XML)
				.get(String.class);
		// String result = FAIL;

		System.out.println("Test case name: testGetUser, Result: " + childDetails);
	}

	private void registerTest() {
		System.out.println("about to register");
		Form form = new Form();
		form.param("emailId", "vadithya1993@gmail.com");
		form.param("mobileNum", "999999999");
		form.param("passwd", "abcd");
		form.param("verified", "1");
		System.out.println("after creation");
		String callResult = client.target(REGISTER_REST_SERVICE_URL)
				.request(MediaType.APPLICATION_XML)
				.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), String.class);
		System.out.println();
		System.out.println("mid way thru");
		System.out.println("Test case name: testRegisterUser, Result: " + callResult);
	}
	
	private void addChildAndFenceTest() {
		System.out.println("adding child and defining his fence");
		Form form = new Form();
		form.param("parentEmailId", "deep.blueblip@gmail.com");
		form.param("childEmailId", "neelakanta.rvce@gmail.com");
		form.param("refCoordinates", "12.973922, 77.595181");
		form.param("radius", "30");
		String callResult = client.target(ADDCHILD_REST_SERVICE_URL)
				.request(MediaType.APPLICATION_XML)
				.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), String.class);
		System.out.println("mid way thru");
		System.out.println("Test case name: testAddChild, Result: " + callResult);
	}
	
	
	private void logLocationTest() {
		System.out.println("about to log the location details");
		Form form = new Form();
		form.param("childEmailId", "abc@gmail.com");
		form.param("coordinates", "17.331455, 76.8361607");
		//LocalDateTime ldt = LocalDateTime.now();
		Date d1=new Date();
		//String d1=(new Date()).toString();
		SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yy:HH:mm:SS");
        String loggedAt = dt.format(d1);
		//String loggedAt=new Date().toString();
		form.param("loggedAt", loggedAt);
		System.out.println("after logging the coordinates");
		String callResult = client.target(ADDLOCATIONS_REST_SERVICE_URL)
				.request(MediaType.APPLICATION_XML)
				.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), String.class);
		System.out.println("mid way thru");
		System.out.println("Test case name: logLocationTest, Result: " + callResult);
	}
	
	
	private void getLocationsTest() {
		System.out.println("about to retrieve log details");
				String callResult = (String) client.target(GETLOCATION_REST_SERVICE_URL).path("/{childEmailId}")
				.resolveTemplate("childEmailId", "sagarkh7@gmail.com").request(MediaType.APPLICATION_XML)
				.get(String.class);
		
		System.out.println("mid way thru");
		System.out.println("Test case name: testAddUser, Result: " + callResult);
	}
	
}

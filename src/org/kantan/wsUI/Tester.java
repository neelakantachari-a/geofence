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
public class Tester {

	private Client client;
	
	private String REGISTER_REST_SERVICE_URL = "http://192.168.0.100:8080/geoFence/rest/service/register";
	private String getUser_REST_SERVICE_URL = "http://192.168.0.100:8080/geoFence/rest/service/child/";
	private String ADDCHILD_REST_SERVICE_URL = "http://192.168.0.100:8080/geoFence/rest/locations/addChildAndFence";
	private String ADDLOCATIONS_REST_SERVICE_URL = "http://192.168.0.100:8080/geoFence/rest/locations/logLocation";
	private String GETLOCATION_REST_SERVICE_URL = "http://192.168.0.100:8080/geoFence/rest/locations/getlocation/";
	
	
	private static final String SUCCESS_RESULT = "<result>success</result>";
	private static final String PASS = "pass";
	private static final String FAIL = "fail";

	private void init() {
		this.client = ClientBuilder.newClient();
	}

	public static void main(String[] args) {
		Tester tester = new Tester();
		
		tester.init();

		//tester.testGetChild();
		//tester.registerTest();
		//tester.addChildAndFenceTest();
		tester.logLocationTest();
		//tester.getLocationsTest();
		
		
	}

	private void testGetChild() {
		String childDetails = (String) client.target(getUser_REST_SERVICE_URL).path("/{childEmailId}")
				.resolveTemplate("childEmailId", "abc@gmail.com").request(MediaType.APPLICATION_XML)
				.get(String.class);
		// String result = FAIL;

		System.out.println("Test case name: testGetUser, Result: " + childDetails);
	}

	private void registerTest() {
		System.out.println("about to register");
		Form form = new Form();
		form.param("emailId", "kantan2233");
		form.param("mobileNum", "9686526562");
		form.param("passwd", "clerk");
		form.param("verified", "1");
		System.out.println("after creation");
		String callResult = client.target(REGISTER_REST_SERVICE_URL)
				.request(MediaType.APPLICATION_XML)
				.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), String.class);
		System.out.println("mid way thru");
		System.out.println("Test case name: testRegisterUser, Result: " + callResult);
	}
	
	private void addChildAndFenceTest() {
		System.out.println("adding child and defining his fence");
		Form form = new Form();
		form.param("parentEmailId", "neelakanta.rvce@gmail.com");
		form.param("childEmailId", "khushi@gmail.com");
		form.param("refCoordinates", "123456,432145");
		form.param("radius", "100");
		String callResult = client.target(ADDCHILD_REST_SERVICE_URL)
				.request(MediaType.APPLICATION_XML)
				.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), String.class);
		System.out.println("mid way thru");
		System.out.println("Test case name: testAddChild, Result: " + callResult);
	}
	
	
	private void logLocationTest() {
		System.out.println("about to log the location details");
		Form form = new Form();
		form.param("childEmailId", "deepaksnandihal@gmail.com");
		form.param("coordinates", "14.904153,76.385632");
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
				.resolveTemplate("childEmailId", "abc@gmail.com").request(MediaType.APPLICATION_XML)
				.get(String.class);
		
		System.out.println("mid way thru");
		System.out.println("Test case name: testAddUser, Result: " + callResult);
	}
	
}

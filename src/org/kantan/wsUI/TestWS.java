package org.kantan.wsUI;


import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class TestWS {

	private Client client;
	   //private String REST_SERVICE_URL = "http://localhost:8080/UserManagement/rest/UserService/users";
	   // service/register
	   private String REGISTER_REST_SERVICE_URL = "http://localhost:8080/geoFence/rest/service/register";
	   private String getUser_REST_SERVICE_URL = "http://localhost:8080/geoFence/rest/service/child/";
	   
	   private static final String SUCCESS_RESULT="<result>success</result>";
	   private static final String PASS = "pass";
	   private static final String FAIL = "fail";

	   private void init(){
	      this.client = ClientBuilder.newClient();
	   }

	   public static void main(String[] args){
	      TestWS tester = new TestWS();
	      //initialize the tester
	      tester.init();
	     
	      tester.testGetChild();
	      //tester.registerTest();
	      
	      //test get all users Web Service Method
	      /*tester.testGetAllUsers();
	      //test get user Web Service Method 
	      tester.testGetUser();
	      //test update user Web Service Method
	      tester.testUpdateUser();
	      //test add user Web Service Method
	      tester.testAddUser();
	      //test delete user Web Service Method
	      tester.testDeleteUser();
	      */
	   }

	   private void testGetChild(){
	      String childEmailId = (String) client
	         .target(getUser_REST_SERVICE_URL)
	         .path("/{childEmailId}")
	         .resolveTemplate("childEmailId", "deepaksnandihal@gmail.com")
	         .request(MediaType.APPLICATION_XML)
	         .get(String.class);
	      //String result = FAIL;
	      
	      System.out.println("Test case name: testGetUser, Result: " + childEmailId );
	   }
	   
	   private void registerTest(){
		      Form form = new Form();
		      form.param("emailId", "kantan");
		      form.param("mobileNum", "9686526562");
		      form.param("pwd", "clerk");
		      form.param("verfied", "1");
		      
		      /*@FormParam("emailId") String emailId, @FormParam("mobileNum") String mobileNum, 
				@FormParam("pwd") String pwd, @FormParam("verfied") String verified;
		      */
		      
		      String callResult = client
		         .target(REGISTER_REST_SERVICE_URL)
		         .request(MediaType.APPLICATION_XML)
		         .post(Entity.entity(form,
		            MediaType.APPLICATION_FORM_URLENCODED_TYPE),
		            String.class);
		   
		      String result = PASS;
		      if(!SUCCESS_RESULT.equals(callResult)){
		         result = FAIL;
		      }
		      System.out.println("Test case name: testAddUser, Result: " + result );
		 }
	
	   
	   
	   
	   /*//Test: Get list of all users
	   //Test: Check if list is not empty
	   private void testGetAllUsers(){
	      GenericType<List<User>> list = new GenericType<List<User>>() {};
	      List<User> users = client
	         .target(REST_SERVICE_URL)
	         .request(MediaType.APPLICATION_XML)
	         .get(list);
	      String result = PASS;
	      if(users.isEmpty()){
	         result = FAIL;
	      }
	      System.out.println("Test case name: testGetAllUsers, Result: " + result );
	   }
	   
	   //Test: Get User of id 1
	   //Test: Check if user is same as sample user
	   private void testGetUser(){
	      User sampleUser = new User();
	      sampleUser.setId(1);

	      User user = client
	         .target(REST_SERVICE_URL)
	         .path("/{userid}")
	         .resolveTemplate("userid", 1)
	         .request(MediaType.APPLICATION_XML)
	         .get(User.class);
	      String result = FAIL;
	      if(sampleUser != null && sampleUser.getId() == user.getId()){
	         result = PASS;
	      }
	      System.out.println("Test case name: testGetUser, Result: " + result );
	   }
	   //Test: Update User of id 1
	   //Test: Check if result is success XML.
	   private void testUpdateUser(){
	      Form form = new Form();
	      form.param("id", "1");
	      form.param("name", "suresh");
	      form.param("profession", "clerk");

	      String callResult = client
	         .target(REST_SERVICE_URL)
	         .request(MediaType.APPLICATION_XML)
	         .put(Entity.entity(form,
	            MediaType.APPLICATION_FORM_URLENCODED_TYPE),
	            String.class);
	      String result = PASS;
	      if(!SUCCESS_RESULT.equals(callResult)){
	         result = FAIL;
	      }

	      System.out.println("Test case name: testUpdateUser, Result: " + result );
	   }
	   
	   //Test: Add User of id 2
	   //Test: Check if result is success XML.
	   private void testAddUser(){
	      Form form = new Form();
	      form.param("id", "2");
	      form.param("name", "naresh");
	      form.param("profession", "clerk");

	      String callResult = client
	         .target(REST_SERVICE_URL)
	         .request(MediaType.APPLICATION_XML)
	         .post(Entity.entity(form,
	            MediaType.APPLICATION_FORM_URLENCODED_TYPE),
	            String.class);
	   
	      String result = PASS;
	      if(!SUCCESS_RESULT.equals(callResult)){
	         result = FAIL;
	      }

	      System.out.println("Test case name: testAddUser, Result: " + result );
	   }
	   //Test: Delete User of id 2
	   //Test: Check if result is success XML.
	   private void testDeleteUser(){
	      String callResult = client
	         .target(REST_SERVICE_URL)
	         .path("/{userid}")
	         .resolveTemplate("userid", 2)
	         .request(MediaType.APPLICATION_XML)
	         .delete(String.class);

	      String result = PASS;
	      if(!SUCCESS_RESULT.equals(callResult)){
	         result = FAIL;
	      }

	      System.out.println("Test case name: testDeleteUser, Result: " + result );
	   }*/
}

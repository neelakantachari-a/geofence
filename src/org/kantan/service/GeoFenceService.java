package org.kantan.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.kantan.beans.Child;
import org.kantan.beans.LocationLog;
import org.kantan.beans.Parent;
//import org.kantan.beans.User;
import org.kantan.dao.GeoFenceDao;
import org.kantan.dao.ParentDao;
import org.kantan.dao.UsersDao;

//https://github.com/neelakantachari-a/geofence.git

@Path("/service")
@Produces(MediaType.APPLICATION_XML)
public class GeoFenceService {

	GeoFenceDao dao = new GeoFenceDao();
	
	@POST
	@Path("/register")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String register(@FormParam("emailId") String emailId, @FormParam("mobileNum") String mobileNum, 
			@FormParam("passwd") String passwd, @FormParam("verified") String verified,
			@Context HttpServletResponse response)
	throws IOException{
		int vari=Integer.valueOf(verified);
		Parent parent=new Parent();
		parent.setEmailId(emailId);
		parent.setMobileNum(mobileNum);
		parent.setPwd(passwd);
		parent.setVerified(vari);
		String registerd = "false";
		if(dao.register(parent)>0)
			registerd = "true";
		return registerd;
	}
	
	/*
	 public Boolean register(Parent parent) {
		boolean registerd = false;
		
		if(dao.register(parent)>0)
			registerd = true;
		return registerd;
	}
	*/
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_XML)
	public boolean login(Parent parent) {
		
		return dao.login(parent);		
	}

	//@GET
	//@Path("/Locs/{childEmailId}")
	//@Produces(MediaType.APPLICATION_XML)	
	//public List<LocationLog> getLocationLog(@PathParam("childEmailId") String childEmailId)
	
	@GET
	@Path("/child/{childEmailId}")
	@Produces(MediaType.APPLICATION_XML)	
	public Child getChild(@PathParam("childEmailId") String childEmailId) {
		
		Child child = dao.getChild(childEmailId);
		return child;
	}
	
	@GET
	@Path("/children")
	@Produces(MediaType.APPLICATION_XHTML_XML)	
	public List<Child> getChildern(String parentEmailId) {
		
		List<Child> childern = dao.getChildren(parentEmailId);
		return childern;
	}
	
	@POST
	@Path("/addUser")
	@Produces(MediaType.APPLICATION_XML)	
	public Boolean addChild(Child child){
		
		Boolean created = false;
	
		if(dao.addChild(child)>0)
			created =true;
		return created;
	}
	
	@POST
	@Path("/addLocation")
	@Produces(MediaType.APPLICATION_XML)	
	public Boolean addLocation(LocationLog location)
	{
		Boolean created = false;
		
		if(dao.addLocationLog(location)>0)
			created = true;
		return created;
	}
	
	@GET
	@Path("/Locs/{childEmailId}")
	@Produces(MediaType.APPLICATION_XML)	
	public List<LocationLog> getLocationLog(@PathParam("childEmailId") String childEmailId)
	{
		
		//Child child=dao.getChild(childEmailId);
		List<LocationLog> locations =  dao.getLocationLog(childEmailId);
		//List<LocationLog> locWithDistance = new ArrayList<>();
		
		//for(LocationLog loc : locations)
		//{
			//String coordinate = loc.getCoordinates();
			
	//	}
		return locations;
	}	
	
	
	/*@POST
	@Path("/delete")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean deleteUser(String userId) {
		UsersDao userobj=new UsersDao();
		boolean isDeleted=userobj.deleteUser(userId);
		return isDeleted;
	}
	
	@POST
	@Path("/update")
	public User updateUser(User user1) {
		UsersDao userobj=new UsersDao();
		Boolean isItUpdated=userobj.updateUser(user1);
		User user=null;
		if(isItUpdated)
			{
				user=userobj.getUserDetails(user1.getUserId());
			}
		return user;
	}*/
		
}

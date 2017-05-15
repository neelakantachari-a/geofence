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
//import org.kantan.beans.Fence;
import org.kantan.beans.LocationLog;
import org.kantan.beans.Parent;
import org.kantan.dao.GeoFenceDao;
import org.kantan.dao.UserLocationsDao;
import org.kantan.util.DBConnection;
import java.lang.Math;

@Path("/locations")
public class UserLocations {
	
	GeoFenceDao dao = new GeoFenceDao();
	
	@GET
	@Path("/child/{childEmailId}")
	@Produces(MediaType.APPLICATION_XML)	
	public List<LocationLog> getLocationLog(@PathParam("childEmailId") String childEmailId) {
		
		List<LocationLog> locationLogs = dao.getLocationLog(childEmailId);
		return locationLogs;
	}
	
	@POST
	@Path("/logLocation")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String logLocationData(@FormParam("childEmailId") String childEmailId, @FormParam("coordinates") String coordinates, 
			@FormParam("loggedAt") String loggedAt, @Context HttpServletResponse response)
	throws IOException{		
		
		LocationLog location=new LocationLog();
		location.setChilEmailId(childEmailId);
		location.setCoordinates(coordinates);
		location.setLoggedAt(loggedAt);
		Child child=dao.getChild(childEmailId);
		
		// TO DO : calculate the distance between this coordinate and refCoordinate 
		// if it exceeds radious then push a mail 
		String refCoordinates= child.getRefCoordinates();
		if(calculateDistance(coordinates, child.getRefCoordinates())>child.getRadius())
		{
			MailService.send("neelakanta.rvce@gmail.com","neelu@malgudi1", child.getParentEmailId(), "child out of region alert","Dear parent this is to inform you that presently your child is out of the fence defined by you");
			
		}
		String logged = "false";
		if(dao.addLocationLog(location) >0)
			logged = "true";
		return logged;
	}		
	
	
	@POST
	@Path("/addChildAndFence")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Boolean setGeoFence(@FormParam("parentEmailId") String parentEmailId,@FormParam("chilEmailId") String chilEmailId, @FormParam("refCoordinates") String refCoordinates, 
			@FormParam("radius") long radius, @Context HttpServletResponse response)
	throws IOException{	
		Child childobj=new Child();
		childobj.setChildEmailId(chilEmailId);
		childobj.setParentEmailId(parentEmailId);
		childobj.setRefCoordinates(refCoordinates);
		childobj.setRadius(radius);
		Boolean logged = false;
		if(dao.addChild(childobj) >0)
			logged = true;
		return logged;
	}	
	
	/**
	 *  This method will return the distance in meters 	// this method should not be exposed as web service
	 * @param locationA
	 * @param LocationB
	 * @return
	 */
	public double calculateDistance(String locationA, String locationB){
		String[] locA=locationA.split(",");
		Float lat1=Float.parseFloat(locA[0]);
		Float lon1=Float.parseFloat(locA[1]);
		String[] locB=locationB.split(",");
		Float lat2=Float.parseFloat(locB[0]);
		Float lon2=Float.parseFloat(locB[1]);
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		dist = dist * 1.609344;

		return (dist);
	}
	
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}
	
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}

	public static void mailParenr(String parentMailId ) {
		
		
	}
		
}
		
	

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
import org.kantan.beans.Fence;
import org.kantan.beans.LocationLog;
import org.kantan.beans.Parent;
import org.kantan.dao.GeoFenceDao;
import org.kantan.dao.UserLocationsDao;
import org.kantan.util.DBConnection;

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
	public String logLocationData(@FormParam("chilEmailId") String chilEmailId, @FormParam("coordinates") String coordinates, 
			@FormParam("loggedAt") String loggedAt, @Context HttpServletResponse response)
	throws IOException{		
		
		LocationLog location=new LocationLog();
		location.setChilEmailId(chilEmailId);
		location.setCoordinates(coordinates);
		location.setLoggedAt(loggedAt);
		
		String logged = "false";
		if(dao.addLocationLog(location) >0)
			logged = "true";
		return logged;
	}		
	
	@POST
	@Path("/logLocation")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String setGeoFence(@FormParam("parentEmailId") String parentEmailId,@FormParam("chilEmailId") String chilEmailId, @FormParam("refCoordinates") String refCoordinates, 
			@FormParam("radiousCoordinates") String radiousCoordinates, @Context HttpServletResponse response)
	throws IOException{		
		
		Fence fenceObj = new Fence();
		fenceObj.setChilEmailId(chilEmailId);
		fenceObj.setParentEmailId(parentEmailId);
		fenceObj.setRefCoordinates(refCoordinates);
		//fenceObj.setRadiousCoordinates(radiousCoordinates);
		fenceObj.setRadious(this.calculateDistance(refCoordinates, radiousCoordinates));
		String logged = "false";
		if(dao.addFence(fenceObj) >0)
			logged = "true";
		return logged;
	}	
	

	/**
	 *  This method will return the distance in meters 	// this method should not be exposed as web service
	 * @param locationA
	 * @param LocationB
	 * @return
	 */
	public int calculateDistance(String locationA, String LocationB){
		// int distance = 0;
		// till we complete the calculation part distance will be 2000 meter as a default
		int distance = 2000;
		
		// TO DO : calculate distance here
		
		return distance;
	}
}

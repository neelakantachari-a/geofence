package org.kantan.CakeUI;

import java.text.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.*;

import org.kantan.beans.Parent;
import org.kantan.beans.LocationLog;
import org.kantan.service.GeoFenceService;
//import org.kantan.dao.UserLocationDao;
import org.kantan.service.UserLocations;
//import org.kantan.service.UsersService;

public class MyApp {

	public static void main(String args[]) {
		GeoFenceService obj=new GeoFenceService();
		List<LocationLog> locations=obj.getLocationLog("deepaksnandihal@gmail.com");
		System.out.println("displaying locations");
		for(LocationLog loc:locations)
			System.out.println(loc.getChildEmailId());
	}
	}

	
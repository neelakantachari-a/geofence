package org.kantan.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.kantan.beans.Child;
//import org.kantan.beans.Fence;
import org.kantan.beans.LocationLog;
import org.kantan.beans.Parent;
import org.kantan.util.DBConnection;

public class GeoFenceDao {

	public int register(Parent user)
	{	
		int isInserted=0;
		try{
			Connection conn= DBConnection.getConnection();			 
			 String insertSql="insert into parent(emailID,passwd,mobileNum, verified) "+
					 "values('"+user.getEmailId()+"','"+user.getPwd()+"','"+user.getMobileNum()+"',"+user.getVerified()+")";
			 Statement st=conn.createStatement();
			 isInserted=st.executeUpdate(insertSql);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return isInserted;
	}
	
	public boolean login(Parent user)
	{
		boolean valid = false;		
		try{		
			Connection conn=DBConnection.getConnection();
			String getLocSql="select * from parent where userId='"+user.getEmailId()+"' AND passwd='"+user.getPwd()+"'" ;
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(getLocSql);
			if(rs.next())
			{
				valid = true;
			}
		}catch(Exception e){
				e.printStackTrace();
		}				
		return valid;
	}
	
	public Child getChild(String childEmailId)
	{
		Child child = new Child();
		try{		
			Connection conn=DBConnection.getConnection();
			String getLocSql="select * from child WHERE childEmailID ='"+childEmailId+"'" ;
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(getLocSql);
			if(rs.next())
			{
				child.setChildEmailId(rs.getString("childEmailID"));
				child.setParentEmailId(rs.getString("parentEmailID"));
				child.setRefCoordinates(rs.getString("refCoordinates"));
				child.setRadius(rs.getLong("radius"));
				//return child;
			}
		}catch(Exception e){
				e.printStackTrace();
		}		
		return child;
	}

	public List<Child> getChildren(String parentEmailId)
	{
		List<Child> children = null;

		try{		
			Connection conn=DBConnection.getConnection();
			String getLocSql="select * from parent p LEFT JOIN child c on p.emailID = c.parentEmailID  where parentEmailID='"+parentEmailId+"'" ;
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(getLocSql);
			while(rs.next())
			{
				Child child = new Child();
				
				child.setChildEmailId(rs.getString("childEmailID"));
				child.setParentEmailId(rs.getString("parentEmailID"));
				child.setRefCoordinates(rs.getString("refCoordinates"));
				child.setRadius(rs.getLong("radius"));
				children.add(child);
			}
		}catch(Exception e){
				e.printStackTrace();
		}	
		
		return children;
	}

	public int addChild(Child child)
	{
		int countChildAdded = 0;
		
		try{
			Connection conn= DBConnection.getConnection();
			 String insertSql="insert into child(childEmailID, parentEmailID, refCoordinates, radius) values('"+ child.getChildEmailId()+"','"+child.getParentEmailId()+"','"+child.getRefCoordinates()+"',"+child.getRadius()+")";
			Statement st=conn.createStatement();
			countChildAdded =st.executeUpdate(insertSql);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return countChildAdded;
	}
	
	public ArrayList<LocationLog> getLocationLog(String childEmailId)
	{
		ArrayList<LocationLog> locations = new ArrayList<LocationLog>();
		try{		
			Connection conn=DBConnection.getConnection();
			String getLocSql="select * from locationlog where childEmailID ='"+childEmailId+"'" ;
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(getLocSql);
			
			while(rs.next())
			{
				LocationLog location = new LocationLog();
				
				location.setChildEmailId(rs.getString("childEmailID"));
				location.setCoordinates(rs.getString("coordinates"));
				//location.setLoggedAt(rs.getDate("loggedAt").toString());
				location.setLoggedAt(rs.getString("loggedAt"));
				locations.add(location);
			}
		}catch(Exception e){
				e.printStackTrace();
		}		
		return locations;
	}	
	
	public int addLocationLog(LocationLog location)
	{
		int inserted = 0;
		
		try{
			Connection conn= DBConnection.getConnection();
			String emailId=location.getChildEmailId();
			String coordinates=location.getCoordinates();
			String loggedAt=location.getLoggedAt();
			//Date logDate=Date.valueOf(loggedAt);
			String insertSql="insert into locationlog(childEmailID,coordinates,loggedAt) values('"+emailId+"','"+coordinates+"','"+loggedAt+"')";
			Statement st=conn.createStatement();
			inserted = st.executeUpdate(insertSql);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return inserted;		
	}
	
	
}

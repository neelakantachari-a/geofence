package org.kantan.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.kantan.beans.Parent;
import org.kantan.util.DBConnection;

public class UsersDao {
	/*
	public boolean register(User user)
	{	

		int isInserted=0;
		try{
		Connection conn= DBConnection.getConnection();
		 
		 String insertSql="insert into users(userId,userName,password,ipAddress,guardianMobileNo) values('"+user.getUserId()+"','"+user.getUserName()+"','"+user.getPassword()+"','"+user.getIpAddress()+"','"+user.getGurdianMobileNo()+"')";
		 Statement st=conn.createStatement();
		 isInserted=st.executeUpdate(insertSql);
				}catch(Exception ex){
			ex.printStackTrace();
		}
		if(isInserted>0)return true;
		return false;
	}
	
	public User getUserDetails(String Id) {
		
		User userObj=new User();
		try{		
			Connection conn=DBConnection.getConnection();
			String getLocSql="select * from users where userId='"+Id+"'";
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(getLocSql);
			if(rs.next())
			{							
				userObj.setUserId(rs.getString("userId"));
				userObj.setUserName(rs.getString("userName"));
				userObj.setPassword(rs.getString("password"));
				userObj.setIpAddress(rs.getString("ipAddress"));
				userObj.setGuardianMobileNo(rs.getString("guardianMobileNo"));			
			}
		}catch(Exception e){
				e.printStackTrace();
		}
		return userObj;	
	}
	
	public ArrayList<User> getAllUserDetails()
	{		
		ArrayList<User> userList=new ArrayList<>();
		
		//new ArrayList<>();
		User userObj= null; //new User(); 
		
		try{		
			Connection conn=DBConnection.getConnection();
			String getLocSql="select * from users";
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(getLocSql);
			//userList = new ArrayList<>();
			int a = 0;
			
			while(rs.next())
			{
				userObj = new User();
				userObj.setUserId(rs.getString("userId"));
				userObj.setUserName(rs.getString("userName"));
				userObj.setPassword(rs.getString("password"));
				userObj.setIpAddress(rs.getString("ipAddress"));
				userObj.setGuardianMobileNo(rs.getString("guardianMobileNo"));				
				userList.add(userObj);				
			}			
			System.out.println("users are");
			for(User usr:userList)
			System.out.println(usr);
			System.out.println(userList.size());
			
			return userList;
		}catch(Exception e){
				e.printStackTrace();
		}
		
		return userList;		
	}
	
	public boolean deleteUser(String Id) {
		User userObj=new User();
		int isDeleted=0;
		try{		
			Connection conn=DBConnection.getConnection();
			Statement stmt=conn.createStatement();
			String getLocSql="delete from users where userId='"+Id+"'";
			isDeleted=stmt.executeUpdate(getLocSql);
			
		}catch(Exception e){
				e.printStackTrace();
		}
		if(isDeleted>0)return true;
		return false;
	}
	

	public boolean updateUser(User user)
	{
		int isUpdated=0;	
		try{
			Connection conn= DBConnection.getConnection();
			 
			 String updateSql="update users set userName='"+user.getEmailId()+"', password='"+user.getPassword()+"',ipAddress='"+user.getIpAddress()+"',guardianMobileNo='"+user.getGurdianMobileNo()+"' where userId='"+user.getUserId()+"'";
					 //" users(userId,coordinates,recordedAt) values('"+userId+"','"+userName+"','"+password+"','"+ipAddress+"','"+guardianMobileNo+"')";
			 Statement st=conn.createStatement();
			 isUpdated=st.executeUpdate(updateSql);
					}catch(Exception ex){
				ex.printStackTrace();
			}
			if(isUpdated>0)return true;
			return false;		
	}*/
}

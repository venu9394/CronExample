package com.javacodegeeks.snippets.enterprise.quartzexample.job;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class job1_sub {
	
	 
	   
public synchronized Map calljob (int minLimit, int MaxLimit, Connection con,String FETCHQUERY,String INSERTQURY,int CallNum){
	
	 //System.out.println("15");
		
		Map  map=new HashMap()  ;
		int[] excutBatch;
		try{
			
			//System.out.println("12");
			boolean flag=false;
			int MiniLimit_m=MaxLimit+1;
			int MaxLimit_m=MaxLimit+100;
			String DATEON=null;
			
			map.put("minLimit", ""+MiniLimit_m+"");
			map.put("MaxLimit", ""+MaxLimit_m+"");
			
			//String Query=Job1.fetchQuery;
			
			/*PreparedStatement pstmt = con.prepareStatement( Query.toString());*/
			
			
			//System.out.println("2");
			
		 PreparedStatement pstmt = con.prepareStatement(FETCHQUERY);
		 
		   pstmt.setInt(1, minLimit);
		      
		    System.out.println(pstmt);
		    
		     PreparedStatement stmt=con.prepareStatement(INSERTQURY);
		      
		     ResultSet rs = pstmt.executeQuery();
		     StringBuffer EmployeeID=new StringBuffer(); 
		 
		   while (rs.next()) {
		    
			   flag=true;
			   DATEON=rs.getString(1);
			   
			   EmployeeID.append("'"+rs.getString("EmpCode")+"'");
			   
			  /* stmt.setString(1, rs.getString(1));
			   stmt.setString(2, rs.getString(2));
			   stmt.setString(3, rs.getString(3));
			   stmt.setString(4, rs.getString(4));
			   
			   stmt.setString(5, rs.getString(1));
			   stmt.setString(6, rs.getString(2));
			   stmt.setString(7, rs.getString(3));
			   stmt.setString(8, rs.getString(4));*/
			   
			  // DATEON=rs.getString(1);
			   
		     //  stmt.addBatch();
		      
		   }
		   rs=null;
		   rs = pstmt.executeQuery();
		   if(flag){
			   
		   }
		   
		   
		   
		   
		   if(flag){
		   excutBatch=stmt.executeBatch();
		   if(excutBatch.length>0){
		      map.put("exuFlag", "true");
		      if(CallNum==1){
		       map.put("DATEON", DATEON);
		      }
		   }else{
			   map.put("exuFlag", "false");
		   }
		   
		   }else{
			   
			    map.put("minLimit", "0");
				map.put("MaxLimit", "0");
				map.put("exuFlag", "false");
			   
		   }
		   
		}catch(Exception Err){
			System.out.println("Exception at sub class" +Err);
		}
	
		 return map;
	}
	
	

}

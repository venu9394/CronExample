package com.javacodegeeks.snippets.enterprise.quartzexample.job;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.rqp.filemanagment.CopyDirectoryExample;

public class Jobload implements Job { 
	
	
	
	
        private int minLimit=0;
		private int MaxLimit=100; 
		private String Flag=null;
		private String Flag2 ="true";
		private boolean whilflag=true;
		Connection con=Util.getConnection(); 
		public static String FETCHQUERY=null;
		public static String INSERTQURY=null;
		
		 
	public Jobload(){
		  this.minLimit=minLimit;
		  this.MaxLimit=MaxLimit;
		  this.Flag=Flag;
		  this.whilflag=whilflag;
		  
	      }
	
	
	public void execute (JobExecutionContext context)  throws JobExecutionException {
		 
		 
		job1_sub obj=new  job1_sub();
		 
		
		try {
			Properties prop = Util.loadPropertiesFile();
			
              FETCHQUERY=prop.getProperty("FETCHQUERY");
			  INSERTQURY=prop.getProperty("INSERTQURY");
		} catch (Exception e1) {
			 
			e1.printStackTrace();
		}
		 
		try {
		 
			CopyDirectoryExample calldata=new CopyDirectoryExample();
			
			try{
	    	 calldata.getFile("D:/1" , "D:/2/Backup");
			}catch(Exception erd){
				System.out.println("Fetch Data :" +erd);
			}
	    	
			
         /* Map hm=obj.calljob(minLimit, MaxLimit,con,FETCHQUERY,INSERTQURY);
    
          minLimit=Integer.parseInt(hm.get("minLimit").toString());
          MaxLimit=Integer.parseInt(hm.get("MaxLimit").toString());
          Flag=hm.get("exuFlag").toString();
          
          System.out.println(hm.toString());
          hm=null;
       
     if(minLimit>0 && minLimit>0 && Flag.equalsIgnoreCase("true") ){
    	 whilflag=true;
  	  
    	 //System.out.println("HIII");
    	 
    	 while(whilflag){
    		 
    		 try{
    		 Thread.sleep(1000*2);
    		 }catch(Exception th){
    			 System.out.println(th);
    		 }
    		 
    		 
    	  hm=obj.calljob(minLimit, MaxLimit,con,FETCHQUERY,INSERTQURY);
    	  
    	  minLimit=Integer.parseInt(hm.get("minLimit").toString());
          MaxLimit=Integer.parseInt(hm.get("MaxLimit").toString());
          Flag=hm.get("exuFlag").toString();
          
          if(Flag.equalsIgnoreCase("true")){
        	  whilflag=true;
    	 }else{
    		 whilflag=false;
    	 }
    	 
    
  	  
      } 
     } */
                     
     } catch(Exception ERR){
		
		System.out.println("Error at Main Class " +ERR);
	}finally
		{
			try {
				con.close();
				 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

	/*public void run() {
		// TODO Auto-generated method stub
		
	}*/
		
}
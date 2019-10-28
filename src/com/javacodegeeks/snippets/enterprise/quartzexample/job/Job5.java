package com.javacodegeeks.snippets.enterprise.quartzexample.job;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Job5 implements Job{ 
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Job5 --->>> Hello geeks! Time is " + new Date());
		} 
}
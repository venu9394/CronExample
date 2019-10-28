package com.javacodegeeks.snippets.enterprise.quartzexample.job;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Job3 implements Job{ 
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Job3 --->>> Hello geeks! Time is " + new Date());
		} 
}
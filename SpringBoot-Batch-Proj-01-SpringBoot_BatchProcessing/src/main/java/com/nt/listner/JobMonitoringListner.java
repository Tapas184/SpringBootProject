package com.nt.listner;

import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class JobMonitoringListner implements JobExecutionListener {
	
	private long start,end;

	@Override
	public void beforeJob(JobExecution jobExecution) {
		start=System.currentTimeMillis();
		System.out.println("Job is about to start"+new Date());

	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		end = System.currentTimeMillis();
		System.out.println("Job is ended"+new Date());
		System.out.println("Job Execution status");
		System.out.println(end-start);

	}

}

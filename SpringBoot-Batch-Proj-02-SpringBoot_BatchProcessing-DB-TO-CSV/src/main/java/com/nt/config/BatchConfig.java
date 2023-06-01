package com.nt.config;


import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.nt.listner.JobMonitoringListner;
import com.nt.model.Employee;
import com.nt.process.EmployeeItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	// Dependency class need to be inject through AUtoWaired
	@Autowired
	private DataSource ds;
	@Autowired
	private JobBuilderFactory jbfactory;
	@Autowired 
	private StepBuilderFactory sbfactory;
	
	//listner
	@Bean
	JobExecutionListener createListner() {
		return new JobMonitoringListner();
	}
	//processor
	@Bean
	ItemProcessor<Employee,Employee> createProcessor(){
		return new EmployeeItemProcessor();
	}
	
	@Bean
	//make this method as java bean as this method is predefined
	ItemReader<Employee> createReader(){
		return new JdbcCursorItemReaderBuilder<Employee>()
				//logical name
				   .name("reader")
				   //set data source
				   .dataSource(ds)
				   //like chunk size
				   .fetchSize(5)
				   //set query
				   .sql("SELECT EMPNO,ENAME,SAL,ADDRESS,GROSSSAL,NETSAL FROM BATCHEMPLOYEE")
				   //get data from db to mapper object
				   .rowMapper((rs,rowmap)-> new Employee(rs.getInt(1),
						                                  rs.getString(2),
						                                  rs.getInt(3),
						                                  rs.getString(4),
						                                  rs.getInt(5),
						                                  rs.getInt(6)))
				   .build();
				   
	}//create reader method
	
	//create writer object
	@Bean
	ItemWriter<Employee> createWriter(){
		return new FlatFileItemWriterBuilder<Employee>()
				  //logical name
				   .name("writer")
				   //Specify the Resource location("D:/SpringBatch/Employee.csv")
				   .resource(new FileSystemResource("D:/SpringBatch/Employee.csv"))
				   .delimited().delimiter(",")
				   .names("empno","ename","sal","address","grossSal","netSal")
				   .build();
	}//end of writer method
	
	//create steps
	@Bean(name = "step1")
	Step createStep1() {
		return sbfactory.get("step1") //get the step name 
				.<Employee,Employee>chunk(5)
				.reader(createReader())
				.processor(createProcessor())
				.writer(createWriter())
				.build();
	}// create step method
	@Bean(name = "job1")
	Job createJob() {
		return jbfactory.get("job1")
				.start(createStep1())
				.listener(createListner())
				.incrementer(new RunIdIncrementer())
				.build();
	}
}

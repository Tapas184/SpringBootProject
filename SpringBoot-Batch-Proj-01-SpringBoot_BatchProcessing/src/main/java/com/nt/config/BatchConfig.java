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
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.nt.listner.JobMonitoringListner;
import com.nt.model.Employee;
import com.nt.processor.EmployeeItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private DataSource ds;
	@Autowired
	private JobBuilderFactory jobfactory;
	@Autowired
	private StepBuilderFactory stepfactory;
	
	
	//listner
	@Bean
	 JobExecutionListener createListner() {
		return new JobMonitoringListner();
	}
	//processor
	@Bean
	public ItemProcessor<Employee, Employee> createProcessor(){
		return new EmployeeItemProcessor();
	}
	//create reader
	
	/*public ItemReader<Employee> createReader(){
		//create Object for FlatFileReader
		FlatFileItemReader<Employee> reader = new FlatFileItemReader<Employee>();
		//set resource csv location
		reader.setResource(new ClassPathResource("Employee_Info.csv"));
		//set line mapper
		reader.setLineMapper(new DefaultLineMapper<Employee>(){{
			setLineTokenizer(new DelimitedLineTokenizer() {
				{
				setDelimiter(",");
				setNames("empno","ename","sal","addrs");
				}
			});
			//set field set mapper to write each line container to model class object
			setFieldSetMapper(new BeanWrapperFieldSetMapper<Employee>() {{
				setTargetType(Employee.class);
			}});
		}});
		return reader;
	}*/
	
	/*	public ItemReader<Employee> createReader(){
			//create Object for FlatFileReader
			FlatFileItemReader<Employee> reader = new FlatFileItemReader<Employee>();
			//set resource csv location
			reader.setResource(new ClassPathResource("Employee_Info.csv"));
			//field set mapper
		   BeanWrapperFieldSetMapper<Employee> mapper  = new BeanWrapperFieldSetMapper<Employee>();
			     mapper.setTargetType(Employee.class);
			//set line mapper
			DefaultLineMapper<Employee> lineMaper = new DefaultLineMapper<Employee>();
			     DelimitedLineTokenizer token = new DelimitedLineTokenizer();
			         token.setDelimiter(",");
			        token.setNames("empno","ename","sal","addrs");
			//add line Tokenizer,fieldsetmapper to Line Mapper
			        lineMaper.setLineTokenizer(token);
			        lineMaper.setFieldSetMapper(mapper);
			//add line maper to reader
			reader.setLineMapper(lineMaper);
			return reader;
		}*/
	@Bean(name = "reader")
	 ItemReader<Employee> createReader(){
				return new FlatFileItemReaderBuilder<Employee>()
						.name("reader")
						.resource(new ClassPathResource("Employee_Info.csv"))
						.delimited().delimiter(",")
						.names("empno","ename","salary","addrs")
						.targetType(Employee.class)
						.build();
	}
	@Bean(name = "writer")
	 ItemWriter<Employee> createWriter(){
		return new JdbcBatchItemWriterBuilder<Employee>()
				.dataSource(ds)
				.sql("INSERT INTO BATCHEMPLOYEE VALUES(:empno,:ename,:sal,:addrs,:grossSal,:netSal)")
				.beanMapped() //makes to use BeanPropertyItemsqlParameterSourceProvider internally
				.build();

	}
	//create step obj
	@Bean(name = "step1")
	 Step createStep1() {
		return stepfactory.get("step1")
				.<Employee,Employee>chunk(3)
				.reader(createReader())
				.processor(createProcessor())
				.writer(createWriter())
				.build();
	}
	//create Job object
	@Bean("job1")
	 Job createJob() {
		return jobfactory.get("job1")
				.incrementer(new RunIdIncrementer())
				.listener(createListner())
				.start(createStep1())
				.build();
	}
}

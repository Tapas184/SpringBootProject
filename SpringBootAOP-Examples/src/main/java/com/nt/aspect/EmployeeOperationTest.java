package com.nt.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component // make the class as java bean class
@Aspect // make the class AOP
public class EmployeeOperationTest {

private static final Logger log = LoggerFactory.getLogger(EmployeeOperationTest.class);

	@Pointcut("@annotation(com.nt.annotaion.CustomTxn)") //define the method which want to do some extra operations
	//@Pointcut("execution(* com.nt.dao.EmployeeDao.saveEmployee())")
	public void p1() {
		
	}
	@Before(value = "p1()")// it will execute before the method call
	public void beginTxn() {
		log.info("Begin the txn----");
	}
}//end of the class EmployeeOperationTest

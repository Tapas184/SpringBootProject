package com.nt.annotaion;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;
//create custome class annotation
@Retention(RUNTIME) //when it will work
@Target(METHOD) //define where u want to use this annotation
@Component
public @interface CustomTxn {
	


}

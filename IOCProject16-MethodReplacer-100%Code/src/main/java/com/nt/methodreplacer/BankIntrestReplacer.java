//replacer class for bank intrest method
package com.nt.methodreplacer;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
@Component("intrestReplacer")
public class BankIntrestReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object intrest, Method method, Object[] args) throws Throwable {
	System.out.println("BankIntrestReplacer.reimplement(-,-,-):: Simple Inrest");
	double pamount =(double)args[0];
	double rate = (double)args[1];
	double time = (double)args[2];
	//writen replacemnet logic
	return (pamount*rate*time)/100;
    }

}

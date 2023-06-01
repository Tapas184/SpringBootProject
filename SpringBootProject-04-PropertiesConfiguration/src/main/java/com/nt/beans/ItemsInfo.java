package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("info")
@PropertySource("com/nt/commons/inputs.properties") 
//for multiple user defined properties file if you want to place@PropertySource("{com/nt/commons/inputs.properties,<properties Files path>}")
public class ItemsInfo {
	@Value("${idly.price}")
	public float idlyPrice;
	@Value("${dosa.price}")
	public float dosaPrice;
	@Override
	public String toString() {
		return "ItemsInfo [idlyPrice=" + idlyPrice + ", dosaPrice=" + dosaPrice + "]";
	}
	

}

package com.nt.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("bill")
public class BillGenerator {
	@Value("#{info.idlyPrice+info.dosaPrice}")
	private float total;
	@Value("Udupi")
	private String hotelname;
	@Autowired
	private ItemsInfo info;
	@Override
	public String toString() {
		return "BillGenerator [total=" + total + ", hotelname=" + hotelname + ", info=" + info + "]";
	}
	

}

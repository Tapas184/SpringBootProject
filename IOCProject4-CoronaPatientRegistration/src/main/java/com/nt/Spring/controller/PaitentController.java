package com.nt.Spring.controller;

import com.nt.Spring.dto.PaitentDTO;
import com.nt.Spring.service.IpatientService;
import com.nt.Spring.vo.PaitentVo;

public class PaitentController {
    
    public IpatientService service;

    public PaitentController(IpatientService service) {
	System.out.println("IpatientService::1-parameter constructor");
	this.service = service;
    }
    public String processingPaitentData(PaitentVo  vo) throws Exception{
	//convert Vo data to DTO 
	PaitentDTO dto = new PaitentDTO();
	dto.setDays(Integer.parseInt(vo.getDays()));
	dto.setPaitentaddress(vo.getPaitentaddress());
	dto.setPaitentncount(Integer.parseInt(vo.getPaitentncount()));
	dto.setPaitentnumber(Long.parseLong(vo.getPaitentnumber()));
	dto.setPatientname(vo.getPatientname());
	String result = service.processingBill(dto);
	return result;
    }

}

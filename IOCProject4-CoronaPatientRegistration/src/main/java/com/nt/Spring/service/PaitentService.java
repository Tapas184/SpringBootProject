package com.nt.Spring.service;

import com.nt.Spring.bo.PaitentBO;
import com.nt.Spring.dao.IpaitentDao;
import com.nt.Spring.dto.PaitentDTO;

public class PaitentService implements IpatientService {
    public IpaitentDao dao;
    

    public PaitentService(IpaitentDao dao) {
	System.out.println("IpaitentDao :: 1- Param Constrictor");
	this.dao = dao;
    }//dao cunstructor


    @Override
    public String processingBill(PaitentDTO dto) throws Exception {
	float perDayAmountFrOnePerson= 350.0f;
	float totalAmount = dto.getPaitentncount()*dto.getDays()*perDayAmountFrOnePerson;
	float netAmount=0.0f;
	Integer discount=0;
	if(totalAmount>=100000.0f && totalAmount<=199999.0f) {
	    discount=10;
	    netAmount = (float) (totalAmount-(totalAmount*0.01));
	    System.out.println("Total amount :"+totalAmount);
	}else if(totalAmount>=200000.0f) {
	    discount=21;
	    netAmount =(float)(totalAmount-(totalAmount*0.21));
	    System.out.println("Total amount :"+totalAmount);
	}else
	    netAmount=totalAmount;
	System.out.println("Discount is :"+discount);
	PaitentBO bo =new PaitentBO();
	bo.setTotalbillamount(totalAmount);
	bo.setPatientname(dto.getPatientname());
	bo.setPaitentaddress(dto.getPaitentaddress());
	bo.setPaitentncount(dto.getPaitentncount());
	bo.setBillperday(perDayAmountFrOnePerson);
	bo.setNetbillamount(netAmount);
	bo.setPaitentnumber(dto.getPaitentnumber());
	int count = dao.insert(bo);
	
	return count==1?totalAmount>=100000.0f?"Sucessfull Bill generated Total Amount is ::"+totalAmount+" And after:"+discount+"% and Net BIll amount is"+netAmount:
	    "Sucessfull Bill generated Total Amount is ::"+totalAmount+" And your netBillAmount is"+netAmount:"Error in bill generate please try again";
    }

}

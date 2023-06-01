package com.nt.cricketbat;
import java.util.*;

import org.springframework.stereotype.Component;
@Component("bat")
public class CricketBat {

    public CricketBat() {
	System.out.println("CricketBat.CricketBat()::0-param Constructor");
    }
    public int run() {
	System.out.println("CricketBat.run()");
	return new Random().nextInt(200);
    }
    
    

}

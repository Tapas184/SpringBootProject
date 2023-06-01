package com.nt.cricketrs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import com.nt.cricketbat.CricketBat;
@Component("cktr")
public abstract class Crickter {
    private CricketBat bat;
    @Lookup
    public abstract CricketBat createCricketBat();
    public Crickter() {
	System.out.println("Crickter.Crickter()::0-param Constructor");
    }
    
public void bowling() {
    System.out.println("Crickter.bowling()");
}//
public void fielding() {
    System.out.println("Crickter.fielding()");
}
public void batting() {
    System.out.println("Crickter.batting()");
    CricketBat bat = createCricketBat();
    int run = bat.run();
    System.out.println("Run is "+run);
    
}
}

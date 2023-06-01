package com.nt.cricketrs;

import com.nt.cricketbat.CricketBat;

public abstract class Crickter {

    private CricketBat bat;
    
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

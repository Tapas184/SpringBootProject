package com.nt.component;

public final class BlueDart implements Courior {

    public BlueDart() {
	System.out.println("BlueDart::0-param Constructor");
    }
    public String deliver(int oid) {
	// TODO Auto-generated method stub
	return "Delivering "+oid+" Order id order product using BlueDart ";
    }

}

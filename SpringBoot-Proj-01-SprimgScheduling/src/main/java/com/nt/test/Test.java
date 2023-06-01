package com.nt.test;

import java.util.Date;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("component")

public class Test {

	@Scheduled(cron = "0 0 0 9W * *")
	public void sendReport() {
		System.out.println("send Report start "+new Date());
	}
}

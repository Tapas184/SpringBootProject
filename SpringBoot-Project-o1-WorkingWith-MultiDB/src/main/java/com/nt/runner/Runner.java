package com.nt.runner;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.model.offers.Offers;
import com.nt.model.product.Product;
import com.nt.model.repo.offers.OffersRepo;
import com.nt.model.repo.product.ProductRepo;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private OffersRepo offerRepo;
	@Autowired
	private ProductRepo productRepo;
	@Override
	public void run(String... args) throws Exception {
	
		productRepo.saveAll(Arrays.asList(new Product("Table",50,20000.0),
				                          new Product("Chair",20,10000.0),
				                          new Product("TV",10,500000.0)
				));
		System.out.println("====================product details saved in Oracle DB==================");
	
	offerRepo.saveAll(Arrays.asList(new Offers("BY-1-GET-1","B1G1",LocalDateTime.of(2023, 5, 10, 15, 10)),
			                        new Offers("BY-2-GET-1","B1G1",LocalDateTime.of(2023, 6, 10, 15, 10)),
			                        new Offers("BY-3-GET-2","B1G1",LocalDateTime.of(2023, 7, 10, 15, 10))
			));
	System.out.println("=======================Offers deatils saved in MySQL==========================");
	offerRepo.findAll().forEach(System.out::println);
	System.out.println("=======================All offers list printed====================");
	productRepo.findAll().forEach(System.out::println);
	System.out.println("========================All Product details printed================");
	}//

}

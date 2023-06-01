package com.nt;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.nt.customexception.TouristNotFoundException;
import com.nt.entity.Tourist;
import com.nt.service.ITouristService;
import com.nt.service.TouristServiceImpl;

@SpringBootTest
class SpringRestProj02MiniProjectApplicationTests {

	private ITouristService service;
	@BeforeAll
	void beforetest() {
		service = new TouristServiceImpl();
	}
	@Test
	void checkByID() throws TouristNotFoundException {
		Tourist t1 = service.getById(1005);
		assertNotNull(t1, "Tourist not found");
	}

}

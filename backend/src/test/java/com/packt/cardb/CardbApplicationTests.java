package com.packt.cardb;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.packt.cardb.web.CarController;

@SpringBootTest
class CardbApplicationTests {
	
	@Autowired
	private CarController carController;

	@Test
	@DisplayName("First example test case")
	void contextLoads() {
		assertThat(carController).isNotNull();
	}

}

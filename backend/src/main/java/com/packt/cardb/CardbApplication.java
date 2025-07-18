package com.packt.cardb;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.packt.cardb.domain.Car;
import com.packt.cardb.domain.CarRepository;
import com.packt.cardb.domain.Owner;
import com.packt.cardb.domain.OwnerRepository;
import com.packt.cardb.domain.User;
import com.packt.cardb.domain.UserRepository;

@SpringBootApplication
public class CardbApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(CardbApplication.class);

	@Autowired
	private CarRepository carRepo;

	@Autowired
	private OwnerRepository ownerRepo;

	@Autowired
	private UserRepository userRepo;

	public static void main(String[] args) {
		// A comment
		SpringApplication.run(CardbApplication.class, args);
		logger.info("Application started");
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner("John", "Johnson");
		Owner owner2 = new Owner("Mary", "Robinson");
		ownerRepo.saveAll(Arrays.asList(owner1, owner2));

		carRepo.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2021, 5900, owner1));
		carRepo.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2019, 2900, owner2));
		carRepo.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2020, 3900, owner2));

		for (Car car : carRepo.findAll()) {
			logger.info(car.getBrand() + " " + car.getModel());
		}

		userRepo.save(new User("user", "$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue", "USER"));
		userRepo.save(new User("admin", "$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "ADMIN"));
	}

}

package com.packt.cardb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.packt.cardb.domain.Car;
import com.packt.cardb.domain.CarRepository;

@RestController
public class CarController {
	
	@Autowired
	private CarRepository carRepo;

	@RequestMapping("/cars")
	public Iterable<Car> getCars() {
		return carRepo.findAll();
	}
}

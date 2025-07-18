package com.packt.cardb.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long> {
	
	List<Car> findByBrand(@Param("brand") String brand);
	
	List<Car> findByColor(@Param("color") String color);
	
	List<Car> findByCarYear(int carYear);
	
	List<Car> findByBrandAndModel(String brand, String mode);
	
	List<Car> findByBrandOrColor(String brand, String color);
	
	List<Car> findByBrandOrderByCarYearAsc(String brand);
	
//	@Query("select c from Car c where c.brand= ?1")
//	List<Car> findByBrand(String brand);
}

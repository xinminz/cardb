package com.packt.cardb;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.packt.cardb.domain.Owner;
import com.packt.cardb.domain.OwnerRepository;

@DataJpaTest
public class OwnerRepositoryTest {

	@Autowired
	private OwnerRepository repo;
	
	@Test
	void saveOwner() {
		repo.save(new Owner("Lucy", "Smith"));
		assertThat(repo.findByFirstName("Lucy").isPresent()).isTrue();
	}
	
	@Test
	void deleteOwners() {
		repo.save(new Owner("Lisa", "Morrison"));
		repo.deleteAll();
		assertThat(repo.count()).isEqualTo(0);
	}
}

package com.hackutd.fall2021.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hackutd.fall2021.demo.entities.User;

@Repository 

public interface ItemRepository extends CrudRepository<User, Long> {
	
}

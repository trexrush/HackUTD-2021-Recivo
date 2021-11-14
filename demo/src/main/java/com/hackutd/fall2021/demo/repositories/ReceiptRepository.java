package com.hackutd.fall2021.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hackutd.fall2021.demo.entities.Receipt;
import com.hackutd.fall2021.demo.entities.User;

import java.util.*;

@Repository 

public interface ReceiptRepository extends CrudRepository<Receipt, Long> {
	List<Receipt> findByUserAndDateLessThanEqualAndDateGreaterThanEqual(User user, Date after, Date before);
}
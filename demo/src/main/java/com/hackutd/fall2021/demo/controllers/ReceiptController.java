package com.hackutd.fall2021.demo.controllers;

import org.springframework.web.bind.annotation.*;

import com.hackutd.fall2021.demo.entities.*;
import com.hackutd.fall2021.demo.repositories.*;
import com.hackutd.fall2021.demo.resources.Response;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/receipt")

public class ReceiptController {
	@Autowired
	private UserRepository users;
	@Autowired
	private ReceiptRepository receipts;
	@Autowired
	private ItemRepository items;
	
	@PostMapping("/add/{id}")
	public void addReceipt(@RequestBody Receipt newReceipt, @PathVariable Long id) {
		User user = users.findById(id).get();
		if (user != null) {
			newReceipt.setUser(user);
			receipts.save(newReceipt);
			user.addReceipt(newReceipt);
			users.save(user);
			// CHECK
			for (Item it: newReceipt.getItems()) {
				it.setReceipt(newReceipt);
				items.save(it);
			}
		}
	}
	@GetMapping("/getall")
	public Response getReceipt(@RequestBody User user) {
		return new Response(HttpStatus.OK.toString(), "", users.findById(user.getUserId()).get().getReceipts());
	}
	@GetMapping("/bymonth/{month}/{year}")
	public Response getReceipt(@RequestBody User user, @PathVariable Integer month, @PathVariable Integer year) {
		User userData = users.findById(user.getUserId()).get();
		if (userData != null) {
			Calendar afterCal = Calendar.getInstance();
			afterCal.clear();
			afterCal.set(Calendar.MONTH, month - 1);
			afterCal.set(Calendar.YEAR, year);
			afterCal.set(Calendar.DATE, 1);
			Calendar beforeCal = Calendar.getInstance();
			beforeCal.clear();
			beforeCal.set(Calendar.MONTH, month - 1);
			beforeCal.set(Calendar.YEAR, year);
			beforeCal.set(Calendar.DATE, 31);
			Date afterDate = afterCal.getTime();
			Date beforeDate = beforeCal.getTime();
			return new Response(HttpStatus.OK.toString(), "", receipts.findByUserAndDateLessThanEqualAndDateGreaterThanEqual(userData, beforeDate, afterDate));
		}
		return new Response(HttpStatus.OK.toString(), "User not found", "");
	}
}
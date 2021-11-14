package com.hackutd.fall2021.demo.controllers;

import org.springframework.web.bind.annotation.*;

import com.hackutd.fall2021.demo.entities.*;
import com.hackutd.fall2021.demo.repositories.*;
import com.hackutd.fall2021.demo.resources.Response;

import java.util.Date;
import java.util.Map;

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
	public Response addReceipt(@RequestBody Receipt newReceipt, @PathVariable Long id) {
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
			
			return new Response(HttpStatus.OK.toString(), "Saved receipt", "");
		}
		return new Response(HttpStatus.OK.toString(), "User not found", "");
	}
	@GetMapping("/getall")
	public Response getReceipt(@RequestBody User user) {
		return new Response(HttpStatus.OK.toString(), "", users.findById(user.getUserId()).get().getReceipts());
	}
	@GetMapping("/bymonth/{month}/{year}")
	public Response getReceipt(@RequestBody User user, @PathVariable Integer month, @PathVariable Integer year) {
		User userData = users.findById(user.getUserId()).get();
		if (userData != null) {
			Date beforeDate = new Date(year, month, 1);
			Date afterDate = new Date(year, month, 31);
			receipts.findByUserAndDateGreaterThanAndDateLessThan(userData, afterDate, beforeDate);
		}
		return new Response(HttpStatus.OK.toString(), "User not found", "");
	}
}
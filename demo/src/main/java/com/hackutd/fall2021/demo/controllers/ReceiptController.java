package com.hackutd.fall2021.demo.controllers;

import org.springframework.web.bind.annotation.*;

import com.hackutd.fall2021.demo.entities.*;
import com.hackutd.fall2021.demo.repositories.*;
import com.hackutd.fall2021.demo.resources.Response;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping ("/api/receipt")

public class ReceiptController {
	@Autowired
	private UserRepository users;
	@Autowired
	private ReceiptRepository receipts;
	
	@PostMapping ("/add/{id}")
	public Response addReceipt(@RequestBody Receipt newReceipt, @PathVariable Long id) {
		User user = users.findById(id).get();
		if (user != null) {
			newReceipt.setUser(user);
			receipts.save(newReceipt);
			user.addReceipt(newReceipt);
			users.save(user);
			
			return new Response(HttpStatus.OK.toString(), "Saved receipt", "");
		}
		return new Response(HttpStatus.OK.toString(), "User not found", "");
	}
	@PostMapping("/get")
	public Response getReceipt(@RequestBody Map<String, String> login) {
		
	}
}
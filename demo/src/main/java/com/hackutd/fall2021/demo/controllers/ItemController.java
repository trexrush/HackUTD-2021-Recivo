package com.hackutd.fall2021.demo.controllers;

import org.springframework.web.bind.annotation.*;

import com.hackutd.fall2021.demo.entities.*;
import com.hackutd.fall2021.demo.repositories.*;
import com.hackutd.fall2021.demo.resources.Response;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/item")

public class ItemController {
	
	@Autowired
	private UserRepository users;
	@Autowired
	private ItemRepository items;
	
	@PostMapping("/taxable/{id}")
	public void addItem(@RequestBody Item itemMod, @PathVariable Long userId) {
		if (users.findById(userId).get() != null) {
			Item item = items.findById(itemMod.getItemId()).get();
			item.setTaxable(itemMod.isTaxable());
			items.save(item);
		}
	}
	/*
	@PostMapping("/login")
	public Response getItem(@RequestBody Map<String, String> login) {
		User user = repository.findByUsernameAndPassword(login.get("username"), login.get("password"));
		return new Response(HttpStatus.OK.toString(), user == null ? "User not found" : "User found", user);
	}
	*/
}
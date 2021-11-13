package com.hackutd.fall2021.demo.controllers;

import org.springframework.web.bind.annotation.*;

import com.hackutd.fall2021.demo.entities.User;
import com.hackutd.fall2021.demo.repositories.ItemRepository;
import com.hackutd.fall2021.demo.resources.Response;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping ("/api/item")

public class ItemController {
	@Autowired
	private ItemRepository repository;
	
	@PostMapping ("/new")
	public Response createUser(@RequestBody User newUser) {
		if (repository.findByUsername(newUser.getUsername()) != null) {
			return new Response(HttpStatus.OK.toString(), "", repository.save(newUser));
		}
		return new Response(HttpStatus.OK.toString(), "User already exists", "");
	}
	@PostMapping("/login")
	public Response login(@RequestBody Map<String, String> login) {
		User user = repository.findByUsernameAndPassword(login.get("username"), login.get("password"));
		return new Response(HttpStatus.OK.toString(), user == null ? "User not found" : "User found", user);
	}
}
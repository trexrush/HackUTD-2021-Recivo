package com.hackutd.fall2021.demo.controllers;

import org.springframework.web.bind.annotation.*;

import com.hackutd.fall2021.demo.entities.User;
import com.hackutd.fall2021.demo.repositories.UserRepository;
import com.hackutd.fall2021.demo.resources.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping ("/api/user")

public class UserController {
	@Autowired
	private UserRepository repository;
	
	@PostMapping ("/new")
	public Response createUser(@RequestBody User newUser) {
		return new Response(HttpStatus.OK.toString(), "", repository.save(newUser));
	}
}

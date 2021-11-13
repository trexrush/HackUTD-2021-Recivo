package com.hackutd.fall2021.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hackutd.fall2021.demo.entities.*;

@SpringBootApplication
public class ExpensesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpensesApplication.class, args);
	}
}
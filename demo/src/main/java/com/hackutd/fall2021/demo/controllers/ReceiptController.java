package com.hackutd.fall2021.demo.controllers;

import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
			newReceipt.getDate().setDate(newReceipt.getDate().getDate() + 1);
			newReceipt.setUser(user);
			receipts.save(newReceipt);
			user.addReceipt(newReceipt);
			users.save(user);
			// CHECK
			for (Item it: newReceipt.getItems()) {
				newReceipt.setTotal(newReceipt.getTotal() + it.getPrice());
				it.setReceipt(newReceipt);
				items.save(it);
			}
			user.setTotal(user.getTotal() + newReceipt.getTotal());
			receipts.save(newReceipt);
			users.save(user);
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
			System.out.println(afterDate);
			System.out.println(beforeDate);
			return new Response(HttpStatus.OK.toString(), "", receipts.findByUserAndDateLessThanEqualAndDateGreaterThanEqual(userData, beforeDate, afterDate));
		}
		return new Response(HttpStatus.OK.toString(), "User not found", "");
	}
	@GetMapping("/byyear/{year}")
	public Response getReceipt(@RequestBody User user, @PathVariable Integer year) {
		User userData = users.findById(user.getUserId()).get();
		if (userData != null) {
			Calendar afterCal = Calendar.getInstance();
			afterCal.clear();
			afterCal.set(Calendar.MONTH, Calendar.JANUARY);
			afterCal.set(Calendar.YEAR, year);
			afterCal.set(Calendar.DATE, 1);
			Calendar beforeCal = Calendar.getInstance();
			beforeCal.clear();
			beforeCal.set(Calendar.MONTH, Calendar.DECEMBER);
			beforeCal.set(Calendar.YEAR, year);
			beforeCal.set(Calendar.DATE, 31);
			Date afterDate = afterCal.getTime();
			Date beforeDate = beforeCal.getTime();
			
			Map<String, Integer> totalsByMonth = new HashMap<>();
			for (int i = 0; i < 12; i++) {
				switch (i) {
					case 1: totalsByMonth.put("january", 0); break;
					case 2: totalsByMonth.put("february", 0); break;
					case 3: totalsByMonth.put("march", 0); break;
					case 4: totalsByMonth.put("april", 0); break;
					case 5: totalsByMonth.put("may", 0); break;
					case 6: totalsByMonth.put("june", 0); break;
					case 7: totalsByMonth.put("july", 0); break;
					case 8: totalsByMonth.put("august", 0); break;
					case 9: totalsByMonth.put("september", 0); break;
					case 10: totalsByMonth.put("october", 0); break;
					case 11: totalsByMonth.put("november", 0); break;
					case 12: totalsByMonth.put("december", 0); break;	
				}
			}
			for (Receipt r: receipts.findByUserAndDateLessThanEqualAndDateGreaterThanEqual(userData, beforeDate, afterDate)) {
				switch(r.getDate().getMonth()) {
					case Calendar.JANUARY: totalsByMonth.put("january", totalsByMonth.get("january") + r.getTotal()); break;
					case Calendar.FEBRUARY: totalsByMonth.put("february", totalsByMonth.get("february") + r.getTotal()); break;
					case Calendar.MARCH: totalsByMonth.put("march", totalsByMonth.get("march") + r.getTotal()); break;
					case Calendar.APRIL: totalsByMonth.put("april", totalsByMonth.get("april") + r.getTotal()); break;
					case Calendar.MAY: totalsByMonth.put("may", totalsByMonth.get("may") + r.getTotal()); break;
					case Calendar.JUNE: totalsByMonth.put("june", totalsByMonth.get("june") + r.getTotal()); break;
					case Calendar.JULY: totalsByMonth.put("july", totalsByMonth.get("july") + r.getTotal()); break;
					case Calendar.AUGUST: totalsByMonth.put("august", totalsByMonth.get("august") + r.getTotal()); break;
					case Calendar.SEPTEMBER: totalsByMonth.put("september", totalsByMonth.get("september") + r.getTotal()); break;
					case Calendar.OCTOBER: totalsByMonth.put("october", totalsByMonth.get("october") + r.getTotal()); break;
					case Calendar.NOVEMBER: totalsByMonth.put("november", totalsByMonth.get("november") + r.getTotal()); break;
					case Calendar.DECEMBER: totalsByMonth.put("december", totalsByMonth.get("december") + r.getTotal()); break;
				}
			}
			return new Response(HttpStatus.OK.toString(), "", totalsByMonth);
		}
		return new Response(HttpStatus.OK.toString(), "User not found", "");
	}
}
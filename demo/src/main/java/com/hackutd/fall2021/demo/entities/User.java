package com.hackutd.fall2021.demo.entities;

import javax.persistence.*;
import java.util.*;

import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class User {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private long user_id;
	private String username;
	private String email;
	private String password;
	private int total;
	
	@OneToMany(mappedBy="user")
	private List<Receipt> receipts;
	
	public void addReceipt(Receipt receipt) {
		receipts.add(receipt);
	}
	
	/*
	public String getUsername() {
		return username;
	}
	*/
}
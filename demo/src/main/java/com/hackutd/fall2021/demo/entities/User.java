package com.hackutd.fall2021.demo.entities;

import javax.persistence.*;
import java.util.*;

import lombok.Data;

@Data
@Entity

public class User {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private long user_id;
	private String username;
	private String email;
	private String pass_word;
	private int total;
	
	@OneToMany(mappedBy="user")
	private List<Receipt> receipts;
}
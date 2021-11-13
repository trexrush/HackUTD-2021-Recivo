package com.hackutd.fall2021.demo.entities;

import javax.persistence.*;
import java.util.*;

import lombok.Data;

@Data
@Entity

public class User {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private long id;
	private String user;
	private String email;
	
	@OneToMany(mappedBy="user")
	private List<Receipt> receipts;
}

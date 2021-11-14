package com.hackutd.fall2021.demo.entities;
import javax.persistence.*;

import java.util.*;

import lombok.Data;

@Data
@Entity

public class Receipt {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private long receiptId;
	private int total;
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User user;
	
	@OneToMany(mappedBy="receipt")
	private List<Item> items;
}
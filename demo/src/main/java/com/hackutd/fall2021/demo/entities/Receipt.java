package com.hackutd.fall2021.demo.entities;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;

import lombok.Data;

@Data
@Entity

public class Receipt {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private long receiptId;
	private int total;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy="receipt")
	private List<Item> items;
}
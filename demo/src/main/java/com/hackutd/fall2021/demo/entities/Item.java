package com.hackutd.fall2021.demo.entities;
import javax.persistence.*;

import java.util.*;

import lombok.Data;

@Data
@Entity

public class Item {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private long itemId;
	private int price;
	private boolean isTaxable;
	private String name;
	
	@ManyToOne
	@JoinColumn(name="receipt_id", nullable=false)
	private Receipt receipt;
}
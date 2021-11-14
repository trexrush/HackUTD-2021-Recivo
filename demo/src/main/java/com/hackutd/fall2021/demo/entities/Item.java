package com.hackutd.fall2021.demo.entities;
import javax.persistence.*;

import java.util.*;

import lombok.Data;

@Data
@Entity

public class Item {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private long itemId;
	private int price;
	private boolean isTaxable;
	
	@ManyToOne
	@JoinColumn(name="receipt_id", nullable=false)
	private Receipt receipt;
}
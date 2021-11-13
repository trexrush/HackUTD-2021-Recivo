package com.hackutd.fall2021.demo.entities;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity

public class Receipt {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="id", nullable=false)
	private User user;
}
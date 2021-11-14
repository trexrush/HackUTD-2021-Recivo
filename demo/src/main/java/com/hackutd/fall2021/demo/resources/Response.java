package com.hackutd.fall2021.demo.resources;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Response<T> {
	private String status;
	private String message;
	private T data;
}

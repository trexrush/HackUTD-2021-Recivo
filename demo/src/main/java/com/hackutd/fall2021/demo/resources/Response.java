package com.hackutd.fall2021.demo.resources;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Response<T> {
	private String status;
	private String message;
	private T data;
	
	public Response(String stat, String mesg, T data) {
		status = stat;
		message = mesg;
		this.data = data;
	}
}

package com.nt.entity;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Error {

	private LocalDateTime time;
	private String msg;
	private HttpStatus status;
}//error class

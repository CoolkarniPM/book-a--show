package com.ticketBooking.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/user")

public class UserController {

	@GetMapping("/")
	public String getMethodName(@RequestParam String param) {
		return new String("This is User controller");
	}
	
	
}

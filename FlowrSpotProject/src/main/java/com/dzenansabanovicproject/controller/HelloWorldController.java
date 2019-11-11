package com.dzenansabanovicproject.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloWorldController {

	@RequestMapping({ "/hello" })
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public String firstPage() {
		return "Hello World";
	}



}
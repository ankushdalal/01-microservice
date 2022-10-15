package com.microservices.udemy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.udemy.bean.HelloWorldBean;

@RestController
public class HelloWorldController {

	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	public String helloWord() {
		return "Hello World";
	}

	@GetMapping(path = "helloworld")
	public String hello_Word() {
		return "Hello World";
	}

	@GetMapping(path = "helloworld/{name}")
	public HelloWorldBean hellWordBean(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World , %s", name));
	}
}

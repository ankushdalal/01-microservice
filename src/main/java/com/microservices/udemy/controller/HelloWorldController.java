package com.microservices.udemy.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.udemy.user.HelloWorldBean;

@RestController
public class HelloWorldController {

	private MessageSource messageSource;

	public HelloWorldController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

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

	@GetMapping(path = "/helloworld-locale")
	public String helloWordLocale() {

		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Good Morning", locale);
	}
}

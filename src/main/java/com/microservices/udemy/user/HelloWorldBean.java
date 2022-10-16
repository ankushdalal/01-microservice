package com.microservices.udemy.user;

public class HelloWorldBean {

	private String name;

	public HelloWorldBean(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [name=" + name + "]";
	}

}

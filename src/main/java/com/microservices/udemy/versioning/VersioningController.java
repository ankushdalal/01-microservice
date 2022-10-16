package com.microservices.udemy.versioning;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

	// localhost:8080/v1/person
	@GetMapping(path = "/v1/person")
	public PersonV1 getPersonV1() {
		return new PersonV1("Ankush Dalal");
	}

	// localhost:8080/v2/person
	@GetMapping(path = "/v2/person")
	public PersonV2 getPersonV2() {
		return new PersonV2(new Name("Ankush", "Dalal"));
	}

	/*
	 * Query Params
	 */

	// localhost:8080/v2/person?vesrion=1
	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 getPersonVersion1() {
		return new PersonV1("Ankush Dalal");
	}

	// localhost:8080/v2/person?vesrion=2
	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 getPersonVersion2() {
		return new PersonV2(new Name("Ankush", "Dalal"));
	}

	/*
	 * Header
	 */

	// localhost:8080/v2/person
	@GetMapping(path = "/person", headers = "X-API-VERSION=1")
	public PersonV1 getPersonHeaderVersion1() {
		PersonV1 personV1 = new PersonV1("Ankush Dalal");
		System.out.println(personV1);
		return personV1;
	}

	// localhost:8080/v2/person
	@GetMapping(path = "/person", headers = "X-API-VERSION=2")
	public PersonV2 getPersonHeaVersion2() {
		PersonV2 personV2 = new PersonV2(new Name("Ankush", "Dalal"));
		System.out.println(personV2);
		return personV2;
	}
	
	/*
	 * Accept Header
	 */

	// localhost:8080/v2/person
	@GetMapping(path = "/person", produces = "application/vnd.company.app-v1+json")
	public PersonV1 getPersonAcceptHeaderVersion1() {
		PersonV1 personV1 = new PersonV1("Ankush Dalal");
		System.out.println(personV1);
		return personV1;
	}

	// localhost:8080/v2/person
	@GetMapping(path = "/person", produces = "application/vnd.company.app-v2+json")
	public PersonV2 getPersonAcceptHeaderVersion2() {
		PersonV2 personV2 = new PersonV2(new Name("Ankush", "Dalal"));
		System.out.println(personV2);
		return personV2;
	}
}

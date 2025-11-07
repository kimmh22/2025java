package com.study.spring.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mycontroller {

	
	@GetMapping("/hello/world")
	public String helloWorld() {
		return "hello Spring";
	};
	
	@PostMapping("/hello/world")
	public String postHelloWorld() {
		return "[post] hello Spring";
	}
	
	@PutMapping("/hello/world")
	public String putHelloWorld() {
		return "[put] hello Spring";
	}
	
	@DeleteMapping("/hello/world")
	public String deleteHelloWorld() {
		return "[put] hello Spring";
	}
	
	
	//localhost:8080/test/param?name=&age=
	@GetMapping("/test/param")
	public String requsetParam(
			@RequestParam("name") String name,
			@RequestParam("age") Integer age
			) {
		return "hello, requst : "+name+" ,"+age;
	}
	
	
	//localhost:8080/test/path/홍길동/20
	@GetMapping("/test/path/{name}/{age}")
	public String requestPath(
			@PathVariable("name") String name,
			@PathVariable("age") Integer age
			) {
		
		return "hello, requst : "+name+" ,"+age;
		
	}
	
	@PostMapping("test/body")
	public String requestBody(
			@RequestBody TestDto request
			) {
		
		
		return "hello, requst : "+request.name+" ,"+request.age+" ,"+request.addr+" ,"+request.hobby;
	}
	
	
}

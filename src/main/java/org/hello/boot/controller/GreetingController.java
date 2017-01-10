package org.hello.boot.controller;


import java.util.concurrent.atomic.AtomicLong;

import org.hello.boot.entity.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping("/hello")
public class GreetingController {
	private static final String template = "Hello, %s";
	private final AtomicLong counter = new AtomicLong();
	@RequestMapping(value="/greeting", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="getGreeting", nickname="getGreeting")
	@ApiImplicitParams({@ApiImplicitParam(name="name", value="User name", required=false, dataType="String", 
		paramType="query", defaultValue="Spring Boot, Swagger2 & Docker")})
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Success", response = Greeting.class),
			@ApiResponse(code=401, message="Unauthorized"),
			@ApiResponse(code=403, message="Forbidden"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Failed")})
	public Greeting greeting(@RequestParam(value="name", defaultValue="Spring Boot, Swagger2 & Docker")String name){
		return new Greeting(counter.incrementAndGet(),
					String.format(template, name));
	}
}

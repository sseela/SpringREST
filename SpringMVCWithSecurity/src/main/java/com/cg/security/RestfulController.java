package com.cg.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class RestfulController {
	
	@GetMapping(value="/hello")
	public @ResponseBody String sayHello() {
		return "hello Sandeep";
	}
}

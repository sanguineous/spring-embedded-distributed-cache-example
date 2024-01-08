package com.spikes.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@Autowired
	GreetingService greetingService;

	@GetMapping("/cachedGreeting")
	public String cachedGreeting(@RequestParam(value = "delay", defaultValue = "0") Integer delay, 
							@RequestParam(value = "name", defaultValue = "World") String name) {
		return greetingService.cachedGgreeting(delay, name);
	}
}
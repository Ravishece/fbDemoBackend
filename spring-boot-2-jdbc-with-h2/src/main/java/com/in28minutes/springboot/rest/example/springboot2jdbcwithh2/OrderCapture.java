package com.in28minutes.springboot.rest.example.springboot2jdbcwithh2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.in28minutes.springboot.rest.example.springboot2jdbcwithh2.OrderCapture;

@RestController
public class OrderCapture {
	@Autowired
	OrderCaptureJdbcRepository repository;
	
	@RequestMapping("/")
	String home() {
		return "welcome spring boot application";
	}
	
	@PostMapping("/orderCapture/{orderId}/{productId}/{friendId}")
	public String captureOrder(
			@PathVariable String orderId,@PathVariable String productId,@PathVariable String friendId) {
		if(null != repository)
			repository.insert(orderId, productId, friendId);
		return "Voting successfully captured for order ID:"+orderId;
	}


}

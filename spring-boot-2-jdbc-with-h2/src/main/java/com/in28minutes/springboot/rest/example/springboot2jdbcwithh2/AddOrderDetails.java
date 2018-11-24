package com.in28minutes.springboot.rest.example.springboot2jdbcwithh2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddOrderDetails {
	@Autowired
	OrderCaptureJdbcRepository repository;
	
	@PostMapping("/orderDetails/{orderId}/{orderQualifyVoteCount}")
	public String addOrderDetails(
			@PathVariable String orderId,@PathVariable String orderQualifyVoteCount) {
		if(null != repository)
			repository.insertOrderDetails(orderId, orderQualifyVoteCount);
		return "Order details added successfully for order ID:"+orderId;
	}
}

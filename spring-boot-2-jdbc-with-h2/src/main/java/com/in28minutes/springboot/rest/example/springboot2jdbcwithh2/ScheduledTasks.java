package com.in28minutes.springboot.rest.example.springboot2jdbcwithh2;

import org.slf4j.LoggerFactory;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
	@Autowired
	OrderCaptureJdbcRepository repository;

    @Scheduled(fixedRate = 5000)
    public void orderCheckOut() {
    	log.info("Scheduler started ---------------");
    	List<String> orders = repository.ordersQualifyForCheckout();
    	for(String orderId:orders) {
    		repository.updateOrderCheckoutStatus(orderId, 1);
    		log.info("Order checkout process starts for orderID:"+orderId);
    		try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    		log.info("Order checkout ends for orderID:"+orderId);
    		repository.updateOrderCheckoutStatus(orderId, 2);
    	}
    	log.info("Scheduler ends ---------------");
        
        
    }
}

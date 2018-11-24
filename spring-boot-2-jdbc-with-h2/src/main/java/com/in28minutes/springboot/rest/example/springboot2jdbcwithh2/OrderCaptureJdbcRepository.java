package com.in28minutes.springboot.rest.example.springboot2jdbcwithh2;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class OrderCaptureJdbcRepository {
	private static final Logger log = LoggerFactory.getLogger(OrderCaptureJdbcRepository.class);

	@Autowired
	JdbcTemplate jdbcConnection;

	public void insert(String orderId,String productId,String friendId) {
		int count=0;
		 jdbcConnection.update("insert into friendsvote (orderId, productId, friendId) " + "values(?, ?, ?)",
				new Object[] { orderId, productId, friendId });
		 count = getVoteCount(orderId);
		 count++;
		 jdbcConnection.update("update orderdetails set voteCount=? where orderid=?", new Object[] {count,orderId});
	}
	
	public int getVoteCount(String orderId) {
		final int[] count = {0};
		jdbcConnection.query("select voteCount from orderdetails where orderId=?", new Object[] {orderId},
				  (rs, rowNum) -> count[0]= rs.getInt("votecount"));
		 return count[0];
	}
	
	public int getQualifyCount(String orderId) {
		final int[] count = {0};
		jdbcConnection.query("select voteQualifyCount from orderdetails where orderId=?", new Object[] {orderId},
				  (rs, rowNum) -> count[0]= rs.getInt("votecount"));
		 return count[0];
	}
	
	public List<String> ordersQualifyForCheckout() {
		List<String> orders = new ArrayList<String>();
		jdbcConnection.query("select orderid from orderdetails where votecount > voteQualifyCount and checkoutstatus <2",
				  (rs, rowNum) -> orders.add(rs.getString("orderid")));
		return orders;
	}
	
	public int insertOrderDetails(String orderId,String orderQualifyVoteCount) {
		return jdbcConnection.update("insert into orderdetails (orderId, voteQualifyCount) " + "values(?, ?)",
				new Object[] { orderId, Integer.parseInt(orderQualifyVoteCount)});
	}

	public void updateOrderCheckoutStatus(String orderId, int status) {
		jdbcConnection.update("update orderdetails set checkoutstatus=? where orderid=?", new Object[] {status,orderId});
	}
	
}


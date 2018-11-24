package com.in28minutes.springboot.rest.example.springboot2jdbcwithh2;


public class FriendsVote {

	private String orderId;
	private String productId;
	private String friendId;
	
	public FriendsVote() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FriendsVote(Long id, String orderId, String productId, String friendId) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.friendId = friendId;
	}

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getFriendId() {
		return friendId;
	}
	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "FriendsVote [orderId=" + orderId + ", productId=" + productId + ", friendId=" + friendId
				+ "]";
	}
	
	
}

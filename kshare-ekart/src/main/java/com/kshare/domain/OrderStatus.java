package com.kshare.domain;

public enum OrderStatus {
	ACCEPTED("Accepted"), SHIPPED("Shipped"), DELIVERED("Delivered"), COMPLETED("Completed"), PENDING("Pending");

	private String status;

	private OrderStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

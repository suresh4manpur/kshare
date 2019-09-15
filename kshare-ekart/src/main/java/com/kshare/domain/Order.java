package com.kshare.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class Order implements Serializable{


	private static final long serialVersionUID = 6373335340788496171L;
	
	private int orderId;
	private List<Item> items;
	private BigDecimal totalPrice;
	private int accountId;
	private OrderStatus status;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Order(List<Item> items, BigDecimal totalPrice, int accountId, OrderStatus status) {
		super();
		this.items = items;
		this.totalPrice = totalPrice;
		this.accountId = accountId;
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + orderId;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((totalPrice == null) ? 0 : totalPrice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (accountId != other.accountId)
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (orderId != other.orderId)
			return false;
		if (status != other.status)
			return false;
		if (totalPrice == null) {
			if (other.totalPrice != null)
				return false;
		} else if (!totalPrice.equals(other.totalPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", items=" + items + ", totalPrice=" + totalPrice + ", accountId="
				+ accountId + ", status=" + status + "]";
	}

}

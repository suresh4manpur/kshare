package com.kshare.batch.upload;

public class CustomerResponse {
	private int records;

	public CustomerResponse(int records) {
		super();
		this.records = records;
	}

	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
	}

}

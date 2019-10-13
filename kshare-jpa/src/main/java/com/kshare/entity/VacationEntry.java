package com.kshare.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Suresh
 *
 */
@Embeddable
public class VacationEntry {
	
	@Temporal(TemporalType.DATE)
	private Calendar startDate;
	
	@Column(name="DAYS")
	private int daysTaken;
	
	
	public VacationEntry() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VacationEntry(Calendar startDate, int daysTaken) {
		super();
		this.startDate = startDate;
		this.daysTaken = daysTaken;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public int getDaysTaken() {
		return daysTaken;
	}

	public void setDaysTaken(int daysTaken) {
		this.daysTaken = daysTaken;
	}

	@Override
	public String toString() {
		return "VacationEntry [startDate=" + startDate.toString() + ", daysTaken=" + daysTaken + "]";
	}
	
	
}

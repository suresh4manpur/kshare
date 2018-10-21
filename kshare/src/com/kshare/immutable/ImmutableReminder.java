package com.kshare.immutable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class ImmutableReminder{
    private final Date remindingDate;
    private final List<String> list;
  
    public ImmutableReminder (Date remindingDate, List<String> list) {
        if(remindingDate.getTime() < System.currentTimeMillis()){
            throw new IllegalArgumentException("Can not set reminder" +
                        " for past time: " + remindingDate);
        }
        this.remindingDate = new Date(remindingDate.getTime());
        this.list = new ArrayList<>(list);
    }
  
    public Date getRemindingDate() {
        return (Date) remindingDate.clone();
    }
    public List<String>  getList(){
    	synchronized (ImmutableReminder.class) {
			System.out.println("In syn block..");
		}
    	return new ArrayList<>(list);
    }
}



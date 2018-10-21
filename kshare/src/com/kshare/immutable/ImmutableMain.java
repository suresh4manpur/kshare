package com.kshare.immutable;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ImmutableMain {
public static void main(String[] args) {
	Date dt = new Date();
	List<String> list = Arrays.asList("A","B","C");
	final ImmutableReminder ir = new ImmutableReminder(dt,list);
	
	new Thread(){
		public void run() {
			System.out.println(ir.getRemindingDate().getDate());
		};
	}.start();
	new Thread(){
		ImmutableReminder localDt = null;
		public void run() {
			List<String> list = null;
			System.out.println(ir.getRemindingDate().getDate());
			list = ir.getList();
			list.add("D");
			if(ir.getRemindingDate().before(new Date())){
				localDt = new ImmutableReminder(new Date(),list);
			}else{
				System.out.println("ir.getRemindingDate().after(new Date) : "+false );
			}
			//performsomeOperationOnLocalDte(localDt);
		};
	}.start();
	
	System.out.println("Im doing some operation on date"+dt.getDate());
}
}

package com.kshare.thread;

import java.util.concurrent.ConcurrentHashMap;

public class SahredNumberIncrementorCustomized {
public static void main(String[] args) {

	IntSubjectC sub = new IntSubjectC();
	SharedNumberIncrementorThread1 t1= new  SharedNumberIncrementorThread1(sub,"A");
	SharedNumberIncrementorThread1 t2= new  SharedNumberIncrementorThread1(sub, "B");

	t1.start();
	t2.start();
}
}

class SharedNumberIncrementorThread1 extends Thread {
	private static IntSubjectC sub = null;
	private String name;
	//private Object lock = new Object();

	public SharedNumberIncrementorThread1(IntSubjectC sub,String name) {
		super(name);
		this.sub = sub;
	}
	@Override
	public void  run() {
		for(int i = 0 ; i < 10 ; i++){
			sub.increment();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
class IntSubjectC{
	private int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	public synchronized void increment(){
		size++;
		System.out.println(Thread.currentThread().getName()+" -->"+size);
	}
	
}



package com.kshare.thread;

public class SahredNumberIncrementorCustomized {
public static void main(String[] args) {
	System.out.println("I am running in main thread! - 3");
	IntSubjectC sub = new IntSubjectC();
	SharedNumberIncrementorThread1 t1= new  SharedNumberIncrementorThread1(sub,"A");
	SharedNumberIncrementorThread1 t2= new  SharedNumberIncrementorThread1(sub, "B");

	t1.start();
	t2.start();
	try {
		t1.join();
		t2.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(	"thread goup details : "+Thread.currentThread().getThreadGroup().getName());
	System.out.println("I am running in main thread after complete of all threads.");
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
		for(int i = 0 ; i < 5 ; i++){
			sub.increment();
			System.out.println(	"thread goup details in internal thread : "+Thread.currentThread().getThreadGroup().getName());
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



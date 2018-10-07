package com.kshare.thread;

public class SahredNumberIncrementor {
public static void main(String[] args) {
	//Integer val = new Integer(0); //shared Object
	IntSubject sub = new IntSubject();
	SharedNumberIncrementorThread t1= new  SharedNumberIncrementorThread(sub,"A");
	SharedNumberIncrementorThread t2= new  SharedNumberIncrementorThread(sub, "B");
	SharedNumberIncrementorThread t3= new  SharedNumberIncrementorThread(sub, "B");
/*	SharedNumberIncrementorThread t1= new  SharedNumberIncrementorThread(val);
	SharedNumberIncrementorThread t1= new  SharedNumberIncrementorThread(val);
*/
	t1.start();
	t2.start();
	t3.start();
}
}

class SharedNumberIncrementorThread extends Thread {
	private IntSubject sub = null;
	private String name;
	//private Object lock = new Object();

	public SharedNumberIncrementorThread(IntSubject sub,String name) {
		super(name);
		this.sub = sub;
	}
	@Override
	public synchronized void  run() {
		for(int i = 0 ; i < 5 ; i++){
			synchronized (sub) {
				sub.size++;
				System.out.println(" Thread "+Thread.currentThread().getName()+" is increamented to "+sub.size);

			}
/*			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
	}
}
class IntSubject{
	int size;
}

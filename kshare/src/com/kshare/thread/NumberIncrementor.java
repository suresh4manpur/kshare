package com.kshare.thread;

public class NumberIncrementor {
public static void main(String[] args) {
	Integer a = new Integer(0);
	NumberIncrementorThread t1 = new NumberIncrementorThread(a);
	NumberIncrementorThread t2 = new NumberIncrementorThread(a);
/*	NumberIncrementorThread t3 = new NumberIncrementorThread(a);
*/	t1.start();
	t2.start();
/*	t3.start();
*/}
}

class NumberIncrementorThread extends Thread{
	Integer count = 0;
	

	public NumberIncrementorThread(Integer count) {
		super();
		this.count = count;
	}

	@Override
	public synchronized void run() {
		for(int i = 0 ; i < 5 ; i++){
			count++;
			System.out.println(" Thread "+Thread.currentThread().getName()+" is increamented to "+count);
/*			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
	}
}



package com.kshare.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				/*RecursiveCallClass rc = new RecursiveCallClass();
				rc.outer();*/
				Widget wd = new LoggingWidget();
				wd.doSomething();
			}
		}.start();

	}

}

class RecursiveCallClass {
	Lock lock = new MyLock();

	public synchronized void outer() { // take lock on this
		//lock.lock();
		System.out.println("inside outer");
		 inner();
		//
		System.out.println("abc");
	}

	public synchronized void inner() { // take lock on this
		System.out.println("inside inner");
		//lock.unlock();
	}
}

class Widget {
	public synchronized void doSomething() {
		System.out.println(toString() +"calling from Widget..");
	}
}

class LoggingWidget extends Widget {
	public synchronized void doSomething() {
		System.out.println(toString() + ": calling doSomething");
		super.doSomething();
	}
}
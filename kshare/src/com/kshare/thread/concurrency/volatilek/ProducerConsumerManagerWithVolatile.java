package com.kshare.thread.concurrency.volatilek;

public class ProducerConsumerManagerWithVolatile {
	public static void main(String[] args) {
		SharedObject sharedObj = new SharedObject();
		Thread producer = new Thread(new Producer(sharedObj), "Producer");
		Thread consumer = new Thread(new Consumer(sharedObj), "Consumer");
		producer.start();
		consumer.start();
	}
}

class SharedObject {
	volatile int value = 0;
}

class Producer implements Runnable {
	SharedObject sharedObj;

	public Producer(SharedObject sharedObj) {
		this.sharedObj = sharedObj;
	}

	@Override
	public void run() {
		for (int i = 1; i < 10; i++) {
			while (sharedObj.value != 0) {
				//busy waiting and doing nothing. wasting CPU time. This is not preferable.
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + " --> " + i);
			sharedObj.value = i;
		}
	}
}

class Consumer implements Runnable {
	SharedObject sharedObj;

	public Consumer(SharedObject sharedObj) {
		this.sharedObj = sharedObj;
	}

	@Override
	public void run() {
		for (int i = 1; i < 10; i++) {
			while (sharedObj.value == 0) {

			}
			System.out.println(Thread.currentThread().getName() + " consuming " + sharedObj.value);
			sharedObj.value = 0;
		}
	}
}
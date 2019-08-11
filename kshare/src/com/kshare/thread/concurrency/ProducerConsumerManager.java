 package com.kshare.thread.concurrency;

public class ProducerConsumerManager {
	public static void main(String[] args) {
		SharedObject sharedObj = new SharedObject();
		Thread producer = new Thread(new Producer(sharedObj), "Producer");
		Thread consumer = new Thread(new Consumer(sharedObj), "Consumer");
		producer.start();
		consumer.start();
	}
}

class SharedObject {
	int value = 0;
}

class Producer implements Runnable {
	SharedObject sharedObj;

	public Producer(SharedObject sharedObj) {
		this.sharedObj = sharedObj;
	}

	@Override
	public void run() {
		synchronized (sharedObj) { // Producer has taken lock on sharedObj
			for (int i = 1; i < 10; i++) {
				while (sharedObj.value != 0) { // spurious wake up
					try {
						sharedObj.wait(); // Producer has released the lock and
											// went into waiting state
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				sharedObj.value = i;
				System.out.println(Thread.currentThread().getName() + " --> " + i);
				sharedObj.notify(); // not release the lock and just sending the
									// signal.
			}
		} // once thread will come at end of the synchronize block.
	}

}

class Consumer implements Runnable {
	SharedObject sharedObj;

	public Consumer(SharedObject sharedObj) {
		this.sharedObj = sharedObj;
	}

	@Override
	public void run() {
		synchronized (sharedObj) {
			for (int i = 1; i < 10; i++) {
				while (sharedObj.value == 0) {
					try {
						sharedObj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " consuming " + sharedObj.value);
				sharedObj.value = 0;
				sharedObj.notify();
			}
		}
	}

}
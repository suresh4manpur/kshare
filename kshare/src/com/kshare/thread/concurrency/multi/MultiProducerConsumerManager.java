package com.kshare.thread.concurrency.multi;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class MultiProducerConsumerManager {
	public static void main(String[] args) {
		SharedObject sharedObj = new SharedObject();
		Thread producer1 = new Thread(new Producer(sharedObj), "Producer1");
		Thread producer2 = new Thread(new Producer(sharedObj), "Producer2");
		Thread producer3 = new Thread(new Producer(sharedObj), "Producer3");
		Thread producer4 = new Thread(new Producer(sharedObj), "Producer4");
		Thread producer5 = new Thread(new Producer(sharedObj), "Producer5");
		Thread consumer1 = new Thread(new Consumer(sharedObj), "Consumer1");
		Thread consumer2 = new Thread(new Consumer(sharedObj), "Consumer2");
		Thread consumer3 = new Thread(new Consumer(sharedObj), "Consumer3");
		Thread consumer4 = new Thread(new Consumer(sharedObj), "Consumer4");
		Thread consumer5 = new Thread(new Consumer(sharedObj), "Consumer5");
		producer1.start();
		producer2.start();
		producer3.start();
		producer4.start();
		producer5.start();
		consumer1.start();
		consumer2.start();
		consumer3.start();
		consumer4.start();
		consumer5.start();
	}
}

class SharedObject {
	Queue<Integer> container = new LinkedBlockingQueue<>(50);
}

class Producer implements Runnable {
	SharedObject sharedObj;

	public Producer(SharedObject sharedObj) {
		this.sharedObj = sharedObj;
	}

	@Override
	public void run() {
		synchronized (sharedObj) { // Producer has taken lock on sharedObj
			int i = 1;
			while (true) {
				while (sharedObj.container.size() == 50) { // spurious wake up
					try {
						sharedObj.wait(); // Producer has released the lock and
											// went into waiting state
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				sharedObj.container.add(i);
				System.out.println(Thread.currentThread().getName() + " --> " + i);
				sharedObj.notifyAll(); // not release the lock and just sending the
									// signal.

			} // once thread will come at end of the synchronize block.
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
		synchronized (sharedObj) {
			while (true) {
				while (sharedObj.container.size() == 0) {
					try {
						sharedObj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				int value = sharedObj.container.remove();
				System.out.println(Thread.currentThread().getName() + " consuming " + value);

				sharedObj.notifyAll();
			}
		}
	}
}

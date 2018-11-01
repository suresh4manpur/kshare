package com.kshare.thread.concurrency.multi;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiProducerConsumerManager {
	public static void main(String[] args) {
		SharedObject sharedObj = new SharedObject();
		boolean fairness = false;
		Lock lock = new ReentrantLock(fairness);
		Thread producer1 = new Thread(new Producer(sharedObj, lock), "Producer1");
		Thread producer2 = new Thread(new Producer(sharedObj, lock), "Producer2");
		Thread producer3 = new Thread(new Producer(sharedObj, lock), "Producer3");
		Thread producer4 = new Thread(new Producer(sharedObj, lock), "Producer4");
		Thread producer5 = new Thread(new Producer(sharedObj, lock), "Producer4");
		Thread producer6 = new Thread(new Producer(sharedObj, lock), "Producer4");
		Thread producer7 = new Thread(new Producer(sharedObj, lock), "Producer4");

		Thread consumer1 = new Thread(new Consumer(sharedObj, lock), "Consumer1");
		Thread consumer2 = new Thread(new Consumer(sharedObj, lock), "Consumer2");
		Thread consumer3 = new Thread(new Consumer(sharedObj, lock), "Consumer2");
		Thread consumer4 = new Thread(new Consumer(sharedObj, lock), "Consumer2");
		Thread consumer5 = new Thread(new Consumer(sharedObj, lock), "Consumer2");
		Thread consumer6 = new Thread(new Consumer(sharedObj, lock), "Consumer2");

		producer1.start();
		producer2.start();
		producer3.start();
		producer4.start();
		producer5.start();
		producer6.start();
		producer7.start();

		consumer1.start();
		consumer2.start();
		consumer3.start();
		consumer4.start();
		consumer5.start();
		consumer6.start();

	}
}

class SharedObject {
	BlockingQueue<Integer> container = new LinkedBlockingQueue<>(4);
}

class Producer implements Runnable {
	SharedObject sharedObj;
	Lock lock;

	public Producer(SharedObject sharedObj, Lock lock) {
		this.sharedObj = sharedObj;
		this.lock = lock;
	}

	@Override
	public void run() {
		while (true) {

			long startTime = System.currentTimeMillis();
			long currentTime = 0;
			long diffTime = 0;
			// Below logic will busy in loop till 1 second
			System.out.println(Thread.currentThread().getName() + " - Processing the task..");
			for (;;) {
				currentTime = System.currentTimeMillis();
				diffTime = (currentTime - startTime); // converted

				if (diffTime > 50) {
					break;
				}
			}

			lock.lock();
			try {
				int i = 1;
				while (sharedObj.container.size() == 4) { 
					System.out.println(Thread.currentThread().getName()+" is waiting");
					lock.wait();
				}
				sharedObj.container.put(i);
				System.out.println(Thread.currentThread().getName() + " --> " + i);
				lock.notifyAll();
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				lock.unlock();
			}
		}
	}
}

class Consumer implements Runnable {
	SharedObject sharedObj;
	Lock lock;

	public Consumer(SharedObject sharedObj, Lock lock) {
		this.sharedObj = sharedObj;
		this.lock = lock;
	}

	@Override
	public void run() {
		while (true) {
			lock.lock();
			try {
				while (sharedObj.container.size() == 0) {
					System.out.println(Thread.currentThread().getName()+" is waiting");
					lock.wait();
				}

				System.out.println(Thread.currentThread().getName() + " - Processing the task..");
				int value = sharedObj.container.take();
				System.out.println(Thread.currentThread().getName() + " consuming " + value);
				lock.notifyAll();
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				lock.unlock();
			}
			long startTime = System.currentTimeMillis();
			long currentTime = 0;
			long diffTime = 0;
			for (;;) {
				currentTime = System.currentTimeMillis();
				diffTime = (currentTime - startTime); 
				if (diffTime > 1000) {
					break;
				}
			}
		}
	}

}

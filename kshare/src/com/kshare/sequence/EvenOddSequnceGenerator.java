package com.kshare.sequence;

import java.util.concurrent.atomic.AtomicInteger;

public class EvenOddSequnceGenerator {
	public static void main(String[] args) {
		AtomicInteger ai = new AtomicInteger(0);
		Thread evenPrint = new Thread(new EvenPrint(ai), "Event Print");
		Thread oddPrint = new Thread(new OddPrint(ai), "Odd Print");
		evenPrint.start();
		oddPrint.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (ai.get() > 20) {
			if (!evenPrint.isInterrupted()) {
				evenPrint.interrupt();
			}
			if (!oddPrint.isInterrupted()) {
				oddPrint.interrupt();
			}
			if (evenPrint.isInterrupted() && oddPrint.isInterrupted()) {
				System.out.println("Both thread interrupted. Main is exiting now..");
				break;
			} else {
				System.out.println("Thread not inturrpted..");
			}
		}
	}
}

class SequenceWatcher {
	volatile boolean isOdd = false;
}

class EvenPrint implements Runnable {
	AtomicInteger ai;

	public EvenPrint(AtomicInteger ai) {
		this.ai = ai;
	}

	@Override
	public void run() {
		synchronized (ai) {
			try {
				while (true) {
					while (ai.get() % 2 == 0) {
						ai.wait();
					}
					ai.getAndIncrement();
					System.out.println(Thread.currentThread().getName() + " printing " + ai.get());
					ai.notify();
					// if(ai.get() > 20)break;
				}
			} catch (InterruptedException e) {
				System.out.println("EvenPrint has been interrupted..");
				return;
			}
		}

	}

}

class OddPrint implements Runnable {
	AtomicInteger ai;

	public OddPrint(AtomicInteger ai) {
		this.ai = ai;
	}

	@Override
	public void run() {
		synchronized (ai) {
			try {
				while (true) {
					if (ai.get() % 2 != 0) {

						ai.wait();

					}
					ai.getAndIncrement();
					System.out.println(Thread.currentThread().getName() + " printing " + ai.get());
					ai.notify();
					// if(ai.get() > 20)break;

				}
			} catch (InterruptedException e) {
				System.out.println("OddPrint has been interrupted.");
				return;
			}
		}
	}

}
package com.kshare.sequence.generator.three.thread.withvolatile;

public class ThreeThreadSequnceGeneratorwWithVoltile {
	public static void main(String[] args) {
		SequenceWatcher sw = new SequenceWatcher();
		Thread evenPrint = new Thread(new EvenPrint(sw), "EvenPrint");
		Thread oddPrint = new Thread(new OddPrint(sw), "OddPrint");
		Thread zeroPrint = new Thread(new ZeroPrint(sw), "ZeroPrint");
		evenPrint.start();
		oddPrint.start();
		zeroPrint.start();
	}
}

class SequenceWatcher {
	/**
	 *  0 - Zero thread print the number
	 *  1 - OddPrint thread print the number
	 *  2 - Even thread print the number
	 */
	volatile int signal = 0;
}

class EvenPrint implements Runnable {
	SequenceWatcher ai;

	public EvenPrint(SequenceWatcher ai) {
		this.ai = ai;
	}

	@Override
	public void run() {
		System.out.println("EvenPrint thread has been created!");

		for (int i = 2; i < 10; i += 2) {
			while (ai.signal != 2) {
			}
			System.out.println(Thread.currentThread().getName() + " printing " + i);
			ai.signal = 0;
		}
	}
}

class OddPrint implements Runnable {
	SequenceWatcher ai;

	public OddPrint(SequenceWatcher ai) {
		this.ai = ai;
	}

	@Override
	public void run() {
		System.out.println("OddPrint thread has been created!");
		for (int i = 1; i < 10; i += 2) {
			while (ai.signal != 1) {
			}
			System.out.println(Thread.currentThread().getName() + " printing " + i);
			ai.signal = 2;
		}
	}

}
class ZeroPrint implements Runnable {
	SequenceWatcher ai;

	public ZeroPrint(SequenceWatcher ai) {
		this.ai = ai;
	}

	@Override
	public void run() {
		System.out.println("ZeroPrint thread has been created!");
		for (int i = 1; i < 10; i += 2) {
			while (ai.signal != 0) {
			}
			System.out.println(Thread.currentThread().getName() + " printing " + 0);
			ai.signal = 1;
		}
	}

}
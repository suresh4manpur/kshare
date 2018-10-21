package com.kshare.sequence.generator.withvolatile;

public class EvenOddSequnceGeneratorwWithVoltile {
	public static void main(String[] args) {
		SequenceWatcher sw = new SequenceWatcher();
		Thread evenPrint = new Thread(new EvenPrint(sw), "EvenPrint");
		Thread oddPrint = new Thread(new OddPrint(sw), "OddPrint");
		evenPrint.start();
		oddPrint.start();
	}
}

class SequenceWatcher {
	volatile boolean isOdd = true;
	int count = 0;
}

class EvenPrint implements Runnable {
	SequenceWatcher ai;

	public EvenPrint(SequenceWatcher ai) {

		this.ai = ai;
	}

	@Override
	public void run() {

		for (int i = 2; i < 10; i += 2) {
			while (ai.isOdd) {
			}
			System.out.println(Thread.currentThread().getName() + " printing " + i);
			ai.isOdd = true;
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
		for (int i = 1; i < 10; i += 2) {
			while (!ai.isOdd) {
			}
			System.out.println(Thread.currentThread().getName() + " printing " + i);
			ai.isOdd = false;
		}
	}

}
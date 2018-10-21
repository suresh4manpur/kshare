package com.kshare.sequence.generator.three.thread.withvolatile.alt.zero;

public class ThreeThreadSequnceAltZeroGeneratorwWithVoltile {
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
	 *  zeroFlag - To enable to print Zero thread print the number
	 *  oddFlag - OddPrint and EvenPrint thread print the number as per the value.
	 */
	volatile boolean zeroFlag = true;
	volatile boolean oddFlag = true;
	volatile boolean stop = false;
}

class EvenPrint implements Runnable {
	SequenceWatcher ai;

	public EvenPrint(SequenceWatcher ai) {
		this.ai = ai;
	}

	@Override
	public void run() {
		System.out.println("EvenPrint thread has been created!");
		synchronized (ai) {
			
			try{
				for (int i = 2; i < 10; i += 2) {
					while (ai.oddFlag || ai.zeroFlag) {
						ai.wait();
					}
					System.out.println(Thread.currentThread().getName() + " printing " + i);
					ai.oddFlag = !ai.oddFlag;
					ai.zeroFlag = true;
					ai.notifyAll();
				}
			}catch(InterruptedException e){
				e.printStackTrace();
			}		}


		System.out.println("Coming out of the Even Thread");
		ai.stop = true;
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
		synchronized (ai) {
			try {
			for (int i = 1; i < 10; i += 2) {
				while (!ai.oddFlag || ai.zeroFlag) {
					ai.wait();
				}
				System.out.println(Thread.currentThread().getName() + " printing " + i);
				ai.oddFlag = !ai.oddFlag;
				ai.zeroFlag = true;
				ai.notifyAll();
			}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("Coming out of the Odd Thread");

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
		synchronized (ai) {
			try {
				for (int i = 1; i < 20; i += 2) {
					if(ai.stop){
						return;
					}
					while (!ai.zeroFlag ) {
						ai.wait();
					}
					System.out.println(Thread.currentThread().getName() + " printing " + 0);
					ai.zeroFlag = false;
					ai.notifyAll();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}


		System.out.println("Coming out of the Zero Thread");
		ai.stop = true;
	}

}
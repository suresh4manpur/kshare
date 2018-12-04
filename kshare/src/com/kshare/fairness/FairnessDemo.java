package com.kshare.fairness;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class FairnessDemo {
	private static Lock lock = new ReentrantLock(true);
    //private static Object sharedObj = new Object();

    public static void main (String[] args) {
        JFrame frame = createFrame();
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        for (int i = 0; i < 5; i++) {
            ProgressThread progressThread = new ProgressThread();
            frame.add(progressThread.getProgressComponent());
            progressThread.start();
        }

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JFrame createFrame () {
        JFrame frame = new JFrame("Fairness Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(300, 200));
        return frame;
    }

    private static class ProgressThread extends Thread {
        JProgressBar progressBar;

        ProgressThread () {
            progressBar = new JProgressBar();
            progressBar.setString(this.getName());
            progressBar.setStringPainted(true);
        }

        JComponent getProgressComponent () {
            return progressBar;
        }

        @Override
        public void run () {

            int c = 0;
            while (true) {
            	lock.lock();
                    if (c == 100) {
                        c = 0;
                    }
                    progressBar.setValue(++c);
                    try {
                        //simulate long running task with wait..
                        // releasing the lock for long running task gives
                        //fair chances to run other threads
                    	Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.unlock();
            }
        }
    }
}
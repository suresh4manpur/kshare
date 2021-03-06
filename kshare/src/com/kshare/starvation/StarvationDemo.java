package com.kshare.starvation;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class StarvationDemo {
    private static Object sharedObj = new Object();

    public static void main (String[] args) {
        JFrame frame = createFrame();
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));
        Lock lock = new ReentrantLock(true);

        for (int i = 0; i < 5; i++) {
            ProgressThread progressThread = new ProgressThread(lock);
            frame.add(progressThread.getProgressComponent());
            progressThread.start();
        }

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JFrame createFrame () {
        JFrame frame = new JFrame("Starvation Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(300, 200));
        return frame;
    }

    private static class ProgressThread extends Thread {
        JProgressBar progressBar;
        Lock lock;
        ProgressThread (Lock lock) {
        	this.lock = lock;
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
               // synchronized (sharedObj) {
            	lock.lock();
                    if (c == 100) {
                        c = 0;
                    }
                    progressBar.setValue(++c);
                    try {
                        //sleep the thread to simulate long running task
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
						lock.unlock();
					}
            //    }
            }
        }
    }
}

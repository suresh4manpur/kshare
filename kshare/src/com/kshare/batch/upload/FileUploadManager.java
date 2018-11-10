package com.kshare.batch.upload;

import java.io.File;

public class FileUploadManager {
	public static void main(String[] args) {
		System.out.println("File UPload started!");

		long startTime = System.currentTimeMillis();
		long endsTime = System.currentTimeMillis();

		int fileSize = 2;
		File[] files = new File[fileSize];
		String fileName = "";

		FileUploader[] fileUploaders = new FileUploader[files.length];
		for (int i = 0; i < files.length; i++) {
			fileName = FileConstants.INCOMING_AREA_PATH + "File" + i + ".txt";
			System.out.println(fileName);
			files[i] = new File(fileName);
			System.out.println(" getAbsolutePath : " + files[i].getAbsolutePath());
			fileUploaders[i] = new FileUploader(files[i]);
		}
		// System.exit(1);
		for (int i = 0; i < files.length; i++) {
			fileUploaders[i].start();
		}

		for (int i = 0; i < files.length; i++) {
			try {
				fileUploaders[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		endsTime = System.currentTimeMillis();
		/*
		 * System.out.println("Time taken in file parsing is "+totalReadingTime+
		 * " seconds");
		 */
		System.out.println("Time taken in writting into DB is " + (endsTime - startTime) / (1000) + " seconds");

		System.out.println("Initiated the file writting process...");

	}
}

class FileUploader extends Thread {
	File file;

	public FileUploader(File file) {
		super();
		this.file = file;
	}

	@Override
	public void run() {

		MyFileReader reader = new MyFileReader();
		reader.readFromFile(file);
	}
}

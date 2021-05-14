package com.ss.training.w1.d4.a2;

public class W1D4Assignment2 {
	
	public static void main(String[] args) {
		
		int[] data = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] data2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		Runnable thread1 = new Runnable() {
			@Override
			public void run() {
				try {
					synchronized(data){
						System.out.println("Thread 1 has accessed data");
						for(int i : data) {
							i=i+1;
						}
						System.out.println("Thread 1 is waiting to access data2");
						Thread.sleep(100);
						synchronized(data2){
							System.out.println("Thread 1 has accessed data2");
							for(int i : data2) {
								i=i+1;
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		Runnable thread2 = new Runnable() {
			@Override
			public void run() {
				try {
					synchronized(data2){
						System.out.println("Thread 2 has accessed data2");
						for(int i : data2) {
							i=i+1;
						}
						System.out.println("Thread 2 is waiting to access data");
						synchronized(data){
							System.out.println("Thread 2 has accessed data");
							for(int i : data) {
								i=i+1;
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		new Thread(thread1).start();
		new Thread(thread2).start();
		
	}

}

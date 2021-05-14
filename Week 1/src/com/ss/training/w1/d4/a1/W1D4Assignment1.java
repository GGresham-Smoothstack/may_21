package com.ss.training.w1.d4.a1;

public class W1D4Assignment1 {

	public static void main(String[] args) {
		
	Runnable thread1 = new Runnable() {
		@Override
		public void run() {
			try {
				System.out.println("Thread 1 has accessed the Singleton. Printing Singleton now. " + ThreadSafeSingletonExample.getSingleton());
				System.out.println("Thread 1 has accessed the Singleton. Printing Singleton now. " + ThreadSafeSingletonExample.getSingleton());
				System.out.println("Thread 1 has accessed the Singleton. Printing Singleton now. " + ThreadSafeSingletonExample.getSingleton());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};
	
	Runnable thread2 = new Runnable() {
		@Override
		public void run() {
			try {
				System.out.println("Thread 2 has accessed the Singleton. Printing Singleton now. " + ThreadSafeSingletonExample.getSingleton());
				System.out.println("Thread 2 has accessed the Singleton. Printing Singleton now. " + ThreadSafeSingletonExample.getSingleton());
				System.out.println("Thread 2 has accessed the Singleton. Printing Singleton now. " + ThreadSafeSingletonExample.getSingleton());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	};
	
	new Thread(thread1).start();
	new Thread(thread2).start();

	}

}

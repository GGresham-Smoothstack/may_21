package com.ss.training.w1.d4.a3;

import java.util.Random;

import com.ss.training.w1.d4.a1.ThreadSafeSingletonExample;

public class W1D4Assignment3 {
	
	public static int[] buffer;

	public static void main(String[] args) {
		
		buffer = new int[10];
		Random r = new Random();
		
		for(int i=0; i<buffer.length; i++) {
			
			if(i<buffer.length/2) {
				i = r.nextInt(100)+1;
			}else {
				i=0;
			}
			
		}
		
		Runnable producer = new Runnable() {
			@Override
			public void run() {
				try {
					int index = buffer.length/2;
					int value = 0;
					while(true) {
						Thread.sleep(1000);
						value = r.nextInt(100)+1;
						put(index, value);
						System.out.println("Producer has produced a value of " + value + " in position " + index + ".");
						if(index<buffer.length) {
							index++;
						}else {
							index = 0;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		};
		
		Runnable consumer = new Runnable() {
			@Override
			public void run() {
				try {
					int index = 0;
					while(true) {
						Thread.sleep(1000);
						put(index, 0);
						System.out.println("Consumer has consumed the value in position " + index + ".");
						if(index<buffer.length) {
							index++;
						}else {
							index = 0;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		};
		
		new Thread(producer).start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(consumer).start();

	}
	
	public static synchronized void put(int index, int value) {
		if(index > 0 && index < buffer.length) {
			buffer[index] = value;
		}
	}

}

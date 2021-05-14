package com.ss.training.w1.d4.a1;

public class ThreadSafeSingletonExample {
	
	private static volatile ThreadSafeSingletonExample singleton = new ThreadSafeSingletonExample();;
	
	public static ThreadSafeSingletonExample getSingleton() {
		
		if(singleton == null) {
			singleton = new ThreadSafeSingletonExample();
		}
		synchronized(singleton){
			return singleton;
		}
	}

}

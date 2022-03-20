package com.solutions;

public class NewThread implements Runnable{
	
	Thread t;
	
	NewThread(String name) {
		t = new Thread(this, name);
		System.out.println("New thread : "+t.getName());
		t.start();
	}
	
	

	


	@Override
	public void run() {
		try {
			for(int i=0;i<5;i++) {
				System.out.println(Thread.currentThread().getName()+" : "+i);
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" exiting!");
		
	}

}


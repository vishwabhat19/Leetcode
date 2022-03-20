package com.solutions;

public class JoinExample {
	
	void printNumbers() {
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(500);
				System.out.println(i);
				if(i==5) Thread.currentThread().interrupt();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		
		JoinExample example = new JoinExample();
		System.out.println("In the Main Thread!!");
		Thread t = new Thread(() -> example.printNumbers());
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Back in Main Thread!");

	}

}

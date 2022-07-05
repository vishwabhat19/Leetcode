package com.solutions;

public class ThreadsPractice
{
	public static void main(String[] args)
	{
		Thread t1 = new Thread(() -> System.out.println("Hey Thread 1"));
		Thread t2 = new Thread(() -> System.out.println("Hey Thread 2"));

		t1.start();
		t2.start();
	}
}

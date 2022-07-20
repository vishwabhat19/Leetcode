package com.solutions;

public class SimpleOnlineBanking
{

	private int balance = 0;

	public synchronized void deposit(int amount)
	{
		System.out.println("Depositing Money Started by Thread: " + Thread.currentThread().getName());
		balance += amount;
		System.out.println("Depositing Money ended by Thread: " + Thread.currentThread().getName() + " and balance is: " + balance);
		notify();
	}

	public synchronized void withdraw(int amount)
	{
		System.out.println("Inside Withdraw " + Thread.currentThread().getName());
		while (amount > balance)
		{
			System.out.println("Insufficient Balance! Waiting for deposit..." + Thread.currentThread().getName());
			try
			{
				wait();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("Deposit has happened!");
		balance -= amount;
		System.out.println("Withdrawal done. Balance is: " + balance);

	}

	public static void main(String[] args)
	{

		SimpleOnlineBanking banking = new SimpleOnlineBanking();
		Thread t1 = new Thread(() -> banking.withdraw(10000), "Thread 1");
		Thread t2 = new Thread(() -> banking.deposit(1), "Thread 2");
		Thread t3 = new Thread(() -> banking.deposit(2), "Thread 3");
		Thread t4 = new Thread(() -> banking.deposit(60000), "Thread 4");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}

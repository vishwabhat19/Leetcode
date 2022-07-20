package com.solutions;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LionPenManager
{

	private void removeLions()
	{
		System.out.println("Removing Lions");
	}

	private void cleanPen()
	{
		System.out.println("Cleaning the Pen");
	}

	private void addLions()
	{
		System.out.println("Adding Lions");
	}

	public void performTask(CyclicBarrier cb1, CyclicBarrier cb2, CyclicBarrier cb3)
	{
		System.out.println("Current Thread is: " + Thread.currentThread());
		removeLions();
		try
		{
			/*
			 * Create a Barrier after One worker removes some lions.
			 * Make sure all the Lions are removed by all the workers before starting to clean the Pen
			 */
			cb1.await();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		catch (BrokenBarrierException e)
		{
			e.printStackTrace();
		}
		cleanPen();
		/*
		 * Creating a barrier after One worker cleans the Pens.
		 * We need all the workers to clean the pens and come out safely before adding the lions.
		 * Since we have 4 workers, the CyclicBarrier breaks after the await() method is called on it 4 times.
		 */
		try
		{
			/*
			 * Create a Barrier after One worker removes some lions.
			 * Make sure all the Lions are removed by all the workers before starting to clean the Pen
			 */
			cb2.await();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		catch (BrokenBarrierException e)
		{
			e.printStackTrace();
		}
		addLions();
		try
		{
			/*
			 * Create a Barrier after One worker removes some lions.
			 * Make sure all the Lions are removed by all the workers before starting to clean the Pen
			 */
			cb3.await();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		catch (BrokenBarrierException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{

		CyclicBarrier cb1 = new CyclicBarrier(4, () -> System.out.println("Removed Lions!!Workers go and clean the Pens!"));
		CyclicBarrier cb2 = new CyclicBarrier(4, () -> System.out.println("Cleaned the Pens. Workers are out of the Pens!"));
		CyclicBarrier cb3 = new CyclicBarrier(4, () -> System.out.println("All the lions are added! Close the Pens right away!!"));

		ExecutorService service = null;

		try
		{
			/*
			 * MAKE SURE THAT THE NUMBER OF THREADS IS AT LEAST EQUAL TO OR MORE THAN THE CYCLICBARRIER LIMIT!!!!
			 * ELSE THIS WILL LEAD TO DEADLOCK!!
			 */
			service = Executors.newFixedThreadPool(15);

			LionPenManager lionPenManager = new LionPenManager();

			for (int i = 0; i < 4; i++)
			{
				service.submit(() -> lionPenManager.performTask(cb1, cb2, cb3));
			}
		}
		finally
		{
			if (null != service)
				service.shutdown();
		}
	}

}

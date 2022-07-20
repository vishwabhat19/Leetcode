package com.solutions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SheepManager
{

	private AtomicInteger sheepCount = new AtomicInteger(0);

	private void incrementAndReport()
	{
		synchronized (this)
		{
			System.out.println((sheepCount.incrementAndGet()) + " ");
		}
	}

	public static void main(String[] args)
	{
		ExecutorService service = null;
		try
		{
			service = Executors.newFixedThreadPool(200);
			SheepManager sheepManager = new SheepManager();
			for (int i = 0; i < 100; i++)
			{
				service.submit(() -> sheepManager.incrementAndReport());
			}
		}
		finally
		{
			if (null != service)
				service.shutdown();
		}

	}

}

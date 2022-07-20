package com.solutions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class GoodFood
{
}

class GoodWater
{
}

public class Lion
{

	public void eatAndDrink(GoodFood food, GoodWater water)
	{
		synchronized (food)
		{
			System.out.println("Got Food!");
			move();
			synchronized (water)
			{
				System.out.println("Got Water!");
			}
		}
	}

	public void drinkAndEat(GoodFood food, GoodWater water)
	{
		synchronized (water)
		{
			System.out.println("Got Water!");
			move();
			synchronized (food)
			{
				System.out.println("Got Food");
			}
		}
	}

	public void move()
	{
		try
		{
			Thread.sleep(100);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		Lion lion1 = new Lion();
		Lion lion2 = new Lion();
		GoodWater water = new GoodWater();
		GoodFood food = new GoodFood();

		ExecutorService service = null;
		try
		{
			service = Executors.newScheduledThreadPool(10);
			service.submit(() -> lion1.eatAndDrink(food, water));
			service.submit(() -> lion2.drinkAndEat(food, water));
		}
		finally
		{
			if (service != null)
				service.shutdown();
		}
	}
}

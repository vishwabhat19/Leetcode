package com.streams;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Food {}
class Water{}

public class Fox {
	
	public void eatAndDrink(Food food, Water water) {
		synchronized (food) {
			System.out.println("Got Food!Waiting for water!");
			move();
			synchronized (water) {
				System.out.println("Got Water!Done Feeding");
			}
		}
	}
	
	public void drinkAndEat(Food food, Water water) {
		synchronized (water) {
			System.out.println("Got Water!Waiting for Food!");
			move();
			synchronized (food) {
				System.out.println("Got Food!Done Feeding");
			}
		}
	}
	
	

	public void move() {
		try {
			Thread.sleep(100);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		Fox fox1 = new Fox();
		Fox fox2 = new Fox();
		Food food = new Food();
		Water water = new Water();
		ExecutorService service = null;
		service = Executors.newFixedThreadPool(10);
		service.submit(() -> fox1.eatAndDrink(food, water));
		service.submit(() -> fox2.drinkAndEat(food, water));
		
	}

}

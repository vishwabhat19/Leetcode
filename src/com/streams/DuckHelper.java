package com.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DuckHelper {
	
	public static int compareByWeight(Duck d1,Duck d2) {
		return d1.getWeight() - d2.getWeight();
	}
	
	public static int compareByName(Duck d1, Duck d2) {
		return d1.getName().compareTo(d2.getName());
	}
	
	public static void main(String args[]) {
		//Comparator<Duck> byWeight = (d1,d2) -> DuckHelper.compareByWeight(d1, d2);
		
		Comparator<Duck> byWeight = DuckHelper::compareByWeight;
		Duck duck1 = new Duck(10000, "Duckey");
		Duck duck2 = new Duck(500, "Funney");
		List<Duck> list = Arrays.asList(duck1,duck2);
		list.sort(byWeight);
		list.stream().map(duck -> duck.getName()).forEach(System.out::println);
	}

}

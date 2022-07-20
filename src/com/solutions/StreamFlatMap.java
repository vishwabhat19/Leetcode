package com.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamFlatMap
{

	public static void main(String[] args)
	{

		Developer d1 = new Developer();
		d1.setName("Vishwa");
		d1.addBook("Java 8 OCAJP");
		d1.addBook("OCPJP");
		d1.addBook("AWS Solutions Arch");

		Developer d2 = new Developer();
		d1.setName("Tim");
		d1.addBook("SpringBoot");
		d1.addBook("Microservices");

		List<Developer> developers = new ArrayList<Developer>();
		developers.add(d1);
		developers.add(d2);

		Set<String> collect = developers.stream()
				.map(developer -> developer.getBooks()) // Produces Stream<Set<String>> i.e. Stream of Sets
				.flatMap(bookSet -> bookSet.stream())
				.collect(Collectors.toSet());

		collect.forEach(System.out::println);
	}

}

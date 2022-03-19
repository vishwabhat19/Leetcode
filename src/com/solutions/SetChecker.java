package com.streams;

import java.util.HashSet;
import java.util.Set;

public class SetChecker {

	public static void main(String[] args) {
		Set<TagEx> set = new HashSet<TagEx>();
		TagEx tag1 = new TagEx("Vishwa", 30);
		TagEx tag2 = new TagEx("Munna", 25);
		
		set.add(tag1);
		set.add(tag2);
		
		set.removeIf((tag) -> tag.getName().equalsIgnoreCase("Vishwa"));
		
		set.forEach((tag) -> System.out.println(tag.getName()));
	}

}

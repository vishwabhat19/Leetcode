package com.streams;

import java.util.Arrays;
import java.util.List;

public class StreamMap {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Vishwa","Kavita","GeeksForGeeks");
		list.stream().map(str -> str.length()).forEach(System.out::println);
		

	}

}

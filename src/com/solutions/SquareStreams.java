package com.solutions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SquareStreams
{

	public static void main(String[] args)
	{

		List<String> list = Arrays.asList(new String[] { "1", "2", "3", "4" });
		list = list.stream().map(s -> Integer.toString(Integer.parseInt(s) * Integer.parseInt(s))).collect(Collectors.toList());
		list.stream().forEach(System.out::println);
	}

}

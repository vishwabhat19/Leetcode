package com.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Use Streams to output the frequency of each String
 */
public class Streams
{
	public static void main(String[] args)
	{
		String s[] = {"batman", "superman", "batman", "batman"};
		Map<String, Long> map = Arrays.stream(s).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		map.entrySet().stream().forEach((e) -> System.out.println(e.getKey()+" "+e.getValue()));
	}
}

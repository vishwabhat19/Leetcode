package com.solutions;

import java.util.Arrays;

public class JavaStreams
{

	public static void main(String[] args)
	{
		Arrays.asList(1, 2, 3, 4, 5, 6)
				.parallelStream()
				.forEach((n) -> System.out.print(n));

	}
}

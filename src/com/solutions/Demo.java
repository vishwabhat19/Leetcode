package com.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo
{
	public static void main(String[] args)
	{
		List<Integer> list1 = Arrays.asList(new Integer[]{1,3,2});
		List<Integer> list2 = Arrays.asList(new Integer[]{1,2,3});
		System.out.println(list1.equals(list2));

	}

}
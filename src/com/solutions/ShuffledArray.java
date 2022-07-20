package com.solutions;

import java.util.Arrays;

public class ShuffledArray
{

	public static void main(String[] args)
	{
		Integer nums[] = { 2, 5, 1, 3, 4, 7 };
		int n = 3;
		int[] shuffledArray = shuffle(nums, n);
		Arrays.stream(shuffledArray).forEach(System.out::print);
	}

	public static int[] shuffle(Integer[] nums, int n)
	{
		int[] shuffledArray = new int[nums.length];
		for (int i = 0, j = n, index = 0; i < n; i++, j++, index++)
		{
			shuffledArray[index] = nums[i];
			shuffledArray[index + 1] = nums[j];
		}
		return shuffledArray;
	}

}

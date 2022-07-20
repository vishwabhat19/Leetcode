package com.solutions;

import java.util.Arrays;

public class SquaresSortedArray
{
	public static void main(String[] args)
	{
		int nums[] = { -4, -1, 0, 3, 10 };
		Arrays.stream(sortedSquares(nums)).forEach(System.out::println);
	}

	static int[] sortedSquares(int nums[])
	{
		int result[] = new int[nums.length];
		int start = 0;
		int end = nums.length - 1;
		int resultArrayIndex = end;
		while (start < end)
		{
			if (Math.abs(nums[start]) > Math.abs(nums[end]))
			{
				result[resultArrayIndex] = nums[start] * nums[start];
				resultArrayIndex--;
				start++;
			}
			else
			{
				result[resultArrayIndex] = nums[end] * nums[end];
				end--;
				resultArrayIndex--;
			}
		}
		return result;
	}

}

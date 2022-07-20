package com.solutions;

public class SingleNumber
{

	public static void main(String[] args)
	{
		int nums[] = { 4, 1, 2, 1, 2 };
		System.out.println(singleNumber(nums));
	}

	private static int singleNumber(int[] nums)
	{

		int res = 0;
		for (int n : nums)
		{
			res = res ^ n;
		}
		return res;
	}

}

package com.solutions;

public class SearchInSortedArray
{

	public static void main(String[] args)
	{
		int nums[] = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 1;
		System.out.println(search(nums, target));
	}

	static int search(int[] nums, int target)
	{

		if (nums == null || nums.length == 0)
			return -1;
		//First I need to find the Pivot index
		int left = 0;
		int right = nums.length - 1;
		while (left < right)
		{
			int midPoint = left + (right - left) / 2;
			if (nums[midPoint] > nums[right])
			{
				//In a sorted array nothing should be greater than the element on the right. This means pivot point is further to the right
				left = midPoint + 1;
			}
			else
			{
				//This means we are already past the pivot point and we move to the left
				right = midPoint - 1;
			}
		}
		int pivotPoint = left;

		//Do a binary search again

		if (target == nums[pivotPoint])
			return pivotPoint;

		if (target > nums[pivotPoint] && target <= nums[nums.length - 1])
		{
			left = pivotPoint + 1;
			right = nums.length - 1;
		}
		else
		{
			left = 0;
			right = pivotPoint - 1;
		}

		while (left < right)
		{
			int midPoint = left + (right - left) / 2;
			if (target == nums[midPoint])
				return midPoint;
			else
			{
				left++;
				right--;
			}
		}

		return -1;

	}

}

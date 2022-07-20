package com.solutions;

import java.util.Arrays;

public class MergeSortedArray
{

	public static void main(String[] args)
	{
		int nums1[] = { 1, 2, 3, 0, 0, 0 }, nums2[] = { 2, 5, 6 };
		int m = 3, n = 3;
		merge(nums1, m, nums2, n);
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n)
	{

		int left = m - 1;
		int right = n - 1;
		for (int i = m + n - 1; i >= 0; i--)
		{
			if (left >= 0 && right >= 0)
			{
				if (nums1[left] > nums2[right])
				{
					nums1[i] = nums1[left];
					left--;
				}
				else
				{
					nums1[i] = nums2[right];
					right--;
				}
			}
			else if (left >= 0)
			{
				nums1[i] = nums1[left];
				left--;
			}
			else if (right > 0)
			{
				nums1[i] = nums2[right];
				right--;
			}

		}
		Arrays.stream(nums1).forEach(System.out::println);

	}
}

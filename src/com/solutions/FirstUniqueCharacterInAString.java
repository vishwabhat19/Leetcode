package com.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1
 */
public class FirstUniqueCharacterInAString
{
	public static void main(String[] args)
	{
		String s = "lleetcode";
		System.out.println(firstUniqChar(s));
	}

	public static int firstUniqChar(String s)
	{
		int arr[] = new int[256];

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = -1;
		}

		for (int i = 0; i < s.length(); i++)
		{
			if (arr[s.charAt(i)] == -1)
			{
				arr[s.charAt(i)] = i;
			}
			else
			{
				arr[s.charAt(i)] = -2;
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] >= 0)
			{
				min = Math.min(min, arr[i]);
			}
		}
		if (min == Integer.MAX_VALUE)
		{
			return -1;
		}
		else
			return min;
	}

}

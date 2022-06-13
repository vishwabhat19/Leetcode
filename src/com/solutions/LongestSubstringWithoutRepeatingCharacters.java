package com.solutions;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters
{
	public static void main(String[] args)
	{
		String s = "pwwkew";
		System.out.println(lengthOfLongestSubstring(s));
	}

	public static int lengthOfLongestSubstring(String s) {
		int start = 0;
		int max_length = Integer.MIN_VALUE;
		Map<Character, Integer> map = new HashMap<>();
		for(int end=0;end<s.length();end++) {
			if(map.containsKey(s.charAt(end))) {
				start = Math.max(start, map.get(s.charAt(end))+1);
			}
			else {
				map.put(s.charAt(end),end);
				max_length = Math.max(max_length, end - start);
			}
		}
		return max_length;
	}
}

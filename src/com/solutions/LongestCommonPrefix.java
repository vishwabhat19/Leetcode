package com.solutions;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix
{
	public static void main(String[] args)
	{
		String trs[] = { "gee", "geeks", "geeksfor"};
		System.out.println(longestCommonPrefix(trs));
	}

	public static String longestCommonPrefix(String[] strs) {
		String lcp = strs[0];
		for(int i=1;i<strs.length;i++) {
			lcp = prefixUtil(lcp,strs[i]);
		}
		return lcp;
	}

	public static String prefixUtil(String s1, String s2) {
		String lcpIntermediate = "";
		for(int i=0,j=0;i<s1.length() && j<s2.length();i++,j++) {
			if(s1.charAt(i)!=s2.charAt(j)) {
				break;
			}
			else {
				lcpIntermediate+= s1.charAt(i);
			}
		}
		return lcpIntermediate;
	}
}

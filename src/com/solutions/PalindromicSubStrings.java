//package com.solutions;
//
///*
//Given a string s, return the number of palindromic substrings in it.
//
//A string is a palindrome when it reads the same backward as forward.
//
//A substring is a contiguous sequence of characters within the string.
//
//
//
//Example 1:
//
//Input: s = "abc"
//Output: 3
//Explanation: Three palindromic strings: "a", "b", "c".
//Example 2:
//
//Input: s = "aaa"
//Output: 6
//Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
// */
//public class PalindromicSubStrings
//{
//	public static void main(String[] args)
//	{
//		String s = "aaa";
//		System.out.println(countSubstrings(s));
//	}
//
////	public static int countSubstrings(String s) {
////		StringBuilder sb;
////		String temp;
////		int count = 0;
////		for(int i=0;i<s.length();i++) {
////			for(int j=i+1;j<=s.length();j++) {
////				temp = s.substring(i,j);
////				if(temp.length()>1) {
////					sb =  new StringBuilder(temp);
////					sb.reverse();
////					if(sb.toString().compareTo(temp)) {
////						count++;
////					}
////				}
////			}
////		}
////		return count+s.length();
////	}
//}

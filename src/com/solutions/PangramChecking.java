package com.solutions;

/*
A pangram is a sentence where every letter of the English alphabet appears at least once.

Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.



Example 1:

Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.
Example 2:

Input: sentence = "leetcode"
Output: false
 */
public class PangramChecking
{
	public static void main(String[] args)
	{
		String sentence = "asadsda";
		System.out.println(checkIfPangram(sentence));
	}

	public static boolean checkIfPangram(String sentence) {
		boolean mark[] = new boolean[26];
		for(int i=0;i<sentence.length();i++) {
			int index = 0;
			if(sentence.charAt(i) >='a' && sentence.charAt(i)<='z') {
				index = sentence.charAt(i) - 'a';
			}
			mark[index] = true;
		}
		for(int i=0;i<mark.length;i++) {
			if(mark[i] == false) return false;
		}
		return true;
	}
}

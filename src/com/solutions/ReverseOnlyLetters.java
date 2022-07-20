package com.solutions;

/*
Given a string s, reverse the string according to the following rules:

All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.



Example 1:

Input: s = "ab-cd"
Output: "dc-ba"
Example 2:

Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
 */
public class ReverseOnlyLetters
{
	public static void main(String[] args)
	{
		String s = "a-bC-dEf-ghIj";
		char c[] = s.toCharArray();
		System.out.println(reverseOnlyLetters(c));
	}

	public static String reverseOnlyLetters(char[] s)
	{
		int leftIndex = 0, rightIndex = s.length - 1;
		while (leftIndex < rightIndex)
		{
			if (!Character.isAlphabetic(s[leftIndex]))
			{
				leftIndex++;
			}
			else if (!Character.isAlphabetic(s[rightIndex]))
			{
				rightIndex--;
			}
			else
			{
				char temp = s[leftIndex];
				s[leftIndex] = s[rightIndex];
				s[rightIndex] = temp;
				leftIndex++;
				rightIndex--;
			}
		}
		return new String(s);
	}

}

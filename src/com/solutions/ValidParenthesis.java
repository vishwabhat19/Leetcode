package com.solutions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

 */
public class ValidParenthesis
{
	public static void main(String[] args)
	{
		String  s = "(){}}{";
		System.out.println(isValid(s));
	}

	public static boolean isValid(String s)
	{
		if(s == null || s.isEmpty() || s.charAt(0) == '}' || s.charAt(0) == ']' || s.charAt(0) == ')') return false;
		Deque<Character> stack = new ArrayDeque<>();
		//Check for opening brackets
		for(int i=0;i<s.length();i++) {
			Character currentBracket = s.charAt(i);
			if(currentBracket == '{' || currentBracket =='[' || currentBracket == '(') {
				stack.push(s.charAt(i));
			}
			else {
				//Stack shouldn't be empty here
				if(stack.isEmpty()) return false;
				Character c = stack.pop();
				switch(currentBracket) {
					case '}' : if(c == '[' || c == '(')
						return false;
						break;

					case ')' : if(c == '{' || c == '[')
						return false;
						break;

					case ']' : if(c == '{' || c == '(')
						return false;
						break;

				}
			}

		}
		return stack.isEmpty();
	}
}

package com.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.
 */
public class RansomNote
{
	public static void main(String[] args)
	{
		String ransomNote = "aa", magazine = "aab";
		System.out.println(canConstruct(ransomNote, magazine));
	}
	public static boolean canConstruct(String ransomNote, String magazine) {
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0;i<magazine.length();i++) {
			if(map.containsKey(magazine.charAt(i))) {
				int count = map.get(magazine.charAt(i));
				count++;
				map.put(magazine.charAt(i), count);
			}
			else {
				map.put(magazine.charAt(i), 1);
			}
		}

		for(int i=0;i<ransomNote.length();i++) {
			if(map.containsKey(ransomNote.charAt(i))) {
				int count = map.get(ransomNote.charAt(i));
				count --;
				if (count == 0) {
					map.remove(ransomNote.charAt(i));
				}
				else {
					map.put(ransomNote.charAt(i), count);
				}
			}
			else {
				return false;
			}
		}
		return true;
	}
}



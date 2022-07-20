package com.testcode;

public class Testing
{

	public static void main(String[] args)
	{
		print("a", 1);
	}

	static void print(String s, int... argss)
	{
		System.out.println(argss[0]);
	}
}

package com.solutions;

public class OuterClass
{

	private int outerClassVariable;

	public static class InnerClass
	{

		public void print()
		{
			System.out.println(this);
		}
	}
}

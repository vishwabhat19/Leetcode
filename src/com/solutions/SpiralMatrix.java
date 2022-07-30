package com.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
54. Spiral Matrix
Given an m x n matrix, return all elements of the matrix in spiral order.
 */
public class SpiralMatrix
{
	public static void main(String[] args)
	{
		int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
		List<Integer> arrayList = spiralOrder(arr);
		arrayList.forEach(System.out::println);
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		Arrays.stream(matrix[0]).forEach(e -> list.add(e));
		return list;
	}
}

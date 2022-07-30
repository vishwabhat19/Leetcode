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
		int arr[][] = { { 1,2,3 }, { 4,5,6}, {7,8,9}};
		List<Integer> arrayList = spiralOrder(arr);
		arrayList.forEach(System.out::println);
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		int left = 0;
		int right = matrix[0].length - 1;
		int top = 0;
		int bottom = matrix.length - 1;
		int size = (right+1) * (bottom+1);
		while(list.size() != size) {
			for(int i=left;i <= right && list.size()!=size; i++) {
				list.add(matrix[top][i]);
			}
			top++;
			for(int j=top;j<=bottom && list.size()!=size;j++) {
				list.add(matrix[j][right]);
			}
			right--;
			for(int i=right;i>=left && list.size()!=size;i--) {
				list.add(matrix[bottom][i]);
			}
			bottom--;
			for(int i=left;i<=right && list.size()!=size;i++)
			{
				list.add(matrix[bottom][i]);
			}
		}
		return list;
	}
}

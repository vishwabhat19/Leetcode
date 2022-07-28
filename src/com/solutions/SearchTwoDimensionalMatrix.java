package com.solutions;

import java.util.Arrays;
import java.util.stream.Stream;
/*
74. Search a 2D Matrix
 */
public class SearchTwoDimensionalMatrix
{
	public static void main(String[] args)
	{
		int arr[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		if(searchMatrix(arr, 3))
			System.out.println("true");
		else
			System.out.println("false");

	}

	public static boolean searchMatrix(int[][] matrix, int target) {

		//Check which row
		int rows = matrix.length;
		System.out.println("No of rows: "+rows);
		System.out.println("No of columns: "+matrix[0].length);
		int columns = matrix[0].length;
		int rowToSearch = -1;
		for(int i=0;i<rows;i++) {
			if(target == matrix[i][columns-1]) return true;
			if(target < matrix[i][columns-1]) {
				rowToSearch = i;break;
			}
		}

		if(rowToSearch == -1) return false;

		for(int j=0;j<columns;j++) {
			if(target == matrix[rowToSearch][j]) return true;
		}

		return false;
	}
}

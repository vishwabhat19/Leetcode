package com.solutions;

import java.util.Stack;

/*
832. Flipping an Image
 */
public class FlipImage
{
	public static void main(String[] args)
	{
		int matrix[][] = {{1,1,0},{1,0,1},{0,0,0}};
		int[][] result = flipAndInvertImage(matrix);
		for(int i=0;i<result[0].length;i++) {
			for(int j=0;j<result.length;j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}

	static public int[][] flipAndInvertImage(int[][] image) {
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<image.length;i++) {
			for(int j=0;j<image[0].length;j++) {
				stack.push(image[i][j]);
			}
			for(int j=0;j<image[0].length;j++) {
				int temp = stack.pop();
				if(temp==0) image[i][j] = 1;
				else image[i][j] = 0;
			}

		}

		return image;
	}
}

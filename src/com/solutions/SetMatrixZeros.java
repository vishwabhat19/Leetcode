package com.solutions;

/*73. Set Matrix Zeroes*/

public class SetMatrixZeros
{
	public static void main(String[] args)
	{
		int matrix[][] = {{1,1,1},{1,0,1},{1,1,1}};
		setZeros(matrix);
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}

	public static void setZeroes(int[][] matrix) {
		int maxRow = matrix.length;
		int maxCol = matrix[0].length;
		boolean visited[][] = new boolean[maxRow][maxCol];

		for(int i=0;i<maxRow;i++) {
			for(int j=0;j<maxCol;j++) {
				if(matrix[i][j] == 0 && !visited[i][j]) {
					setRowZeros(matrix, i, maxCol, visited);
					setColZeros(matrix, j, maxRow, visited);
				}
			}
		}
	}


	public static void setRowZeros(int[][] matrix, int currentRow, int maxColumn, boolean [][] visited) {
		for(int i=0;i<maxColumn;i++) {
			if(matrix[currentRow][i] != 0) {
				matrix[currentRow][i] = 0;
				visited[currentRow][i] = true;
			}

		}
	}

	public static void setColZeros(int[][] matrix, int currentColumn, int maxRow, boolean visited[][]) {
		for(int i=0;i<maxRow;i++) {
			if(matrix[i][currentColumn] != 0) {
				matrix[i][currentColumn] = 0;
				visited[i][currentColumn] = true;
			}

		}
	}
}

package com.solutions;

/*
200. Number of Islands
 */
public class NumberOfIslands
{
	public static void main(String[] args)
	{
		char[][] grid = {{'1','1','1','1','0'}, {'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
		System.out.println(numIslands(grid));
	}

	static int numIslands(char[][] grid) {
		int count =0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j] == '1') {
					count++;
					explore(grid,i,j);
				}
			}
		}
		return count;
	}

	public static void explore(char[][] grid, int i,int j) {
		if(i<0 || i>grid.length || j<0 || j>grid[0].length || grid[i][j]!='1') return;

		grid[i][j] = 0;

		explore(grid,i+1,j);
		explore(grid,i-1,j);
		explore(grid,i,j+1);
		explore(grid,i,j-1);
	}
}

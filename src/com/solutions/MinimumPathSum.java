package com.solutions;

/*
64. Minimum Path Sum
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum
{
	public static void main(String[] args)
	{
		int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(minPathSum(grid));
	}

	public static int minPathSum(int[][] grid) {
		int dp[][] = new int[grid.length][grid[0].length];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				dp[i][j] += grid[i][j];
				if(i>0 && j>0) {
					dp[i][j]+=Math.min(dp[i-1][j],dp[i][j-1]);
				}
				else if(i>0) {
					dp[i][j]+=dp[i-1][j];
				}
				else if(j>0) {
					dp[i][j]+=dp[i][j-1];
				}
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}
}

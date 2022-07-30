package com.solutions;

/*
62. Unique Paths
 */
public class UniquePaths
{
	public static void main(String[] args)
	{
		int m=3, n=7;
		System.out.println(uniquePaths(m,n));
	}

	public static int uniquePaths(int m, int n) {
		int dp[][] = new int[m][n];

		//Fill the first row with 1
		for(int i=0;i<dp[0].length;i++)
			dp[0][i] = 1;

		//Fill the first column with 1
		for(int j=0;j<dp.length;j++)
			dp[j][0] = 1;

		//Fill up the dp array
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				/*
				The number of ways to return each square will be calculated by the number of ways
				to reach the square to the left of it plus the number of ways to reach the square
				above it since those two are the only ways to reach a square.
				A square can only be reached from above it or from the left of it.
				 */
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}

		return dp[m-1][n-1];
	}
}

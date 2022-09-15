package com.solutions;

import java.util.ArrayList;
import java.util.Arrays;

/*
56. Merge Intervals
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {

    public static void main(String[] args) {
        int intervals[][] = {{1,3}, {2,6}, {8,10}, {15,18}};
        int result[][] = merge(intervals);
        for(int i=0;i<result.length;i++) {
            for(int j=0;j<2;j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        ArrayList<int[]> result = new ArrayList<>();
        int prev[] = intervals[0];
        int counter = 0;
        for(int i=1;i<intervals.length;i++) {
            if(prev[1] > intervals[i][0]) {
                //This means that there is an overlap
                /*
                To merge we need to remove prev[1] and current[0]
                 */
                int temp[] = new int[2];
                temp[0] = prev[0];
                temp[1] = intervals[i][1];
                result.add(temp);
                prev = temp;
            }
            else {
                //There is no overlap
                int temp[] = new int[2];
                temp[0] = intervals[i][0];
                temp[1] = intervals[i][1];
                result.add(temp);
                prev = intervals[i];
            }
        }
        int resultArr[][] = new int[result.size()][2];
        int count = 0;
       for(int[] arr : result) {
           resultArr[count][0] = arr[0];
           resultArr[count][1] = arr[1];
           count++;
       }
       return resultArr;

    }
}

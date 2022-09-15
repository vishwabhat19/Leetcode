package com.solutions;

import java.util.Arrays;

/*
Given an array of intervals where intervals[i] = [starti, endi],
return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.

 */
public class NonOverlappingIntervals {

    public static void main(String[] args) {
        int intervals[][] = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println("Count is :"+eraseOverlapIntervals(intervals));

    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0 || intervals[0].length == 0)
            return 0;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int count = 0;
        int[] prev = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            if(prev[1] > intervals[i][0]) {
                //There is overlapping
                count++;
                if(prev[1] > intervals[i][1]) {
                    //This means prev interval is larger than the current interval
                    //The prev interval is ending at a later stage than the current interval
                    //So we just ignore that interval and take the smaller interval
                    //as the prev interval now.
                    //Effectively we are removing the larger interval and only
                    //Considering the smaller interval
                    prev = intervals[i];
                }
            }
            else {
                prev = intervals[i];
            }
        }
        return count;
    }
}

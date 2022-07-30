package com.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmilGroup
{
	public static void main(String[] args)
	{
		List<Integer> A = Arrays.asList(new Integer[]{1,2,3,4});
		int N = 4;
		int K = 2;
		int D = 1;
		System.out.println(MaxSkillLevel(N,K,D,A));
	}

	public static int MaxSkillLevel(int N, int K, int D, List<Integer> A) {
		List<List<Integer>> resultList = new ArrayList<>();
		Integer arr[] = A.toArray(new Integer[0]);
		Arrays.sort(arr);


		List<Integer> tempList = new ArrayList<>();
		tempList.add(arr[0]);
		int lowestIndexInCurrentGroup = arr[0];
		for(int i=1;i<N && resultList.size()<=K;i++) {
			if(arr[i]-lowestIndexInCurrentGroup <= D) {
				tempList.add(arr[i]);
				if(i+1>=N) {
					resultList.add(tempList);
				}
			}
			else {
				//Time to make a new group
				resultList.add(tempList);
				tempList = new ArrayList<>();
				tempList.add(arr[i]);
				lowestIndexInCurrentGroup = arr[i];
				if(i+1>=N) {
					resultList.add(tempList);
				}
			}
		}
		int sum = 0;
		for(List<Integer> tempoList : resultList) {
			sum+=tempoList.get(tempoList.size()-1);
		}
		return sum;
	}
}

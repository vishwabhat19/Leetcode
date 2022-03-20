package com.solutions;

public class SearchInsert {

	public static void main(String[] args) {

		int []nums = {1,3,5,6};
		
		System.out.println(searchInsert(nums, 4));
	}
	
	static int searchInsert(int nums[], int target) {
		
		int index = 0;
		if(target > nums[nums.length-1]) return nums.length;
		else if(target < nums[0]) return 0;
		else {
			int start = 0, end = nums.length;
			int mid = 0;
			while(start<end) {
				mid = (end+start)/2;
				if(target == nums[mid]) {
					index = mid;
					break;
				}
				if(target<nums[mid]) {
					//Ignore the second half
					end = mid-1;
				}
				else if(target > nums[mid]) {
					//Ignore the first half
					start = mid+1;
				}
			}
		}
		return index;
	}

}

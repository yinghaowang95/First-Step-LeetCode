package com.wyh.leetcode27;
//时间复杂度O(n)
//空间复杂度O(1)
//运用了双指针的思想

public class Solution {
    public int removeElement(int[] nums, int val) {
    	int j=-1;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=val)
				swap(nums,++j,i);
		}
		return j+1;	
	}
public static void swap(int[] arr,int i,int j) {
	int temp=arr[i];
	arr[i]=arr[j];
	arr[j]=temp;
}
	public static void main(String[] args) {
		int[] arr= {0,1,2,2,3,0,4,2};
		System.out.print(new Solution().removeElement(arr, 2));
	}
}

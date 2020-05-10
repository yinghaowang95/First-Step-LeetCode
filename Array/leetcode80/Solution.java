package com.wyh.leetcode80;
/**
 * 双指针法
 * */
public class Solution {
	public int removeDuplicates(int[] nums) {
		if(nums.length==0)
			return 0;
		int j=-1;
		int x=nums[0];
		int cout=0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==x) {
				if(cout<2) {
					j++;
					nums[j]=x;
					cout++;
				}
			}
			else {
				j++;
				x=nums[i];
				nums[j]=x;
				cout=1;
			}
		}
		return j+1;
	}
	public static void main(String[] args) {
		int[] arr= {1,1,1,2,2,3};
		System.out.print(new Solution().removeDuplicates(arr));
	}
}

package com.wyh.leetcode209;
//优化算法，使用滑动窗口
//时间复杂度:O(n)
//空间复杂度O(1)
public class Solution {
	public int minSubArrayLen(int s, int[] nums) {
		int l=0;
		int r=-1;
		int sum=0;
		int res=nums.length+1;
		while(l<nums.length) {
			if(r+1<nums.length && sum<s)
				sum+=nums[++r];
			else
				sum-=nums[l++];
			if(sum>=s)
				res=Math.min(res, r-l+1);
		}
		if(res==nums.length+1)
			return 0;
		return res;
}
	
	public static void main(String[] args) {
		int[] arr= {2,3,1,2,4,3};
		System.out.print(new Solution().minSubArrayLen(7, arr));
	}
}

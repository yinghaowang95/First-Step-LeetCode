package com.wyh.leetcode209;
//暴力解法，会超时
//时间复杂度O(n^3)
//空间复杂度O(1)
public class Solution0 {
	public int minSubArrayLen(int s, int[] nums) {
		int res=nums.length+1;
		for(int l=0;l<nums.length;l++)
			for(int r=l;r<nums.length;r++) {
				int sum=0;
				for(int k=l;k<=r;k++) 
					sum+=nums[k];
				
				if(sum>=s)
					res=Math.min(res, r-l+1);
			}
		if(res == nums.length + 1)
            return 0;
		return res;
	}
	public static void main(String[] args) {
		int[] arr= {2,3,1,2,4,3};
		System.out.print(new Solution0().minSubArrayLen(7, arr));
	}
}

package com.wyh.leetcode11;
/**
 * 对撞指针
 * */
public class Solution {
	public int maxArea(int[] height) {
		if(height.length<1)
			return 0;
		int l=0,r=height.length-1;
		int res=0;
		while(l<r) {
			if(height[l]<height[r]) {
				res=Math.max(res, height[l]*(r-l));
				l++;
			}
			else {
				res=Math.max(res, height[r]*(r-l));
				r--;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int[] arr= {1,8,6,2,5,4,8,3,7};
		System.out.print(new Solution().maxArea(arr));
	}
}

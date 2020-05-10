package com.wyh.leetcode283;
/**
 * 优化算法1:
 * 设置j索引指向数组第一个数，i比遍历，如果非零，将i索引的数挪到j，j++，遍历结束后，j后面的索引的数全部置0*/
//时间复杂度: O(n)
//空间复杂度: O(1),没有使用任何额外的空间
public class Solution1 {
	public static void moveZeroes(int[] nums) {
		int j=0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=0) {
				nums[j]=nums[i];
				j++;
			}
		}
		for(int i=j;i<nums.length;i++)
			nums[i]=0;
	}
	public static void main(String[] args) {
		int[] arr= {0,1,0,3,12};
		moveZeroes(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
			System.out.print(' ');
		}
	}
}

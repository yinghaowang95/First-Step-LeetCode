package com.wyh.leetcode283;
/**
 * 优化算法2，进行数据交换操作
 * */
public class Solution2 {
	private static void swap(int[] arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void moveZeroes(int[] nums) {
		int j=0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=0) {
					if(i!=j) {//为了排除数组中全都是非零元素，自己和自己交换一遍
					swap(nums,j,i);
					j++;
				}
					else {//i==k=0
						j++;
					}
			}
			
		}
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

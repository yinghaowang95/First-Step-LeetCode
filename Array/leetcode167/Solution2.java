package com.wyh.leetcode167;

import java.util.Arrays;
//O(n)
//O(1)
public class Solution2 {
	public int[] twoSum(int[] numbers, int target) {
		assert numbers.length>=2;
		int l=0,r=numbers.length-1;
		int[] sum= {0,0};
		while(l<r) {
			if(numbers[l]+numbers[r]==target) {
				sum[0]=l+1;
				sum[1]=r+1;
				return sum;
			}
			else if(numbers[l]+numbers[r]<target) {
				l++;
			}
			else
				r--;	
		}
		//return new int[]{};
		throw new IllegalStateException("The input has no solution");
	}
	private static void printSum(int[]arr) {
		for(int i:arr) {
			System.out.print(i);
			System.out.print(' ');
		}
	}
	public static void main(String[] args) {
		int[] arr= {5,25,75};
		printSum(new Solution2().twoSum(arr, 100));
		
		
	}
}

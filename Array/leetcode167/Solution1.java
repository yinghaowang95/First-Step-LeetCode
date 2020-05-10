package com.wyh.leetcode167;

public class Solution1 {
	public int[] twoSum(int[] numbers, int target) {
		assert numbers.length>=2;
		int[] sum= {0,0};
		for(int i=0;i<numbers.length;i++) {
			int t=target-numbers[i];
			int l=i+1;
			int r=numbers.length-1;
			int f=binarySearch(numbers,l,r,t);
			if(f !=-1) {//这里注意，如果开始不是目标数字对应的索引，就会返回-1，存入，这里要将其排除
			sum[0]=i+1;
			sum[1]=f+1;
			return sum;
			}
			
		}	
		return new int[] {};
	}
	private static int binarySearch(int[] arr,int l,int r,int target) {
		assert l>=0 && l<arr.length;
		assert r>=0 && r<arr.length;
		while(l<=r) {
			int mid=l+(r-l)/2;
			
				if(arr[mid]==target)return mid;
				else if(target<arr[mid])
					r=mid-1;
				else
					l=mid+1;
		}
		return -1;
	}
	private static void printSum(int[]arr) {
		for(int i:arr) {
			System.out.print(i);
			System.out.print(' ');
		}
	}
	public static void main(String[] args) {
		int[] arr= {5,25,75};
		printSum(new Solution1().twoSum(arr,100));
	}
}

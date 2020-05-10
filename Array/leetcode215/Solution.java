package com.wyh.leetcode215;

import java.util.Arrays;
/**利用排序，在返回所在索引的值，排序可以为任何排序算法，这里运用双路快排O(nlogn)较慢*/
public class Solution {
	public int findKthLargest(int[] nums, int k) {
		int n=nums.length;
		sort(nums,0,n-1);
		return nums[n-k];
	}
	private static void sort(int[] arr,int l,int r) {
		if(l>=r)
			return ;
		int p=partition(arr,l,r);
		sort(arr,l,p-1);
		sort(arr,p+1,r);
	}
	private static int partition(int[] arr,int l,int r) {
		swap(arr,l,(int)(Math.random()*(r-l+1))+l);
		int v=arr[l];
		
		int i=l+1;
		int j=r;
		
		while(true) {
			while(i<=r && arr[i]<v) i++;
			while(j>=l+1 && arr[j]>v) j--;
			if(i>j)break;
			swap(arr,i,j);
			i++;
			j--;	
		}
		swap(arr,l,j);
		return j;
		
	}
	private static void swap(int[] arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void main(String[] args) {
		int[] arr= {3,2,3,1,2,4,5,5,6};
		System.out.print(new Solution().findKthLargest(arr, 2));
	}
}

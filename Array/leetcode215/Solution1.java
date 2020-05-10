package com.wyh.leetcode215;
/**
 * 运用快速选择的方法，此方法基于快速排序思想，但是时间复杂度为O(n)
 * 空间复杂度为O(logn)*/
public class Solution1 {
	public int findKthLargest(int[] nums, int k) {
		int n=nums.length;
		return findKthLargest(nums,0,n-1,k-1);
	}
	private static int findKthLargest(int[]arr,int l,int r,int k) {
		if(l==r)
			return arr[l];
		int p=partition(arr,l,r);
		if(p==k)
			return arr[p];
		else if(k<p)
			return findKthLargest(arr,l,p-1,k);
		else
			return findKthLargest(arr,p+1,r,k);
	}
	private static int partition(int[] arr,int l,int r) {
		int j=l;
		swap(arr,l,(int)(Math.random()*(r-l+1)+l));//这里注意要加的是l，应为起始条件是l...r
		int v=arr[l];
		for(int i=l+1;i<=r;i++) {//这里要注意循环终止条件
			if(arr[i]>v)
				swap(arr,++j,i);
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
		System.out.print(new Solution1().findKthLargest(arr, 4));
				
	}
}

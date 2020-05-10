package com.wyh.leetcode75;

public class Solution {
	private static void swap(int[] arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	private static void sort(int[] arr,int l,int r) {
		if(l>r) {
			return;
		}
		int v=arr[l];
		int zero=l;
		int two=r+1;
		int i=l+1;
		
		while(i<two) {//这里原来写错了，写成了i<r
			if(arr[i]<v) {
				swap(arr,i,zero+1);
				zero++;
				i++;
			}
			else if(arr[i]>v) {
				swap(arr,i,two-1);
				two--;
			}
			else {
				i++;
			}
		}
		swap(arr,l,zero);
		sort(arr,l,zero-1);
		sort(arr,two,r);
	}
	public static void sortColors(int[] nums) {
		int n=nums.length;
		sort(nums,0,n-1);
	}
	public static void main(String[] args) {
		int[] arr= {2,0,1,0,2,1};
		sortColors(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
			System.out.print(' ');
		}
	}
}

package com.wyh.leetcode88;

import java.util.Arrays;

//运用归并排序,自己写的
public class Solution {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		for(int i=m;i<nums1.length;i++)
			nums1[i]=nums2[i-m];
		
		sort(nums1,0,nums1.length-1);
	}
	private static void sort(int[] arr,int l,int r) {
		if(l>=r)
			return ;
		int mid=l+(r-l)/2;
		sort(arr,l,mid);
		sort(arr,mid+1,r);
		if(arr[mid]>arr[mid+1])
			merge(arr,l,mid,r);
	}
	private static void merge(int[] arr,int l,int mid,int r) {
		int[] aux=Arrays.copyOfRange(arr, l, r+1);
		int i=l;
		int j=mid+1;
		for(int k=l;k<=r;k++) {
			if(i>mid) {
				arr[k]=aux[j-l];j++;
			}
			else if(j>r) {
				arr[k]=aux[i-l];i++;
			}
			else if(aux[i-l]<aux[j-l]) {
				arr[k]=aux[i-l];i++;
			}
			else {
				arr[k]=aux[j-l];j++;
			}
		}
	}
	
}

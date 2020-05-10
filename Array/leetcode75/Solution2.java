package com.wyh.leetcode75;
//O(n)
//O(1)
public class Solution2 {
	private static void swap(int[]arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void sortColors(int[] nums) {
		int zero=-1;
		int two=nums.length;
		for(int i=0;i<two;) {
			if(nums[i]==0) {
				//zero++;
				swap(nums,zero+1,i);
				zero++;
				i++;
			}
			else if(nums[i]==2) {
				two--;
				swap(nums,i,two);
			}
			else
				i++;		
		}
	}
	public static void main(String[] args) {
		int[] arr= {1,2,0,1,2,0};
		sortColors(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
			System.out.print(' ');
		}
	}
			
}

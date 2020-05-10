package com.wyh.leetcode167;

import java.util.ArrayList;
//暴力解法，O(n^2) 
public class Solution {
	public int[] twoSum(int[] numbers, int target) {
		assert numbers.length>=2;
		int[] sum=new int[2];
		for(int i=0;i<numbers.length;i++)
            for(int j=i+1;j<numbers.length;j++)
                if(numbers[i]+numbers[j]==target) {
                	if(i>j) {
                		sum[0]=j+1;
                		sum[1]=i+1;
                	}
                	else {
                		sum[0]=i+1;
                		sum[1]=j+1;
                	}
               }
       return sum;
        
	}
	private static void printSum(int[] arr) {
		for(int i:arr) {
			System.out.print(i);
			System.out.print(' ');
		}
	}
	private static boolean isSorted(int[] numbers){
        for(int i = 1 ; i < numbers.length ; i ++)
            if(numbers[i] < numbers[i-1])
                return false;
        return true;
    }
	public static void main(String[] args) {
		int[] arr= {2,7,11,5};
		printSum((new Solution()).twoSum(arr,9));
		
		
	}

}

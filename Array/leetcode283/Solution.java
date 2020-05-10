package com.wyh.leetcode283;

import java.util.ArrayList;
import java.util.Vector;
//时间复杂度:O(n)
//空间复杂度:O(n)
public class Solution {
	public static void moveZeroes(int[] nums) {
		/*
        ArrayList<Integer> array=new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
        	if(nums[i]!=0)
        		array.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++) {
        	if(i<array.size())
        		nums[i]=array.get(i);
        	else
        		nums[i]=0;
        }
       */
		Vector<Integer> vector=new Vector<>();
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=0)
				vector.add(nums[i]);
		}
		for(int i=0;i<nums.length;i++) {
			if(i<vector.size())
				nums[i]=vector.elementAt(i);
			else
				nums[i]=0;
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

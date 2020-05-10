package com.leetcode1;

import java.util.Arrays;
import java.util.HashMap;

/**
 * using one-pass hashtable
 * time complexity:O(n)
 * space complexity:O(n)
 * */

public class Solution {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			int t=target-nums[i];
			if(map.containsKey(t)) {
				int[] res= {map.get(t),i};
				return res;
			}
			map.put(nums[i],i);
		}
		throw new IllegalArgumentException("error");
	}
	public static void main(String[] args) {
		int[] nums= {1,2,1,7,11,15};
		int target=9;
		System.out.print(Arrays.toString(new Solution().twoSum(nums, target)));
	}
}

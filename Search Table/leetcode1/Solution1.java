package com.leetcode1;

import java.util.Arrays;
import java.util.HashMap;

/**two-pass hashtable
 * time complexity: O(n)
 * space complexity: O(n)
 * */
public class Solution1 {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<nums.length;i++)
			map.put(nums[i], i);
		
		for(int i=0;i<nums.length;i++){
			int t=target-nums[i];
			if(map.containsKey(t) && map.get(t)!=i){
				int[] res= {map.get(t),i};
				return res;
			}	
		}
		throw new IllegalArgumentException("can not find target");
	}
	public static void main(String[] args) {
		int[] nums= {1,2,1,7,11,15};
		int target=9;
		System.out.print(Arrays.toString(new Solution().twoSum(nums, target)));
	}
}

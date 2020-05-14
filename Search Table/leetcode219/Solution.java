package com.leetcode219;

import java.util.HashSet;
/**
 * 特殊滑动窗口(只需要记录长度值并且判断)+hashset
 *时间复杂度:O(n)
 *空间复杂度:O(k) */
public class Solution {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length==0 || nums.length<=1)
            return false;
        if(k<=0)
            return false;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            //保持set中最多有k个元素
            if(set.size()==k+1)
                set.remove(nums[i-k]);
        }
        return false;
    }
	public static void main(String[] args) {
		int k=1;
		int[] nums= {1,0,1,1};
		System.out.print(new Solution().containsNearbyDuplicate(nums, k));
			
	}
}

package com.wyh.leetcode198;
/**
 * Dynamic Programming
 * time complexity:O(n*2)
 * space complexity:O(n)
 * */
public class Solution2 {
    public int rob(int[] nums) {
        
        int n = nums.length;
        if(n == 0)
            return 0;
        int[] memo = new int[n];
        memo[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i --)
            for(int j = i; j <= n - 1; j ++)
                memo[i] = Math.max(memo[i], nums[j] + (j + 2 < n ? memo[j + 2] : 0));
        return memo[0];
    }
}

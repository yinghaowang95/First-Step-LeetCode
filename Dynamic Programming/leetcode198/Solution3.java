package com.wyh.leetcode198;
/**
 * Dynamic Programming
 * time complexity:O(n)-->we can also optimize the double loop by delete one loop
 * space complexity:O(n)
 * */
public class Solution3 {
    public int rob(int[] nums) {
        
        int n = nums.length;
        if(n == 0)
            return 0;
        int[] memo = new int[n];//初始化为0
        memo[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i --)
            //for(int j = i; j <= n - 1; j ++)
                memo[i] = Math.max(memo[i + 1], nums[i] + (i + 2 < n ? memo[i + 2] : 0));
        return memo[0];
    }
}

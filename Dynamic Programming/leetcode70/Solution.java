package com.wyh.leetcode70;

import java.util.Arrays;
//记忆话搜索，自顶向下
//time complexity:O(n)
//space complexity:O()
public class Solution {
	private int[] memo;
    public int climbStairs(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return callWays(n);
    }
    private int callWays(int n){
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
//        if(n == 1 || n ==0)
//        	return 1;
        if(memo[n] == -1)
            memo[n] = callWays(n - 1) + callWays(n - 2);
        return memo[n];
    }
}

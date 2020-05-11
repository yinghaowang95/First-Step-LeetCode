package com.wyh.leetcode70;

public class Solution1 {
    public int climbStairs(int n) {
        if(n == 1)
            return 1;//如果memo[]从1 开始，则当n=1的时候会超过数组限制，所以要将其特别考虑，如果从0开始则不需要
        int[] memo = new int[n + 1];
        //Arrays.fill(memo, -1);
        memo[1] = 1;
        memo[2] = 2;
        for(int i = 3; i <= n; i ++)
            memo[i] = memo[i - 1] + memo[i - 2];
        return memo[n];
    }
}

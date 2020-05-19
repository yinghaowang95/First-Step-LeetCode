package com.wyh.leetcode343;
/**dynamic programmeing
 * time complexity:O(n^2)
 * space complexity:O(n)
 * */
public class Solution1 {
    
    public int integerBreak(int n) {
        if(n < 1)
            throw new IllegalArgumentException("n should be greater than 0");
        
        int[] memo = new int[n + 1];
        memo[1] = 1;
        for(int i = 2; i <= n; i ++)
            for(int j = 1; j <= i - 1; j ++)
                memo[i] = max3(memo[i], j * (i - j), j * memo[i - j]);
        
        return memo[n];
    }
    
    private int max3(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }
}

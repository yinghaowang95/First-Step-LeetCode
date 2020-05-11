package com.wyh.leetcode70;
/**Fibonacci Number
 * dp[i] = dp[i - 1] + dp[i - 2]，所以dp[i] 其实就是第i个斐波拉契数
 * time complexity:O(n)
 * space complexity:O(1)
 * */
public class Solution2 {
	public int climbStairs(int n) {
        if(n == 1)
            return 1;
        int first = 1;
        int second = 2;
        for(int i = 3; i <= n; i ++){
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}

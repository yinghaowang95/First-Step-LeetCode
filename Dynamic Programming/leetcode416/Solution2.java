package com.wyh.leetcode416;
/**
 * dynamic programming
 * time complexity:O(n*sum)
 * space complexity:O(sum)
 * */
public class Solution2 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] < 0)
                throw new IllegalArgumentException("error!");
            sum += nums[i];
        }
        if(sum % 2 != 0)
            return false;
        
        int n = nums.length;
        int C = sum / 2;
        
        boolean[] memo = new boolean[C + 1];
        for(int j = 1; j < C + 1; j ++)
            memo[j] = (nums[0] == j);
        
        for(int i = 1; i < n; i ++)
            for(int j = C; j >= nums[i]; j --)
                memo[j] = memo[j] || memo[j - nums[i]];
        return memo[C];
        
    }
    private static void printBool(boolean res) {
    	System.out.print(res ? "True" : "False");
    }
    public static void main(String[] args) {
    	int[] nums1 = {1,5,11,5};
    	printBool(new Solution2().canPartition(nums1));
    }
}

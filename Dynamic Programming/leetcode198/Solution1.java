package com.wyh.leetcode198;
/**
 * Memory Search
 * time complexity:O(n)
 * space complexity:O(n)
 * Note:
 * from the top to the bottom  --> memory search
 * because in this question, we consider the array range as the value
 * so the order for this question is to steal from the total range of the array then shrink to the last one
 * that is the "from cap to bottom"
 * */
import java.util.Arrays;

public class Solution1 {
    
    private int[] memo;
    
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return tryRob(nums, 0);
    }
    private int tryRob(int[] nums, int index){
        if(index >= nums.length)
            return 0;
        
        if(memo[index] != -1)
            return memo[index];
        
        int res = 0;
        for(int i = index; i < nums.length; i ++)
            res = Math.max(res, nums[i] + tryRob(nums, i + 2));
        memo[index] = res;
        return res;
    }
}

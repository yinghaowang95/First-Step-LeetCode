package com.wyh.leetcode416;

import java.util.Arrays;
/**memory search
 * time complexity:O(n * sum/ 2) = O(n * sum)
 * space complexity:O(n * sum/ 2) = O(n * sum)
 * */
public class Solution1 {
    //memo[i][c] 表示使用索引为[0...i](这里是指区域内的剩余元素是否可以充满，即使某个元素使得条件不满足，但是只要一种满足就可以)
	//的这些元素，是否可以完全填充一个容量为c的背包
	//-1表示未计算， 0表示不可以填充， 1表示可以填充
    private int[][] memo;
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] < 0)
                throw new IllegalArgumentException("error!");
            sum += nums[i];
        }
        if(sum % 2 != 0)
            return false;
        
        memo = new int[nums.length][sum / 2 + 1];

        for(int i = 0; i < nums.length; i ++)
            Arrays.fill(memo[i], - 1);
        
        return doPartition(nums, nums.length - 1, sum / 2);
    }
    private boolean doPartition(int[] nums, int index, int sum){
        if(sum == 0)
            return true;
        //the bag is full or no items to fill the bag
        if(index < 0 || sum < 0)
            return false;
        if(memo[index][sum] != -1)
            return memo[index][sum] == 1;
        //剩下的区域只要可以，那么这个位置就可以为true，除非剩下的元素一种组合都没有来满足填满背包，那么就是false
        memo[index][sum] = (doPartition(nums, index - 1, sum) 
                || doPartition(nums, index - 1, sum - nums[index])) ? 1 : 0;
        
        return memo[index][sum] == 1;
    }
}

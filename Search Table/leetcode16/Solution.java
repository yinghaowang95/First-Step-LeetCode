package com.wyh.leetcode16;

import java.util.Arrays;
/**
 * using two pointers
 * time complexity:O(n^2)
 * space complexity:O(1)
 * */
public class Solution {
	public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int res = 0;
        int diff = Integer.MAX_VALUE;
        for(int k = 0; k < nums.length - 2; k++){
            if(k > 0 && nums[k] == nums[k - 1])
                continue;
            int i = k + 1;
            int j = nums.length - 1;
            int curTarget = target - nums[k];
            while(i < j){
                int sum = nums[i] + nums[j];
                if(sum == curTarget)
                    return nums[k] + nums[i] + nums[j];
                else{
                    int curDiff = Math.abs(sum - curTarget);
                    if(curDiff < diff){
                        diff = curDiff;
                        res = sum + nums[k];
                    }
                    else if(sum < curTarget)
                        i++;
                    else
                        j--;
                }
            }
        }
        return res;
    }
	public static void main(String[] args) {
		int[] nums = {0,0,0};
		
		System.out.print(new Solution().threeSumClosest(nums, 1));
	}
}

package com.wyh.leetcode18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**using two pointers, just like leetcode 15 3sum
 * time complexity:O(n^3)
 * space complexity:O(1)
 * */
public class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int k = 0; k < nums.length-3; k++){
        	/**
            if(nums[k] > 0)
                break;
                这里不能这样写，因为-5 -4 -2 -1 0 1 2 3 target=-11，不可
                当target>=0时可以用这个直接跳出
                */
            if(k > 0 && nums[k] == nums[k-1])
                continue;
            for(int m = k + 1; m < nums.length - 2; m++){
            	if(m > k + 1 && nums[m] == nums[m-1])
            		continue;
                int t = target - nums[k] - nums[m];
                int i = m+1;
                int j = nums.length-1;
                while(i < j){
                    int sum = nums[i] + nums[j];
                    if(sum == t){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[k]);
                        list.add(nums[m]);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        res.add(list);
                        i++;
                        while(i < j && nums[i] == nums[i - 1]) i++;
                        j--;
                        while(i < j && nums[j] == nums[j + 1]) j--;
                    }
                    else if(sum < t){
                        i++;
                    }
                    else 
                        j--;
                }
            }
        }
        return res;
    }
	public static void main(String[] args) {
		int[] nums = {1,-2,-5,-4,-3,3,3,5};
		int target = -11;
		System.out.print(new Solution().fourSum(nums, target));
	}
}

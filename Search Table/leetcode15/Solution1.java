package com.wyh.leetcode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**using two pointers & sort
 *time complexity:O(n^2)
 *space complexity:O(1)
 *remind:sort algorithm use O(nlogn) time complexity
 **/
public class Solution1 {
	public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int k=0;k<nums.length-2;k++){
            if(nums[k] > 0)
                break;
            if(k > 0 && nums[k] == nums[k-1])
                continue;
            int target = -nums[k];
            int i=k+1;
            int j=nums.length-1;
            while(i<j){
                int sum = nums[i]+nums[j];
                if(sum == target){
                    res.add(Arrays.asList(nums[k],nums[i],nums[j]));
                    i++;
                    while(i < j && nums[i] == nums[i - 1])
                        i++;
                    j--;
                    while(i < j && nums[j] == nums[j + 1])
                        j--;
                }
                else if(sum < target){
                    i++;
                }
                else 
                    j--;
            }
        }
        return res;
    }
	public static void main(String[] args) {
		int[] nums= {0,0,0};
		System.out.print(new Solution1().threeSum(nums));
	}
}

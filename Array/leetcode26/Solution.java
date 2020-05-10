package com.wyh.leetcode26;

/**
 * 采用双指针法
 * */
public class Solution {
	public int removeDuplicates(int[] nums) {
        if(nums.length==0)
            return 0;
        int j=-1;
        int count=0;
        int x=nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==x){
                if(count<1){
                    nums[++j]=nums[i];
                    count++;
                }
            }
            else{
                x=nums[i];
                nums[++j]=x;
                count=1;
            }
        }
        return j+1;
    }
	public static void main(String[] args) {
		int[] arr= {1,1,1,2,2,3};
		System.out.print(new Solution().removeDuplicates(arr));
	}
}

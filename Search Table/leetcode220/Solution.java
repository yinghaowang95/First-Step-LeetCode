package com.wyh.leetcode220;

import java.util.Set;
import java.util.TreeSet;

public class Solution {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if(nums.length==0 || nums.length<=1)
            return false;
        if(k<=0)
            return false;
        //这里使用treeset因为set底层实现是基于二分搜索树，加入的元素是顺序的，这样方便比较ceil和floor的值
		TreeSet<Long> set =new TreeSet<>();
		for(int i=0;i<nums.length;i++) {
			if(set.floor((long)nums[i]+(long)t)!=null && set.floor((long)nums[i]+(long)t)>=(long)nums[i]-(long)t)
				return true;
			set.add((long)nums[i]);
			//保持set中最多有k个元素
			if(set.size()==k+1)
				set.remove((long)nums[i-k]);
		}
		return false;
	}
}

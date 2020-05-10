package com.wyh.leetcode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
	public List<List<Integer>> threeSum(int[] nums){
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++)
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		
		List<List<Integer>> list=new ArrayList<>();
		if(nums.length<3)
			return list;
		
		if(map.get(0)>=3)
			list.add(Arrays.asList(0,0,0));
		HashSet<Integer> set =new HashSet<>();
		
		for(int i=0;i<nums.length;i++)
			set.add(nums[i]);
		int[] res=new int[set.size()];
		return list;
		
		
	}
}

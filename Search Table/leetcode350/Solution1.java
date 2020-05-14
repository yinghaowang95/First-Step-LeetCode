package com.leetcode350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * This is the question which use hashmap
 * the time complexity is O(n)
 * the space complexity is O(n)
 * */
public class Solution1 {
	public int[] intersect(int[] nums1,int[] nums2) {
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int num:nums1) {
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		List<Integer> list=new ArrayList<>();
		for(int num:nums2) {
			if(map.containsKey(num)) {
				list.add(num);
				map.put(num, map.get(num)-1);
				if(map.get(num)==0)
					map.remove(num);
			}
		}
		int[] res=new int[list.size()];
		Iterator<Integer> ite=list.iterator();
		int k=0;
		while(ite.hasNext()) {
			res[k]=ite.next();
			k++;
		}
		return res;
	}
	public static void main(String[] args) {
		int[] nums1= {1,2,2,3};
		int[] nums2= {2,2};
		System.out.print(Arrays.toString(new Solution1().intersect(nums1, nums2)));
		
	}
}

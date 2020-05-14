package com.leetcode349;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

//时间复杂度//O(n)
//空间复杂度O(n)
/**运用hashset方法，提高了时间复杂度*/

public class Solution {
	//O(n)
	public int[] intersection(int[] nums1,int[] nums2) {
		HashSet<Integer> set=new HashSet<>();
		for(int num:nums1)
			set.add(num);
		//O(n)
		ArrayList<Integer> list=new ArrayList<>();
		for(int num:nums2) {
			if(set.contains(num)) {
				list.add(num);
				set.remove(num);
			}
		}
		int[] res=new int[list.size()];
		/*
		Iterator<Integer> ite=list.iterator();
		int k=0;
		while(ite.hasNext()) {
			res[k]=ite.next();
			k++;
		}
		return res;
		*/
		for(int i=0;i<list.size();i++)
			res[i]=list.get(i);
		return res;
	}
}

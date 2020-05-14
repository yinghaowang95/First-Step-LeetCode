package com.leetcode349;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
/**运用set的方法
 * 时间复杂度有所增加
 * 因为map和set的底层实现均为二分搜索树
 * */
//时间复杂度//O(nlogn)
//空间复杂度O(n)
public class Solution1 {
	public int[] intersection(int[] nums1,int[] nums2) {
		Set<Integer> set1=new TreeSet<>();
		Set<Integer> set2=new TreeSet<>();
		//先遍历，再插入O(nlogn)
		for(int i=0;i<nums1.length;i++)
			set1.add(nums1[i]);
		//先查找，再添加O(nlogn)
		for(int i=0;i<nums2.length;i++)
			if(set1.contains(nums2[i]))
				set2.add(nums2[i]);
		//O(n)
		Iterator<Integer> ite=set2.iterator();
		int[] res=new int[set2.size()];
		int k=0;
		while(ite.hasNext()) {
			res[k++]=ite.next();
		}
		return res;	
				
	}
}

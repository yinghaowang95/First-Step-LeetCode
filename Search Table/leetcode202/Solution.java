package com.wyh.leetcode202;

import java.util.HashSet;
import java.util.Set;
/**
 * using hashtable
 * time complexity:O(?)
 * space complexity:O(?)
 * */
public class Solution {
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		while(n!=1) {
			n=sum(n);
			if(!set.contains(n))
				set.add(n);
			else
				return false;
		}
		return true;
	}
	private int sum(int n) {
		int res=0;
		while(n!=0) {
			res+=(int) Math.pow(n%10, 2);
			n/=10;
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.print(new Solution().isHappy(2));
	}
}

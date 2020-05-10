package com.wyh.leetcode3;
/**
 * leetcode3 使用滑动窗口
 * */
public class Solution {
	public int lengthOfLongestSubstring(String s) {
		int l=0,r=-1;
		int res=0;
		int[] freq=new int[256];
		while(l<s.length()) {
			if(r+1<s.length() && freq[s.charAt(r+1)]==0)
				freq[s.charAt(++r)]++;
			else
				freq[s.charAt(l++)]--;
			res=Math.max(res, r-l+1);
		}
		if(res==0)
			return 0;
		return res;
	}
	public static void main(String[] args) {
		System.out.println((new Solution()).lengthOfLongestSubstring( "abcabcbb" ));
        System.out.println((new Solution()).lengthOfLongestSubstring( "bbbbb" ));
        System.out.println((new Solution()).lengthOfLongestSubstring( "pwwkew" ));
        System.out.println((new Solution()).lengthOfLongestSubstring( "" ));
	}
}

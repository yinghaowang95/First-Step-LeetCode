package com.wyh.leetcode125;
/**
 * 使用双指针方法，外加正则表达式
 * */
public class Solution {
	public boolean isPalindrome(String s) {
		if(s.length()==0)
			return true;
		
		String str=s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
		int l=0,r=str.length()-1;
		while(l<=r) {
			if(str.charAt(l)==str.charAt(r)) {
				l++;
				r--;
			}
			else
				return false;
				
		}
		return true;
	}
	public static void main(String[] args) {
		String str="A man, a plan, a canal: Panama";
		System.out.print(new Solution().isPalindrome(str));
	}
}

package com.wyh.leetcode125;

public class Solution2 {
	public boolean isPalindrome(String s) {
		if(s.length()==0)
			return true;
		
		String str=s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
		
		for(int i=0;i<str.length()/2;i++) {
			int a=str.charAt(i);
			int b=str.charAt(str.length()-i-1);
			if(str.charAt(i)==str.charAt(str.length()-i-1))
				;
			else
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		String str="A man, a plan, a canal: Panama";
		System.out.print(new Solution2().isPalindrome(str));
	}
}

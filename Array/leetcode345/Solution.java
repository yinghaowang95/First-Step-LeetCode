package com.wyh.leetcode345;

public class Solution {
	public String reverseVowels(String s) {
		char[] c=s.toCharArray();
		int l=0,r=c.length-1;
		while(l<r) {
			while(l<r && isVowel(c,l))
				l++;
			while(l<r && isVowel(c,r))
				r--;
			swap(c,l,r);
			l++;
			r--;
		}
		return new String(c);
	}
	private static void swap(char[] s,int i,int j) {
		char temp=s[i];
		s[i]=s[j];
		s[j]=temp;
	}
	private static boolean isVowel(char[] c,int l) {
		return c[l]!='a' && c[l]!='e' && c[l]!='o' && c[l]!='i' && c[l]!='u' && c[l]!='A' && c[l]!='E' && c[l]!='O' && c[l]!='I' && c[l]!='U';
	}
	public static void main(String[] args) {
		String s="leetcode";
		System.out.print(new Solution().reverseVowels(s));
	}
}

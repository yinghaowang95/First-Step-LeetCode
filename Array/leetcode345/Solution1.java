package com.wyh.leetcode345;

import java.util.HashSet;

public class Solution1 {
	public String reverseVowels(String s) {
		HashSet<Character> set=new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('o');
		set.add('u');
		set.add('i');
		set.add('A');
		set.add('E');
		set.add('O');
		set.add('U');
		set.add('I');
		
		int l=0,r=s.length()-1;
		char[] c=s.toCharArray();
		while(l<r) {
			while(l<r && !set.contains(c[l]))
				l++;
			while(l<r && !set.contains(c[r]))
				r--;
			if(l!=r)
				swap(c,l,r);
			l++;
			r--;
		}
		return s.valueOf(c);
	}
	private static void swap(char[] arr,int i,int j) {
		char temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}

package com.wyh.leetcode242;

import java.util.HashMap;

public class Solution {
public boolean isAnagram(String s, String t) {
		
		HashMap<Character,Integer> map = new HashMap<>();
		
		for(int i=0;i<s.length();i++) {
			char a=s.charAt(i);
			map.put(a, map.getOrDefault(a, 0)+1);
		}
		
		for(int i=0;i<t.length();i++) {
			char c=t.charAt(i);
			if(map.containsKey(c)){
				map.put(c, map.getOrDefault(c, 0)-1);
				if(map.get(c)==0)
					map.remove(c);
			}
		}
		if(map.size()==0 && t.length()==s.length())
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		String s="ab";
		String t="bb";
		System.out.print(new Solution().isAnagram(s, t));
		
	}
}

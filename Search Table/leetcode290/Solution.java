package com.wyh.leetcode290;

import java.util.HashMap;
/**
 * using hashtable
 * time complexity:O(n)
 * space complexity:O(n)
 * */
public class Solution {
	public boolean wordPattern(String pattern, String str) {
		
		String[] words=str.split(" ");
		if(pattern.length()!=words.length)
			return false;
		HashMap<Character,String> map = new HashMap<>();
		for(int i=0;i<pattern.length();i++) {
			if(map.containsKey(pattern.charAt(i))) {
				if(!map.get(pattern.charAt(i)).equals(words[i]))
					return false;
			}
			else
				map.put(pattern.charAt(i), words[i]);
		}
		
		HashMap<String,Character> map1 = new HashMap<>();
		for(int i=0;i<words.length;i++) {
			if(map1.containsKey(words[i])) {
				if(!map1.get(words[i]).equals(pattern.charAt(i)))
					return false;
			}
			else
				map1.put(words[i], pattern.charAt(i));
		}
		return true;
	}
	public static void main(String[] args) {
		String pattern="aabb";
		String str="dog dog cat cat";
		System.out.print(new Solution().wordPattern(pattern, str));
	}
}

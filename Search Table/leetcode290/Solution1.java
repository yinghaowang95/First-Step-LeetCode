package com.wyh.leetcode290;

import java.util.HashMap;
/**using hashtable
 * time complexity:O(n)
 * space complexity:O(n)
 * */
public class Solution1 {
	public boolean wordPattern(String pattern, String str) {
		
		String[] s=str.split(" ");
		if(pattern.length()!=s.length)
			return false;
		HashMap<Character,String> map1=new HashMap<>();
		HashMap<String,Character> map2=new HashMap<>();
		
		for(int i=0;i<pattern.length();i++) {
			if(!map1.containsKey(pattern.charAt(i))) {
				if(map2.containsKey(s[i]))
					return false;
				map1.put(pattern.charAt(i), s[i]);
				map2.put(s[i], pattern.charAt(i));
			}
			else {
				String str1=map1.get(pattern.charAt(i));
				if(!str1.equals(s[i]))
					return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		String pattern="aa";
		String str="dog dog";
		System.out.print(new Solution1().wordPattern(pattern, str));
	}
}

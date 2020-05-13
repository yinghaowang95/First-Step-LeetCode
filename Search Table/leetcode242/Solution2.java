package com.wyh.leetcode242;
/**using hashtable
 * time complexity:O(n)
 * space complexity:O(26)
 * */
public class Solution2 {
	public boolean isAnagram(String s, String t) {
		if(s.length()!=t.length())
			return false;
		
		int[] freq=new int[26];
		for(int i=0;i<s.length();i++) {
			freq[s.charAt(i)-'a']++;
			freq[t.charAt(i)-'a']--;
		}
		for(int i=0;i<freq.length;i++)
			if(freq[i]!=0)
				return false;
		return true;
		
	}
	public static void main(String[] args) {
		String s="";
		String t="";
		System.out.print(new Solution2().isAnagram(s, t));
	}
}

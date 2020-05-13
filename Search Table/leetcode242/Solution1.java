package com.wyh.leetcode242;
/**using hashtable
 * time complexity:O(n)
 * space complexity:O(26)
 * */
public class Solution1 {
	public boolean isAnagram(String s, String t) {
		
        if(s.length()!=t.length())
            return false;
        
		int[] freq=new int[26];
        for(int i=0;i<s.length();i++)
            freq[s.charAt(i)-'a']++;
        
        for(int i=0;i<t.length();i++){
            freq[t.charAt(i)-'a']--;
            if(freq[t.charAt(i)-'a']<0)
                return false;
        }
        return true;
    }
}

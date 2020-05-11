package com.wyh.leetcode205;

import java.util.HashMap;
/**
 * using hashmap
 * time complexity:O(n)
 * space xomplexity:O(n)
 * */
public class Solution1 {
	public boolean isIsomorphic(String s, String t) {
        
        HashMap<Character,Character> map1 = new HashMap<>();
        HashMap<Character,Character> map2 = new HashMap<>();
        
        for(int i=0;i<t.length();i++){
            if(!map1.containsKey(s.charAt(i))){
                if(map2.containsKey(t.charAt(i)))
                    return false;
                map1.put(s.charAt(i),t.charAt(i));
                map2.put(t.charAt(i),s.charAt(i));
            }
            else{
                char res=t.charAt(i);
                if(!map1.get(s.charAt(i)).equals(res))
                    return false;
            }
        }
        return true;
    }
}

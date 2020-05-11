package com.wyh.leetcode205;

import java.util.HashMap;
/**using hashmap
 * time complexity:O(n)
 * space xomplexity:O(n)*/
public class Solution {
	public boolean isIsomorphic(String s, String t) {
        
        HashMap<Character,Character> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            if(!map.containsKey(s.charAt(i))){
                if(map.containsValue(t.charAt(i))) return false;  
                map.put(s.charAt(i),t.charAt(i));
            }else{
                if(!map.get(s.charAt(i)).equals(t.charAt(i))) return false;                    
            }
        }
        return true;
    }
}

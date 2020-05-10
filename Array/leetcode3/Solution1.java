package com.wyh.leetcode3;

import java.util.HashMap;
import java.util.Map;
/**
 * sliding window+hashmap
 * */
public class Solution1 {
	public int lengthOfLongestSubstring(String s) {
		Map<Character,Integer> map=new HashMap<>();
        int left=0,right=0;
        int res=0;
        
        while(right<s.length()){
            char c1=s.charAt(right);
            map.put(c1, map.getOrDefault(c1, 0)+1);
            right++;
            
            while(map.get(c1)>1) {//如果一旦>1，那么就打破了最长不重复子串，那么就要在每滑动right后返回长度
            	
            	char c2=s.charAt(left);
                map.put(c2,map.get(c2)-1);
                
                left++;
            }
            res=Math.max(res, right-left);
        }
        return res;
    }
	public static void main(String[] args) {
		System.out.print(new Solution1().lengthOfLongestSubstring("djssajdhjjj"));
	}
}

package com.wyh.leetcode49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/**using hashtable
 * the value of hashmap id a list to store every string that match the keys
 * time complexity:O(n* klogk)
 * space complexity:O(n*k)
 * */
public class Solution {
	public List<List<String>> groupAnagrams(String[] strs){
		if(strs.length == 0)
			return new ArrayList();
		HashMap<String,List> map = new HashMap<>();
		for(int i = 0; i < strs.length; i++) {
			char[] ch = strs[i].toCharArray();
			Arrays.sort(ch);			
			String s = String.valueOf(ch);
			if(!map.containsKey(s))
				map.put(s, new ArrayList());
			map.get(s).add(strs[i]);
		}
		return new ArrayList(map.values());
	}
}

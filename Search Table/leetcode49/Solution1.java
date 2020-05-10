package com.wyh.leetcode49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution1 {
	public List<List<String>> groupAnagrams(String[] strs){
		if(strs.length == 0)
			return new ArrayList();
		HashMap<String,List> map = new HashMap<>();
		int[] freq = new int[26];
		for(int i = 0; i < strs.length; i ++) {
			Arrays.fill(freq, 0);
			for(int j = 0; j < strs[i].length(); j ++)
				freq[strs[i].charAt(j) - 'a']++;
			
			StringBuilder res = new StringBuilder();
			for(int k = 0; k < freq.length; k ++) {
				res.append("#");
				res.append(freq[k]);
			}
			String keys = res.toString();
			if(!map.containsKey(keys)) 
				map.put(keys, new ArrayList());
			map.get(keys).add(strs[i]);
			
		}
		return new ArrayList(map.values());
	}
}

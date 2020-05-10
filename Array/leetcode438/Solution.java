package com.wyh.leetcode438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 时间复杂度:O(m+n)
 * 空间复杂度O(m+n)*/
public class Solution {
	/**
	 * 滑动窗口--双指针
	 * 首先右移right指针，使得[left,right]窗口中包含所有的字符串p中的元素，
	 * 如果刚好滑倒在p中的元素，map1中对应键的值+1
	 * 如果map1和map2对应键的值相等，则匹配一次，对应match+1，
	 * 若不相等(例如:滑倒2次a,前一个a已经匹配一次了),right+1
	 * 
	 * 判断：如果此时当前窗口的长度刚好=p的长度，则说明找到了
	 * 
	 * 否则从左边left判断当前字符是否存在于p中:
	 * 			如果不在p中，窗口左移
	 * 			如果存在，则map1对应键的值-1，同时若map1当前键对应的值<map2中的次数，对应的match-1，然后左移
	 * */
	public List<Integer> findAnagrams(String s, String p){
		List<Integer> res=new ArrayList<>();
		if(s==null || s.length()<p.length()) {
			return res;
		}
		
		Map<Character,Integer> map1=new HashMap<>();
		Map<Character,Integer> map2=new HashMap<>();
		//将字符串p中的元素添加到map2中，将值设置为1
		for(int i=0;i<p.length();i++) {
			map2.put(p.charAt(i),map2.getOrDefault(p.charAt(i), 0)+1);
		}
		
		int l=0,r=0;//指向滑动窗口的左右两端
		int match=0;//匹配次数
		
		while(r<s.length()) {
			char c1=s.charAt(r);
			//如果当前字符存在于字符串p中
			if(map2.containsKey(c1)) {
				//就将该元素和对应的次数添加进map1中
				map1.put(c1, map1.getOrDefault(c1, 0)+1);
			//若该元素出现的次数和map2中出现的次数相同，则说明已经匹配完一个字符
			if(map1.get(c1).equals(map2.get(c1)))
				match++;
			}
			r++;
			//如果在当前窗口中，字符已经与p中的元素匹配完，则要去除多余的元素
			//即保证在当前的滑动窗口中，没有多余的字符和重复的字符
			while(match==map2.size()) {
				//如果match和窗口的长度均满足要求，将左端索引left添加到res中
				if(r-l==p.length()) {
					res.add(l);
				}
				//如果不匹配，则判断左边left索引指向的元素
				char c2=s.charAt(l);
				if(map2.containsKey(c2)) {//如果p中包含次元素
					map1.put(c2, map1.get(c2)-1);//则相应的map1中的次数-1
					//如果map1中的次数小于map2中的次数，即向left向右滑动的时候，将所有p中对应的元素一一排除
					if(map1.get(c2)<map2.get(c2))
						match--;//此时结束后会跳到上面的循环，开始判断right指针
				}
				l++;
			}
		}
		return res;
			
	}
	public static void main(String[] args) {
		String s="cbaebabacd";
		String p="abc";
		System.out.print(new Solution().findAnagrams(s, p));
	}
}

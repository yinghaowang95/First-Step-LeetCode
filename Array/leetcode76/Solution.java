package com.wyh.leetcode76;

import java.util.HashMap;
import java.util.Map;
/**
 * 滑动指针模版
 * */
public class Solution {
	/**
	 * 滑动窗口--双指针+哈希表
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
	public String minWindow(String s, String t) {
		
		Map<Character,Integer> map1=new HashMap<>();
		Map<Character,Integer> map2=new HashMap<>();
		//将字符串p中的元素添加到map2中，将值设置为1
		for(int i=0;i<t.length();i++)
			map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0)+1);
		
		int left=0,right=0;//指向滑动窗口的左右两端
		int match=0;//匹配次数
		int minSize=s.length()+1;
		int start=-1;//起始位置这样设置是为了后序的抛出异常方便
		while(right<s.length()) {
			char c1=s.charAt(right);
			if(map2.containsKey(c1)) {
				map1.put(c1, map1.getOrDefault(c1, 0)+1);
				if(map2.get(c1).equals(map1.get(c1)))
					match++;
			}
			right++;
			
			while(match==map2.size()) {
				if(right-left<minSize) {//防止开始就是最小的时候，后面的虽然匹配但是长度不满足造成的start乱跑
					start=left;
					minSize=Math.min(minSize, right-left);
				}
				char c2=s.charAt(left);
				if(map2.containsKey(c2)) {
					map1.put(c2, map1.get(c2)-1);
					if(map1.get(c2)<map2.get(c2))
						match--;
				}
				left++;
			}
		}
		if(start!=-1){
		    return s.substring(start,start+minSize);
        }
        return "";
	}
	public static void main(String[] args) {
		String s="ADOBECODEBANC";
		String t="ABC";
		System.out.print(new Solution().minWindow("asdcc", "asc"));
	}
}

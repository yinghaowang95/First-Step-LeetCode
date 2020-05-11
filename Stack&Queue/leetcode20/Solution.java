package com.wyh.leetcode20;

import java.util.Stack;

public class Solution {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < s.length(); i ++) {
			char c = s.charAt(i);
			if(c == '(' || c == '{' || c == '[')
				stack.push(c);
			else {
				if(stack.size() == 0)
					return false;
				char curCh = stack.pop();
				if(c == ')' && curCh != '(')
					return false;
				if(c == ']' && curCh != '[')
					return false;
				if(c == '}' && curCh != '{')
					return false;
			}	
		}
		return stack.isEmpty();
	}
}

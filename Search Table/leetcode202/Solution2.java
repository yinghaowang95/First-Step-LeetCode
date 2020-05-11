package com.wyh.leetcode202;
/**using slow and fast pointers
 * time complexity:O(?)
 * space complexity:O(?)
 * because if the integer is a happy number,it will have the final sum of 1,
 * so the fast result will finally equals to slow result
 * but if it is not, it will result in dead loop and at some time ,
 * the loop will end in slow==fast
 * return slow==1 will give the final result ture or false;
 * */
public class Solution2 {
	public boolean isHappy(int n) {
		
		int slow=n, fast=n;
		
		do {
		slow = bitSquareSum(slow);
		fast = bitSquareSum(fast);
		fast = bitSquareSum(fast);
		}while(slow!=fast);
		
		return slow==1;
	}
	private int bitSquareSum(int n) {
		int res=0;
		while(n!=0) {
			res+=(int)Math.pow(n%10, 2);
			n/=10;
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.print(new Solution2().isHappy(0));
	}
	
}

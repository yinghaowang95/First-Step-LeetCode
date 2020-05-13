package com.wyh.leetcode454;

import java.util.HashMap;

/**
 * 运用哈希表，将A+B以及C+D集合做处理后分别存入哈希表，设计O(n^2)的解法
 *时间复杂度:O(n^2)
 *空间复杂度:O(n^2) */
public class Solution1 {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		if(A==null || B==null || C==null || D==null)
			throw new IllegalArgumentException("error");
		
		HashMap<Integer,Integer> map1=new HashMap<>();
		for(int i=0;i<A.length;i++)
			for(int j=0;j<B.length;j++) {
				int sum1=A[i]+B[j];
				map1.put(sum1,map1.getOrDefault(sum1,0)+1);
			}
		
		HashMap<Integer,Integer> map2=new HashMap<>();
		for(int i=0;i<C.length;i++)
			for(int j=0;j<D.length;j++) {
				int sum2=C[i]+D[j];
				map2.put(sum2,map2.getOrDefault(sum2,0)+1);
			}
		int res=0;
		for(Integer num:map2.keySet()) {
			if(map1.containsKey(-num)) {
				res+=map1.get(-num)*map2.get(num);
			}
		}
		return res;
	}
}

package com.wyh.leetcode454;

import java.util.HashMap;
/**
 * 运用哈希表，将后面集合做处理后存入，设计O(n^2)的解法
 *时间复杂度:O(n^2)
 *空间复杂度:O(n^2) */
public class Solution {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		if(A==null || B==null || C==null || D==null)
			throw new IllegalArgumentException("error");

		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<C.length;i++)
			for(int j=0;j<D.length;j++)
				map.put(C[i]+D[j], map.getOrDefault(C[i]+D[j], 0)+1);
		int res=0;
		for(int i=0;i<A.length;i++)
			for(int j=0;j<B.length;j++)
				if(map.containsKey(-A[i]-B[j]))
					res+=map.get(-A[i]-B[j]);
		return res;
	}
}

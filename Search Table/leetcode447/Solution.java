package com.wyh.leetcode447;

import java.util.HashMap;

/**in order to circulate the sum of (i,j,k),which i=j & i=k
 * we should find every i and iterator the array to record each element's distance with i;
 * if the amount>=2, it will be okay to generate the relation like that 
 * we are going to use hashmap to solve this problem
 * time complexity: O(n^2)
 * space complexity O(n)
 * */
public class Solution {
	public int numberOfBoomerangs(int[][] points) {
		if(points.length==0)
            return 0;
		int res=0;
		for(int i=0;i<points.length;i++) {
			//对于每一个枢纽点，需要设置一个查找表，因为每一个枢纽点到其他各点的距离可能一样
			//如果设置在最外面，不同枢纽点上到其他个点距离相等的点的总个数就会累加，然而此时的参考点不一样，产生错误
			HashMap<Integer,Integer> map=new HashMap<>();
			for(int j=0;j<points.length;j++) {
				if(i!=j) {
					int d=distance(points[i],points[j]);
					map.put(d, map.getOrDefault(d, 0)+1);
				}
				//对于每一个枢纽点，即时计算配对数目
				for(Integer num:map.keySet())
					if(map.get(num)>=2)
						res+=map.get(num)*(map.get(num)-1);
			}
		}
		return res;
	}
	private int distance(int[] points1,int[] points2) {
		return (points1[0]-points2[0])*(points1[0]-points2[0])+
				(points1[1]-points2[1])*(points1[1]-points2[1]);
	}
}

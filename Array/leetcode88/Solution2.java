package com.wyh.leetcode88;
/**
 * 双指针，从前向后，需要开辟空间
 * O(n+m)
 * O(m)
 * */
public class Solution2 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] arr=new int[m];
		System.arraycopy(nums1, 0, arr, 0, m);
		
		int l=0;
		int r=0;
		for(int i=0;i<m+n;i++) {//考虑到nums1空间>=nums1+nums2，这里循环终止条件必须是m+n，将最后一个0(数组未初始化即未0)排除
			if(r>=n)
				nums1[i]=arr[l++];
			else if(l>=m)
				nums1[i]=nums2[r++];
			else if(arr[l]<nums2[r]) 
				nums1[i]=arr[l++];
			else 
				nums1[i]=nums2[r++];
		}
	}
}

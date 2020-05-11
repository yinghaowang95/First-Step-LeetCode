package com.wyh.leetcode98;
/**using recursive
 * time xomplexity:O(n)
 * space complexity:O(k)--> O(n)
 * 注意要在判断父亲节点和左右子节点的同时，也要注意判断左右节点的边界，单左节点只要 < root.val，单右节点只要 > root.val
 * 左边节点的右边节点: root.val<x<根节点.val  右边节点的左边节点: 根节点.val<x<root.val*/
public class Solution {
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode node, int min, int max){
        if(node == null)
            return true;
        if(node.val < min || node.val > max)
            return false;
        if(node.left != null && node.val <= node.left.val)
            return false;
        if(node.right != null && node.val >= node.right.val)
            return false;
        return isValidBST(node.left, min, node.val - 1) && 
            isValidBST(node.right, node.val + 1, max);
    }
}

package com.wyh.leetcode98;

import java.util.Stack;
/**using non-recursive
 * time complexity:O(n)
 * space complexity:O(k)
 * */
public class Solution1 {
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> upper = new Stack<>();
        Stack<Integer> lower = new Stack<>();
        
        stack.push(root);
        upper.push(Integer.MAX_VALUE);
        lower.push(Integer.MIN_VALUE);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            int right = upper.pop();
            int left = lower.pop();
            
            if(cur.val < left || cur.val > right)
                return false;
            
            if(cur.left != null){
                if(cur.val <= cur.left.val)
                    return false;
                stack.push(cur.left);
                upper.push(cur.val - 1);
                lower.push(left);
            }
            if(cur.right != null){
                if(cur.val >= cur.right.val)
                    return false;
                stack.push(cur.right);
                upper.push(right);
                lower.push(cur.val + 1);
            }
        }
        return true;                   
    }
}

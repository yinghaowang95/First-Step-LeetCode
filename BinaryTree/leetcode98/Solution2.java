package com.wyh.leetcode98;

import java.util.ArrayList;

/**using inorder
 * time complexity:O(n)
 * space complexity:O(k)-->O(n)
 * 使用中序遍历，每一个遍历的节点 < 下一个节点
 * */
public class Solution2 {
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        ArrayList<Integer> res = new ArrayList<>();
        inorderTraversal(root,res);
        for(int i = 1; i < res.size(); i ++)
            if(res.get(i - 1) >= res.get(i))
                return false;
        return true;
    }
    private void inorderTraversal(TreeNode node, ArrayList<Integer> list){
        if(node == null)
            return ;
        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);
    }
}

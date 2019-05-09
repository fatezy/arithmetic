package leetcode.tree;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/5/2  09:20
 */
//Given a binary search first.leetCode.tree, write a function kthSmallest to find the kth smallest element in it.
//
//        Note:
//        You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

//给你一个二叉查找树，找出他倒数第k小的数
//二叉查找树的中根遍历就已经有序
public class KthSmallest_230 {
    List<TreeNode> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        inOrderSearch(root);
        int len  =list.size();
        return list.get(k-1).val;


    }


    public void inOrderSearch(TreeNode root){
        if (root==null)
            return;
        else {
            inOrderSearch(root.left);
            list.add(root);
            inOrderSearch(root.right);
        }

    }
}

package DepthfirstSearch;

import util.TreeNode;

/**
 * author： 张亚飞
 * time：2016/6/6  10:37
 */
//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
    //给你一个有序的数组，转换为高平衡二叉树
public class ConvertSortedArraytoBinarySearchTree_108 {


    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {
            return null;
        }
        TreeNode head = helper(num, 0, num.length - 1);
        return head;
    }

    public TreeNode helper(int[] num, int low, int high) {
        if (low > high) { // Done
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }
}

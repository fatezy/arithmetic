package leetcode.tree;

import leetcode.util.TreeNode;

/**
 * author： 张亚飞
 * time：2016/8/6  21:44
 */
//Given a binary first.leetCode.tree, determine if it is a valid binary search first.leetCode.tree (BST).
//
//        Assume a BST is defined as follows:
//
//        The left subtree of a node contains only nodes with keys less than the node's key.
//        The right subtree of a node contains only nodes with keys greater than the node's key.
//        Both the left and right subtrees must also be binary search trees.
//        Example 1:
//        2
//        / \
//        1   3
//        Binary first.leetCode.tree [2,1,3], return true.
//        Example 2:
//        1
//        / \
//        2   3
//        Binary first.leetCode.tree [1,2,3], return false.
    //判断是不是二叉搜索树
public class ValidateBinarySearchTree_98 {




    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
//错误的解法
//    public static boolean isValidBST(TreeNode root,long min,long max){
//        if (root == null) return true;
//        if (root.left ==  null&&root.right == null&&root.val>min&&root.val<max)
//            return true;
//        if (root.left ==  null&&root.right == null)
//            return false;
//        boolean left = true;
//        boolean right = true;
//        if (root.val<=min||root.val>=max)
//            return false;
//
//        if (root.left.val<root.val) {
//                left = isValidBST(root.left, Long.MIN_VALUE, root.val);
//        }
//
//
//        if (root.right.val>root.val) {
//                right = isValidBST(root.right, root.val, Long.MAX_VALUE);
//        }
//
//        return left&&right;
//    }


    public static boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
       node.right = new TreeNode(15);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(20);
        System.out.println(isValidBST(node));
    }

}

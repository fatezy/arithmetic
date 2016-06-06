package DepthfirstSearch;

import util.TreeNode;

/**
 * author： 张亚飞
 * time：2016/6/4  22:18
 */
//Given a binary tree, find its minimum depth.
//
//        The minimum depth is the number of nodes along the shortest
// path from the root node down to the nearest leaf node.
    //求二叉树的最小深度
    //// TODO: 2016/6/4  
public class MinimumDepthofBinaryTree_111 {
    static int minDepth = Integer.MAX_VALUE;
    public static int minDepth(TreeNode root) {

        return getDepth(root);
    }

    public static int getDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if ((left==0||right==0)&&(left!=0||right!=0))
            return Math.max(left,right)+1;
        return Math.min(left,right)+1;

    }

    public static void main(String[] args) {
        TreeNode tree  = new TreeNode(1);
        tree.left = new TreeNode(2);
       int a = minDepth(tree);
        System.out.println(a);
    }
}

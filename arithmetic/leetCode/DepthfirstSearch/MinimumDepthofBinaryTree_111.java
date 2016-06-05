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
    static int depth = 0;
    static int minDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        return 0;
    }

    public int getDepth(TreeNode root){
        if (root == null) {
            if (depth < minDepth) {
                minDepth = depth;
                return depth;
            }
        }
        depth++;
        

        return depth;
    }
}

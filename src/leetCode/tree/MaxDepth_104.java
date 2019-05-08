package leetCode.tree;

import leetCode.util.TreeNode;

/**
 * Created by zhangyafei on 16-5-1.
 */

//Given a binary first.leetCode.tree, find its maximum depth.
//
//        The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
    //求二叉树的深度
public class MaxDepth_104 {
    public int maxDepth(TreeNode root) {
       if (root == null){
           return 0;
       }
       return Math.max(maxDepth(root.left),maxDepth(root.right))+1 ;
    }

}

package leetCode.tree;

import leetCode.util.TreeNode;

/**
 * Created by 张亚飞 on 2018/1/2.
 */

//Given a binary leetCode.tree, find its maximum depth.
//
//        The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//算出树的最大深度

public class MaximumDepthofBinaryTree_104 {
    public static int maxDepth(TreeNode root) {
        if (root!=null){
            int left = maxDepth(root.left)+1;
            int right = maxDepth(root.right)+1;
           if (left>right) return left;
           else return right;
        }else {
            return 0;
        }

    }
    public static void main(String[] args) {

    }
}

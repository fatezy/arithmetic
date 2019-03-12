package leetCode.DepthfirstSearch;

import leetCode.util.TreeNode;

/**
 * author： 张亚飞
 * time：2016/6/4  19:55
 */
//Given a binary leetCode.tree and a sum, determine if the leetCode.tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
//
//        For example:
//        Given the below binary leetCode.tree and sum = 22,
//        5
//        / \
//        4   8
//        /   / \
//        11  13  4
//        /  \      \
//        7    2      1
//        return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

    //给你一个二叉树，查看是否有从根到叶子节点的路径
    //为目标值
public class PathSum_112 {
    //错误典型，无法递归出去
//    public boolean hasPathSum(TreeNode root, int sum) {
//        if (root == null)
//            return sum==0;
//        else {
//            sum -= root.val;
//            return hasPathSum(root.left,sum);
//            return hasPathSum(root.right,sum);
//        }
//    }


    public boolean hasPathSum(TreeNode root , int sum){
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == sum;
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);

    }
}

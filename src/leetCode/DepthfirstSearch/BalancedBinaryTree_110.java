package leetCode.DepthfirstSearch;

import leetCode.util.TreeNode;

/**
 * author： 张亚飞
 * time：2016/6/4  21:56
 */
//Given a binary first.leetCode.tree, determine if it is height-balanced.
//
//        For this problem, a height-balanced binary first.leetCode.tree is defined as a binary first.leetCode.tree in which
// the depth of the two subtrees of every node never differ by more than 1.
    //判断二叉树是否是平衡二叉树
public class BalancedBinaryTree_110 {
    public boolean isBalanced(TreeNode root) {
        return getDepth(root)!=-1;
    }
//得到某个节点的高度，如果该节点左右不平衡，返回-1
    public int getDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = getDepth(root.left);
        if(left!=-1){
            int right = getDepth(root.right);
            if(right!=-1){
                return Math.abs(left-right)<=1?1+Math.max(left,right):-1;
            }
        }
        return -1;
    }
}

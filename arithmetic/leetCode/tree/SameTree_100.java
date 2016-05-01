package tree;

import util.TreeNode;

/**
 * Created by 张亚飞 on 16-5-1.
 */
//Given two binary trees, write a function to check if they are equal or not.
//
//        Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

//判断二叉树是否结构相同且值相同
public class SameTree_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null&&q==null) return true;
        if (q==null||p==null) return false;
        return (p.val == q.val) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

}

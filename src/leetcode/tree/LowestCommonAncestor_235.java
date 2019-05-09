package leetcode.tree;

import leetcode.util.TreeNode;

/**
 * author： 张亚飞
 * time：2016/5/1  23:27
 */
//Given a binary search first.leetCode.tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
//
//        According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
//
//        _______6______
//        /              \
//        ___2__          ___8__
//        /      \        /      \
//        0      _4       7       9
//        /  \
//        3   5
//        For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
    //找二叉搜索树的共同祖先
     //先序遍历
    //最小的祖先一定大于其中一个小于另外一个
public class LowestCommonAncestor_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val>q.val)
            return lowestCommonAncestor(root, q,p);
        if(root.val>= p.val && root.val<=q.val)
            return root;
        return lowestCommonAncestor(root.val>p.val?root.left:root.right, p,q);
    }
}

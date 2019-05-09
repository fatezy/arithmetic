package leetcode.tree;

import leetcode.util.TreeNode;

/**
 * 作者: 张亚飞
 * 时间: 16-5-1
 */
//Invert a binary first.leetCode.tree.
//
//        4
//        /   \
//        2     7
//        / \   / \
//        1   3 6   9
//        to
//        4
//        /   \
//        7     2
//        / \   / \
//        9   6 3   1
    //二叉树转置
//Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary first.leetCode.tree on a whiteboard so fuck off.
    //转置不了二叉树,滚蛋
public class InvertBinaryTree_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode temp = new TreeNode(0);
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;

    }

}

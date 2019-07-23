package interview;

import leetcode.util.TreeNode;

/**
 * Created by 张亚飞 on 2019/5/9.
 */
public class 翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if (root != null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            invertTree(root.left);
            invertTree(root.right);
    }

        return root;

    }
}

 
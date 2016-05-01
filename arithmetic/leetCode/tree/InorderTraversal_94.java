package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: 张亚飞
 * 时间: 16-5-1
 */
//Given a binary tree, return the inorder traversal of its nodes' values.
//
//        For example:
//        Given binary tree {1,#,2,3},
//        1
//        \
//        2
//        /
//        3
//        return [1,3,2].
    //中序遍历二叉树
public class InorderTraversal_94 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root==null) return list ;
        else {

            inorderTraversal(root.left);
            if (root != null) {
                list.add(root.val);
            }
            inorderTraversal(root.right);
        }

        return list;

    }

}

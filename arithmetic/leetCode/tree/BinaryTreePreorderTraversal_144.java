package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/5/2  10:00
 */
//Given a binary tree, return the preorder traversal of its nodes' values.
//
//        For example:
//        Given binary tree {1,#,2,3},
//        1
//        \
//        2
//        /
//        3
//        return [1,2,3].
    //先根遍历
public class BinaryTreePreorderTraversal_144 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root==null)
            return list;
        else {
            if (root!=null){
                list.add(root.val);
            }
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }

        return list;
    }
}
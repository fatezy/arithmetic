package leetCode.tree;

import leetCode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/5/2  10:08
 */
//Given a binary leetCode.tree, return the postorder traversal of its nodes' values.
//
//        For example:
//        Given binary leetCode.tree {1,#,2,3},
//        1
//        \
//        2
//        /
//        3
//        return [3,2,1].
    //后根遍历
public class BinaryTreePostorderTraversal_145 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return list;
        else {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            list.add(root.val);

        }
        return list;

    }
}

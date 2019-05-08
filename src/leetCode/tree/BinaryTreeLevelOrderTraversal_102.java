package leetCode.tree;

import leetCode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/5/2  10:14
 */
//Given a binary first.leetCode.tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//
//        For example:
//        Given binary first.leetCode.tree {3,9,20,#,#,15,7},
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        return its level order traversal as:
//        [
//        [3],
//        [9,20],
//        [15,7]
//        ]

    //二叉搜索树，层序遍历
    //// TODO: 2016/5/2
public class BinaryTreeLevelOrderTraversal_102 {
    List<List<Integer>> nodes = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return nodes;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size()!=0){
            int size = queue.size();
            List<Integer> layer_vals = new ArrayList<>();
            while (size != 0 ){
                //得到头元素
                TreeNode temp = queue.poll();
                layer_vals.add(temp.val);
                if (temp.left != null) queue.add(temp.left);
                if (temp.right!=null) queue.add(temp.right);
                size--;
            }

            nodes.add(layer_vals);
        }

        return nodes;
    }
}

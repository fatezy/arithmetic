package leetcode.tree;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/5/2  15:45
 */
//Given a binary first.leetCode.tree, return the bottom-up level order traversal of its nodes' values.
// (ie, from left to right, level by level from leaf to root).
    //层序遍历但是是从最后一层向上遍历
public class BinaryTreeLevelOrderTraversalII_107 {
    List<List<Integer>> nodes = new ArrayList<>();
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        levelOrder(root);
        int len = nodes.size();
        for (int i = len-1; i>=0;i--){
           lists.add(nodes.get(i)) ;
        }
        return lists;

    }

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

package interview;

import leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 张亚飞 on 2019/7/23.
 */
public class 前序非递归 {
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            LinkedList<TreeNode> stack = new LinkedList<>();
            LinkedList<Integer> output = new LinkedList<>();
            if (root == null) {
                return output;
            }

            stack.add(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pollLast();
                output.add(node.val);
                if (node.right != null) {
                    stack.add(node.right);
                }
                if (node.left != null) {
                    stack.add(node.left);
                }
            }
            return output;
        }
    }


}

 
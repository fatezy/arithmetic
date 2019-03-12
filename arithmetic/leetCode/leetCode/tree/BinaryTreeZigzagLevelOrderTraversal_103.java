package leetCode.tree;

import leetCode.util.TreeNode;

import java.util.*;

/**
 * author： 张亚飞
 * time：2016/8/7  16:01
 */
//Given a binary leetCode.tree, return the zigzag level order traversal of its nodes' values.
// (ie, from left to right, then right to left for the next level and alternate between).
//
//        For example:
//        Given binary leetCode.tree [3,9,20,null,null,15,7],
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        return its zigzag level order traversal as:
//        [
//        [3],
//        [20,9],
//        [15,7]
//        ]
    //z型二叉搜索树遍历，即
    //level 1 ：一个节点
    //level 2： 右到左
    //level 3:  左到右

public class BinaryTreeZigzagLevelOrderTraversal_103 {
    List<List<Integer>> nodes = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       levelOrder(root);
        for (int i = 0; i <nodes.size() ; i++) {
            if (i%2==1){
                reverseList(nodes.get(i));
            }
        }

        return nodes;
    }


    public void reverseList(List<Integer> list){
        Stack<Integer> stack = new Stack<>();
        for (Integer val:
             list) {
            stack.push(val);
        }
        list.clear();
        while (!stack.empty()){
            list.add(stack.pop());
        }
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





//methods 2
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> sol = new ArrayList<>();
        travel(root, sol, 0);
        return sol;
    }

    private void travel(TreeNode curr, List<List<Integer>> sol, int level) {
        if(curr == null) return;

        if(sol.size() <= level)
        {
            List<Integer> newLevel = new LinkedList<>();
            sol.add(newLevel);
        }

        List<Integer> collection  = sol.get(level);
        if(level % 2 == 0) collection.add(curr.val);
        else collection.add(0, curr.val);

        travel(curr.left, sol, level + 1);
        travel(curr.right, sol, level + 1);
    }






    public static void main(String[] args) {

    }
}

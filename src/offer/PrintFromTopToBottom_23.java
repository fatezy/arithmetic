package offer;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * author： 张亚飞
 * time：2016/5/20  21:36
 */
//层序遍历
public class PrintFromTopToBottom_23 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return list;
        }
        queue.offer(root);
        while (queue.size()!=0){
            TreeNode temp = queue.poll();
            list.add(temp.val);
            if (temp.left != null) queue.add(temp.left);
            if (temp.right!=null) queue.add(temp.right);
        }
        return list;
    }
}

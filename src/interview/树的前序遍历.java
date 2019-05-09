package interview;

//给定一个二叉树，返回它的 前序 遍历。

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张亚飞 on 2019/5/9.
 */
public class 树的前序遍历 {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        return helper(root,list);

    }

    public List<Integer> helper(TreeNode root,List<Integer> res){
        if (root != null){
            res.add(root.val);
            helper(root.left,res);
            helper(root.right,res);
        }

        return res;
    }

    public static void main(String[] args) {

    }
}

 
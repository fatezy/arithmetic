package 左程云;

import leetcode.util.Tree;
import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class 二叉树为某一值的路径 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            ArrayList<Integer> tempPath = new ArrayList<>();
            helper2(root,target,tempPath,res);
            return res;
    }


    public void helper2(TreeNode root, int target, ArrayList<Integer> tempPath,ArrayList<ArrayList<Integer>> res){
        if (root == null){
            return;
        }

        if (root.val == target && root.left == null && root.right == null){
            tempPath.add(root.val);
            res.add(new ArrayList<>(tempPath));
            tempPath.remove(tempPath.size()-1);
            return;
        }

        if (root != null) {
            tempPath.add(root.val);
            helper2(root.left, target - root.val, tempPath, res);
            tempPath.remove(tempPath.size() - 1);
        }

        if (root != null) {
            tempPath.add(root.val);
            helper2(root.right, target - root.val, tempPath, res);
            tempPath.remove(tempPath.size() - 1);
        }

    }


    public static void main(String[] args) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(new TreeNode(10));
        list.add(new TreeNode(5));
        list.add(new TreeNode(12));
        list.add(new TreeNode(4));
        list.add(new TreeNode(7));
        TreeNode node = Tree.tree_init(list);
        二叉树为某一值的路径 main = new 二叉树为某一值的路径();
        main.FindPath(node,22);
    }
}



package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/5/2  15:56
 */
//Given a binary tree, return all root-to-leaf paths.
//
//        For example, given the following binary tree:
//
//        1
//        /   \
//        2     3
//        \
//        5
//        All root-to-leaf paths are:
//
//        ["1->2->5", "1->3"]
    //写出所有根到叶子节点的所有路径
    //// TODO: 2016/5/2  
public class BinaryTreePaths_257 {
    List<Integer> list = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        return null;
    }

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

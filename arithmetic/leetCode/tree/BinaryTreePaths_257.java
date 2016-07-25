package tree;

import util.Tree;
import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
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
public class BinaryTreePaths_257 {
   static List<Integer> list = new ArrayList<>();
   static List<String> stringList = new ArrayList<>();
    public static List<String> binaryTreePaths(TreeNode root) {
        stringList = new ArrayList<>();
        if (root != null){
            preorderTraversal(root);
        }
        return stringList;
    }


    public static String intListToStr(List<Integer> list){
        if (list == null)
            return null;
        if (list.size() == 1){
            return String.valueOf(list.get(0));
        }
        String str = "";
        for (int i = 0; i <list.size()-1 ; i++) {
            str  += list.get(i)+"->";
        }

        str += list.get(list.size()-1);
        return str;

    }

    public static void preorderTraversal(TreeNode root) {
       if (root.left == null && root.right == null) {
           list.add(root.val);
           stringList.add(intListToStr(list));
           list.remove(list.size()-1);
       }

        if (root.left != null) {
            list.add(root.val);
            preorderTraversal(root.left);
        }

        if (root.right !=null){
            list.add(root.val);
            preorderTraversal(root.right);
        }
        if (list.size()>0) {
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {

        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(new TreeNode(1));
        list.add(new TreeNode(2));
        list.add(new TreeNode(3));
        list.add(new TreeNode(4));
        list.add(new TreeNode(5));
        list.add(null);
        list.add(null);
        list.add(new TreeNode(8));
        list.add(new TreeNode(9));
        TreeNode node = Tree.tree_init(list);

        List<String> strs =  binaryTreePaths(node);
        System.out.println("ok");


    }
}

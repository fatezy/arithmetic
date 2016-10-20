package hashmap;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * author： 张亚飞
 * time：2016/10/20  23:18
 */
/*Given a binary tree, return the inorder traversal of its nodes' values.

        For example:
        Given binary tree [1,null,2,3],
        1
        \
        2
        /
        3
        return [1,3,2].*/
    //中序遍历
public class BinaryTreeInorderTraversal_94 {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        res = inorder(root ,res);
        return res;
    }

    public static List<Integer> inorder(TreeNode root,List<Integer> res){
        if (root==null){
            return res;
        }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);

        return res;
    }


//用迭代的方式解决
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }


    public static void main(String[] args) {
            TreeNode node = new TreeNode(1);
            TreeNode node1 = new TreeNode(2);
            TreeNode node2 = new TreeNode(3);
            node.right = node1;
            node1.left = node2;
        System.out.println(inorderTraversal(node));
    }
}

package 左程云;

import leetcode.util.Tree;
import leetcode.util.TreeNode;

import java.util.LinkedList;

public class 二叉树的镜像 {
    /**
     * 返回节点
     * @param node
     * @return
     */
    public static TreeNode mirror(TreeNode node) {
        if (node == null){
            return node;
        }

        TreeNode temp= mirror(node.right);
        node.right = mirror(node.left);
        node.left = temp;
        return node;
    }


    public  void mirror2(TreeNode head){
        if (head == null){
            return;
        }

        if (head!= null && head.left == null && head.right == null){
            return ;
        }
        TreeNode temp = head.left;
        head.left = head.right;
        head.right = temp;
        mirror2(head.left);
        mirror2(head.right);


    }



    public static TreeNode invertTree(TreeNode node) {
        if (node == null){
            return node;
        }
        if (node!= null && node.left == null && node.right == null){
            return node;
        }

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        invertTree(node.left);
        invertTree(node.right);
        return node;
    }

    public static void main(String[] args) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(new TreeNode(10));
        list.add(new TreeNode(5));
        list.add(new TreeNode(12));
        list.add(new TreeNode(4));
        list.add(new TreeNode(7));
        TreeNode node = Tree.tree_init(list);
        二叉树的镜像 main =new  二叉树的镜像();
        main.mirror(node);

    }
    }

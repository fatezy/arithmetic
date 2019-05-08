package leetCode.tree;

/**
 * author： 张亚飞
 * time：2016/8/8  09:30
 */
//Given a binary first.leetCode.tree
//
//        struct TreeLinkNode {
//        TreeLinkNode *left;
//        TreeLinkNode *right;
//        TreeLinkNode *next;
//        }
//        Populate each next pointer to point to its next right node. If there is no next right node,
// the next pointer should be set to NULL.
//
//        Initially, all next pointers are set to NULL.
    //给你一个完美的平衡二叉树，每一个节点都有两个孩子节点
// TODO: 2016/8/8  
public class PopulatingNextRightPointersinEachNode_116 {
    public void connect(TreeLinkNode root) {
        

    }



    public static void main(String[] args) {

    }
}


    class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

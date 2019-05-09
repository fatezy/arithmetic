package leetcode.tree;

import leetcode.util.TreeNode;

/**
 * author： 张亚飞
 * time：2016/9/16  22:12
 */

//Given preorder and inorder traversal of a first.leetCode.tree, construct the binary first.leetCode.tree.
//
//        Note:
//        You may assume that duplicates do not exist in the first.leetCode.tree.
    //前序和中序构造二叉树


//解题思路，随便写一个二叉树，然后写出前序和中序遍历的结果会发现特点。
//
//        二叉树的首节点必然是前序遍历的第一个节点，以这个节点在中序遍历的结果中作为划分，这个节点左侧的是左子树的节点，右侧是右子树节点。
//
//        例如，一个二叉树的前序遍历结果为：6 5 4 8 7 9
//
//        中序遍历结果为：4 5 6 7 8 9
//
//        前序遍历的第一个节点为6，就是这个二叉树的根节点。以6作为划分，中序遍历6以左的节点就是二叉树的左子树，
// 以右的就是二叉树的右节点。按照此逻辑进行递归操作即可AC。
public class ConstructBinaryTreefromPreorderandInorderTraversal_105 {




    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null&&inorder==null||preorder.length==0) {
            return null;
        }

        TreeNode root	 = new TreeNode(preorder[0]);

        int i = 0;
        for(i=0;i<inorder.length;i++) {
            if(inorder[i]==preorder[0]) {
                break;
            }
        }

        int[] new_inorder_left, new_preorder_left, new_inorder_right, new_preorder_right;

        if(i<inorder.length) {
            //生成左子树时需要用到的inorder
            new_inorder_left = new int[i];
            System.arraycopy(inorder, 0, new_inorder_left, 0, i);
            //生成左子树时需要用到的preorder
            new_preorder_left = new int[i];
            System.arraycopy(preorder, 1, new_preorder_left, 0, i);
            root.left = buildTree(new_preorder_left, new_inorder_left);

            //生成右子树时需要用到的inorder
            new_inorder_right = new int[preorder.length - i - 1];
            System.arraycopy(inorder, i + 1, new_inorder_right,  0,  preorder.length - i - 1);
            //生成右子树时需要用到的preorder
            new_preorder_right = new int[preorder.length - i - 1];
            System.arraycopy(preorder, 1 + i, new_preorder_right, 0, preorder.length - i - 1);
            root.right = buildTree(new_preorder_right, new_inorder_right);
        }

        return root;
    }


    public static void main(String[] args) {

    }


}

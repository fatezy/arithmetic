package leetCode.tree;

import leetCode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/5/2  12:15
 */
//Given a binary first.leetCode.tree, check whether it is a mirror of itself (ie, symmetric around its center).
    //判断二叉树是否对称
public class SymmetricTree_101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isMirror(root.left,root.right);
    }
    public boolean isMirror(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        return (p.val==q.val) && isMirror(p.left,q.right) && isMirror(p.right,q.left);
    }





    List<Integer> list = new ArrayList<>();
    //192过了190-.-
    public boolean isSymmetric2(TreeNode root) {
        inorderTraversal(root);
        int len = list.size();
        for (int i = 0; i <len/2 ; i++) {
            if (!list.get(i).equals(list.get(len-i-1)))
                return false;
        }
            return true;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root==null) {
            list.add(Integer.MAX_VALUE);
            return list ;
        }
        else {
            inorderTraversal(root.left);
            if(root!=null) {
                list.add(root.val);
            }
            inorderTraversal(root.right);
        }
        return list;
    }

    public static void main(String[] args) {
        SymmetricTree_101 symmetricTree_101 = new SymmetricTree_101();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(2);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode3.left = treeNode5 ;
        symmetricTree_101.isSymmetric(treeNode1);

    }

}

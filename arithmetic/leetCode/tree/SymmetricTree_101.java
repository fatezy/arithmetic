package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/5/2  12:15
 */
//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
    //判断二叉树是否对称
public class SymmetricTree_101 {


    List<Integer> list = new ArrayList<>();
    public boolean isSymmetric(TreeNode root) {
        inorderTraversal(root);
        int len = list.size();
        for (int i = 0; i <len/2 ; i++) {
            if (list.get(i)!=list.get(len-i-1))
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
            if (root != null) {
                list.add(root.val);
            }

            inorderTraversal(root.right);
        }

        return list;

    }


}

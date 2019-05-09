package interview;

import leetcode.util.TreeNode;

/**
 * Created by 张亚飞 on 2019/5/9.
 */
public class 二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1 ;
    }


    public static void main(String[] args) {

    }
}

 
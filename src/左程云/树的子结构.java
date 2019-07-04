package 左程云;

import leetcode.util.TreeNode;

public class 树的子结构 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null){return false;}
        return isSame(root1,root2) || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
    }
    public boolean isSame(TreeNode root1,TreeNode root2) {
        if(root2 == null){return true;}
        if(root1 == null){return false;}
        if(root1.val == root2.val){
            return isSame(root1.left,root2.left) && isSame(root1.right,root2.right);
        }else{
            return false;
        }
    }

}

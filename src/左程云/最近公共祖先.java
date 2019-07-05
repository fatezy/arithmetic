package 左程云;

import leetcode.util.TreeNode;

public class 最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return root;
        }

        if (root.val  == p.val ||root.val == q.val){
            return root;
        }

        if ((root.val>p.val && root.val<q.val) || (root.val<p.val && root.val > q.val)){
            return root;
        }

        if (root.val>p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }

        if (root.val<p.val&&  root.val < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
            return root;
    }
}

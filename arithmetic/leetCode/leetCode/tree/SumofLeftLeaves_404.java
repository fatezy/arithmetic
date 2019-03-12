package leetCode.tree;

import leetCode.util.Tree;
import leetCode.util.TreeNode;

import java.util.LinkedList;

/**
 * 作者： 张亚飞
 * 时间： 2018/1/3.
 */

/*Find the sum of all left leaves in a given binary leetCode.tree.

        Example:

        3
        / \
        9  20
        /  \
        15   7

        There are two left leaves in the binary leetCode.tree, with values 9 and 15 respectively. Return 24.*/
//求所有的左叶子节点之和
//应该没问题，但是
public class SumofLeftLeaves_404 {

    public static int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        if(root.left != null) {
            if(root.left.left == null && root.left.right == null) ans += root.left.val;
            else ans += sumOfLeftLeaves(root.left);
        }
        ans += sumOfLeftLeaves(root.right);

        return ans;
    }

    public static void main(String[] args) {

        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(new TreeNode(3));
        list.add(new TreeNode(9));
        list.add(new TreeNode(20));
        list.add(null);
        list.add(null);
        list.add(new TreeNode(15));
        list.add(new TreeNode(7));
        TreeNode node = Tree.tree_init(list);


        System.out.println(sumOfLeftLeaves(node));


    }
}

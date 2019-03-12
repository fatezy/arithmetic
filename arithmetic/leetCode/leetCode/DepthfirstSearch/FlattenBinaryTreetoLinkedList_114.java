package leetCode.DepthfirstSearch;

import leetCode.util.TreeNode;

/**
 * author： 张亚飞
 * time：2016/6/7  16:40
 */
//Given a binary leetCode.tree, flatten it to a linked list in-place.
//
//        For example,
//        Given
//
//         1
//         / \
//        2   5
//       / \   \
//      3   4   6
//        The flattened leetCode.tree should look like:
//        1
//         \
//          2
//           \
//            3
//             \
//              4
//                \
//                  5
//                   \
//                    6
    //推平树
public class FlattenBinaryTreetoLinkedList_114 {
    //可以想象为右左中的遍历，最后操作的为中
    //高手解法
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }



    public void flatten2(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;

        flatten(left);
        flatten(right);

        root.right = left;
        TreeNode cur = root;
        while (cur.right != null) cur = cur.right;
        cur.right = right;
    }

}

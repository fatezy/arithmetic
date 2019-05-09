package leetcode.tree;

import leetcode.util.TreeNode;

/**
 * author： 张亚飞
 * time：2016/8/7  10:11
 */
//Two elements of a binary search first.leetCode.tree (BST) are swapped by mistake.
//
//        Recover the first.leetCode.tree without changing its structure.
//
//        Note:
//        A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
    //一个二叉树交换时有些错误，请尝试修复它
public class RecoverBinarySearchTree_99 {
//    递归中序遍历二叉树，设置一个pre指针，记录当前节点中序遍历时的前节点，
// 如果当前节点大于pre节点的值，说明需要调整次序。
//    有一个技巧是如果遍历整个序列过程中只出现了一次次序错误，
// 说明就是这两个相邻节点需要被交换。如果出现了两次次序错误，那就需要交换这两个节点。

//    两个错误节点是相邻的，比如：0,1,2,3,5,4,6，这种情况中序遍历的整个过程只能发现一次异常节点，
// 在这里是4，这种情况，需要把异常节点和它前面那个节点调换，即4和5调换；
//    两个错误节点不相邻，比如：0,1,5,3,4,2,6，这种情况中序遍历的整个过程可以发现两次异常节点，
// 在这里分别为3和2，这种情况下，需要把第一个异常节点的前面那个节点和第二个异常节点调换，即5和2。

    TreeNode mistake1, mistake2;;
    TreeNode pre;
//中序遍历
    void recursive_traversal(TreeNode root) {
        if(root==null) {
            return;
        }
        if(root.left!=null) {
            recursive_traversal(root.left);
        }
        if(pre!=null&&root.val<pre.val) {
            if(mistake1==null) {
                mistake1 = pre;
                mistake2 = root;
            } else {
                mistake2 = root;
            }
        }
        pre = root;
        if(root.right!=null) {
            recursive_traversal(root.right);
        }
    }
    public void recoverTree(TreeNode root) {
        //pre必须设为null，通过遍历的时候设进去。因为是中序遍历，所以pre应该是深层叶子左子树的父节点。
        recursive_traversal(root);
        if(mistake1!=null&&mistake2!=null) {
            int tmp = mistake1.val;
            mistake1.val = mistake2.val;
            mistake2.val = tmp;
        }
    }


    public static void main(String[] args) {

    }
}

package leetcode.DepthfirstSearch;

import leetcode.util.ListNode;
import leetcode.util.TreeNode;

/**
 * author： 张亚飞
 * time：2016/6/7  16:14
 */
//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
    //使有序ArraysList生成二叉搜索树
public class ConvertSortedListtoBinarySearchTree_109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        int i = 0;
        ListNode temp = head;
        while (head != null){
            i++;
            head = head.next;
        }

        int[] nums = new int[i];
        i= 0;
        while (temp != null){
            nums[i] = temp.val;
            i++;
            temp = temp.next;

        }
        TreeNode result = helper(nums, 0, nums.length - 1);
        return result;

    }

    public TreeNode helper(int[] num, int low, int high) {
        if (low > high) { // Done
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }
}

package leetcode.linkList;

import leetcode.util.ListNode;
import leetcode.util.TreeNode;

/**
 * author： 张亚飞
 * time：2016/5/14  20:42
 */
//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
    //给你一个有序链表把它转化为一个平衡二叉树
    //// TODO: 2016/5/14

public class SortedListToBST_109 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            TreeNode treeNode=new TreeNode(head.val);
            return treeNode;
        }
        ListNode slow=head;
        ListNode fast=head.next.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        TreeNode root=new TreeNode(slow.next.val);
        ListNode temp=slow.next.next;
        slow.next=null;
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(temp);
        return root;
    }
}

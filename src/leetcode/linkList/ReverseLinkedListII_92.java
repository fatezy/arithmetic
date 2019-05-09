package leetcode.linkList;

import leetcode.util.ListNode;

/**
 * author： 张亚飞
 * time：2016/7/24  15:54
 */
//Crackingthecodinginterview.Reverse a linked list from position m to n. Do it in-place and in one-pass.
//
//        For example:
//        Given 1->2->3->4->5->NULL, m = 2 and n = 4,
//
//        return 1->4->3->2->5->NULL.
//
//        Note:
//        Given m, n satisfy the following condition:
//        1 ≤ m ≤ n ≤ length of list.

    //链表逆序于指定的位置
public class ReverseLinkedListII_92 {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return null ;
        ListNode firstNode = new ListNode(0);
        firstNode.next = head;
        ListNode pre = firstNode;
        for (int i = 0; i <m-1 ; i++) {
            pre = pre.next;
        }
        ListNode curr =  pre.next;
        ListNode next  = curr.next;
        for (int i = 0; i <n-m ; i++) {
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = curr.next;
        }
        return firstNode.next;
    }



    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 0; i<m-1; i++) pre = pre.next;
        ListNode start = pre.next;
        ListNode then = start.next;
        for(int i=0; i<n-m; i++)
        {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {

    }
}

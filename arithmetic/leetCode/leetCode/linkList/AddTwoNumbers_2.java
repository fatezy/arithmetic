package leetCode.linkList;

import leetCode.util.ListNode;

/**
 * author： 张亚飞
 * time：2016/5/13  16:01
 */
//You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes
// contain a single digit. Add the two numbers and return it as a linked list.
//
//        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//        Output: 7 -> 0 -> 8
    //给你两个链表代表逆序的两个数，加起来
public class AddTwoNumbers_2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null ;
        int val1 = 0;
        int val2;
        while (l1!=null||l2!=null){
            if (l1==null){
                val1 = 0;
            }else {
                val1 = l1.val ;
            }

            if (l2==null){
                val2 = 0;
            }else {
                val2 = l2.val;
            }

            head = insertNode(head,val1+val2);
            if (l1!=null) {
                l1 = l1.next;
            }
            if (l2!=null){
            l2 = l2.next;
            }
        }
        ListNode p = head;
        while (p!=null){
            if (p.val >=10){
                p.val -= 10;
                if (p.next != null){
                    p.next.val += 1;
                }else {
                    ListNode node = new ListNode(1);
                    p.next = node;
                }
            }
            p = p.next;
        }

        return head;
    }

    public static ListNode insertNode(ListNode head,int data){
        ListNode node = new ListNode(data);
        ListNode p = head;
        if (head == null){
            head = node;
        }else{
            while (p!=null){
                if (p.next == null){
                    p.next = node;
                    break;
                }else {
                    p = p.next;
                }

            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
       // node1.next = new ListNode(1);
        ListNode node2 = new ListNode(5);
        //node2.next = new ListNode(1);
       // node2.next.next = new ListNode(1);
        ListNode node = addTwoNumbers(node1,node2);
        System.out.println("ok");
    }

}

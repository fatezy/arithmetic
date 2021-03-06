package leetcode.linkList;

import leetcode.util.Link_List;
import leetcode.util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * author： 张亚飞
 * time：2016/7/23  16:32
 */
//Given a sorted linked list, delete all nodes that have duplicate numbers,
// leaving only distinct numbers from the original list.
//
//        For example,
//        Given 1->2->3->3->4->4->5, return 1->2->5.
//        Given 1->1->1->2->3, return 2->3.
    //给你一个有序的链表，移除所有重复的数
public class RemoveDuplicatesfromSortedListII_82 {
    public static ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        if (head == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!=null){
            if (slow.val != fast.val){
                slow =slow.next;
                fast = fast.next;
            }else {
                set.add(slow.val);
                slow = slow.next;
                fast = fast.next;
            }
        }
        ListNode node = head;
        ListNode left = head;
        while (node != null){
            if (set.contains(node.val)){
                if (node == head){
                    head = head.next;
                    left = left.next;
                    node =node.next;
                }else {

                    left.next = node.next;
                    node= node.next;
                }
            }else {
                if (node != head) {
                    left = left.next;
                }
                node = node.next;
            }
        }


        return head;

    }



    public static ListNode deleteDuplicates2(ListNode head) {
        if(head==null) return null;
        ListNode FakeHead=new ListNode(0);
        FakeHead.next=head;
        ListNode pre=FakeHead;
        ListNode cur=head;
        while(cur!=null){
            //如果当前的node的值和下一个node的值相同，当前node后移
            while(cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }
            if(pre.next==cur){
                pre=pre.next;
            }
            else{
                pre.next=cur.next;
            }
            cur=cur.next;
        }
        return FakeHead.next;
    }

    public static void main(String[] args) {
        Link_List list = new Link_List();
        list.initList(2,2,3);
        deleteDuplicates2(list.getFirstNode());

        System.out.println("ok");

    }

}

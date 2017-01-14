package linkedlist;

import util.Link_List;
import util.ListNode;

/**
 * 作者： 张亚飞
 * 时间： 2017/1/14.
 */

//Given a linked list, swap every two adjacent nodes and return its head.
//
//        For example,
//        Given 1->2->3->4, you should return the list as 2->1->4->3.
//
//        Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
    //交换相邻的两个节点
public class SwapNodesinPairs_24 {
    //换值，不换节点
    public static ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode first = head;
        ListNode second = head.next;
        while (second != null){
            int fval = first.val;
            int sval = second.val;
            first.val =sval;
            second.val = fval;

            if (second.next!=null&&second.next.next != null){
                second = second.next.next;
                first= first.next.next;
            }else {
                break;
            }


        }
        return head;
    }
//换节点，换节点，节点之间的关系较为复杂
    public ListNode swapPairs3(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }





//递归
    public ListNode swapPairs2(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }

    public static void main(String[] args) {
        Link_List link_list = new Link_List();
        link_list.initList(1,2,3,4);
        swapPairs(link_list.getFirstNode());
    }

}

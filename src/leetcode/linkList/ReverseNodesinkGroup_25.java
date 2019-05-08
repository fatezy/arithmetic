package leetCode.linkList;

import leetCode.util.Link_List;
import leetCode.util.ListNode;

/**
 * author： 张亚飞
 * time：2016/8/1  21:21
 */
//Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
//
//        If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
//
//        You may not alter the values in the nodes, only nodes itself may be changed.
//
//        Only constant memory is allowed.
//
//        For example,
//        Given this linked list: 1->2->3->4->5
//
//        For k = 2, you should return: 2->1->4->3->5
//
//        For k = 3, you should return: 3->2->1->4->5
    //给你一个链表，一次颠倒k个元素
public class ReverseNodesinkGroup_25 {
    public  static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)
            return head;
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode temp = head;
        ListNode front;
        ListNode ltempMark = first;
        while (temp != null){
                front = temp;
            for (int i = 0; i <k-1&&temp !=null ; i++) {
                temp = temp.next;
            }
            if (temp != null){
                ListNode tempNext = temp.next;
                ListNode rev = reverse(front,temp);
                rev.next = tempNext;
                if (first.next == head){
                    first.next = temp;
                    ltempMark = front;
                }else {
                    ltempMark.next = temp;
                    ltempMark = front;
                }
                temp = tempNext;

            }

        }


        return first.next;
    }


    public static ListNode  reverse(ListNode first,ListNode last){

        ListNode node = first;
        ListNode front = first;
        ListNode temp = first;
        node = node.next;
        while (node != last){
            temp = node.next;
            node.next = front;
            front = node;
            node = temp;
        }
        node.next = front;
        return first;

    }


    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }

    public static void main(String[] args) {

        Link_List list = new Link_List();
        list.initList(1,2,3,4,5,6,7,8);
//        //创建头指针
//        ListNode first = new ListNode(0);
//        first.next = list.getFirstNode();
//        //遍历到要逆序的最后一个节点
//        ListNode node = list.getFirstNode().next;
//        //记录下下个节点
//        ListNode nodeNext = node.next;
//        ListNode rem = reverse(list.getFirstNode(),node);
//        rem.next = nodeNext;
//        first.next = node;

        ListNode node = reverseKGroup(list.getFirstNode(),3);
        System.out.println(1);
    }
}

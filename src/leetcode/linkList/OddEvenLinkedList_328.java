package leetCode.linkList;

import leetCode.util.Link_List;
import leetCode.util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/5/14  16:21
 */
//Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
//
//        You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
//
//        Example:
//        Given 1->2->3->4->5->NULL,
//        return 1->3->5->2->4->NULL.
//
//        Note:
//        The relative order inside both the even and odd groups should remain as it was in the input.
//        The first node is considered odd, the second node even and so on ...
    //相对顺序不变奇偶分治
    //// TODO: 2016/5/14
    //题目理解错了，是奇数位和偶数位分离
public class OddEvenLinkedList_328 {
    public static ListNode oddEvenList(ListNode head) {
        //奇数
        List<Integer> listOdd = new ArrayList<>();
        //偶数
        List<Integer> listEven = new ArrayList<>();
        int flag  = -1;
        if (head!=null){
            flag = head.val %2;
        }
        //奇数与偶数分离
        while (head != null){
            if (head.val % 2 == 0){
                listEven.add(head.val);
                head = head.next;
            }else {
                listOdd.add(head.val);
                head = head.next;
            }
        }

        ListNode result = null;
        ListNode curr = result;

        if (flag == 1) {
            for (int i = 0; i < listOdd.size(); i++) {
                ListNode node = new ListNode(listOdd.get(i));
                if (curr == null) {
                    curr = node;
                    result = node;
                } else {
                    curr.next = node;
                    curr = curr.next;
                }

            }

            for (int i = 0; i < listEven.size(); i++) {
                ListNode node = new ListNode(listEven.get(i));
                if (curr == null) {
                    curr = node;
                    result = node;
                } else {
                    curr.next = node;
                    curr = curr.next;
                }

            }
        }

        if (flag == 0){
            for (int i = 0; i < listEven.size(); i++) {
                ListNode node = new ListNode(listEven.get(i));
                if (curr == null) {
                    curr = node;
                    result = node;
                } else {
                    curr.next = node;
                    curr = curr.next;
                }

            }

            for (int i = 0; i < listOdd.size(); i++) {
                ListNode node = new ListNode(listOdd.get(i));
                if (curr == null) {
                    curr = node;
                    result = node;
                } else {
                    curr.next = node;
                    curr = curr.next;
                }

            }

        }

        return result;
    }

    public static void main(String[] args) {
        Link_List list = new Link_List();
        list.initList(2,1,4,3,6,5,7,8);
        ListNode listNode = oddEvenList(list.getFirstNode());
        System.out.println("ok");

    }


}

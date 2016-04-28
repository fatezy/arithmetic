package linkList;

import util.ListNode;

/**
 * author： 张亚飞
 * time：2016/4/28  16:22
 */
//Given a list, rotate the list to the right by k places, where k is non-negative.
//
//        For example:
//        Given 1->2->3->4->5->NULL and k = 2,
//        return 4->5->1->2->3->NULL.
public class RotateRight_61 {
    //结果错的，题意理解错了，懒得写了
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null)
            return head;
        ListNode newHead  = head;
        for (int i = 0; i <k ; i++) {
            newHead = newHead.next;

        }
        ListNode del = newHead;
        newHead = newHead.next;
        del.next = null;
        ListNode temp = newHead;
        ListNode pre = temp;
        while (temp!=null){
            pre = temp;
            temp = temp.next;
        }
        pre.next = head;
        return newHead;

    }

}

package linkedlist;

import util.Link_List;
import util.ListNode;

import java.util.List;

/**
 * author： 张亚飞
 * time：2016/11/22  21:51
 */
//Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together
// the nodes of the first two lists.
    //合并两个有序链表

public class MergeTwoSortedLists_21 {
    /**
     * 以l1为根基，如果l2小于l1,则把l2插入到l1的链表之中，否则l1向后遍历
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        if(l1==null && l2== null)
            return null;
        if (l1 == null) return l2;
        if (l2==null) return l1;
        ListNode pre = new ListNode(0);
        while (node1!=null&&node2!=null){
            if (node1.val<node2.val){
                pre  = node1;
              node1 = node1.next;

            }else {
                ListNode temp = node2.next;
                node2.next = node1;
                pre.next = node2;
                pre = node2;
                node2 = temp;

            }

        }

    if (node2!=null) pre.next = node2;

        return l1.val>=l2.val?l2:l1;
    }


    public static void main(String[] args) {
        Link_List link_list = new Link_List();
        link_list.initList(-9,3);
        Link_List link_list1 = new Link_List();
        link_list1.initList(5,7);
        mergeTwoLists(link_list.getFirstNode(),link_list1.getFirstNode());
    }


}

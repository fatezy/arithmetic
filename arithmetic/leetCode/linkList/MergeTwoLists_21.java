package linkList;

import util.ListNode;

/**
 * author： 张亚飞
 * time：2016/4/27  17:02
 */
//Merge two sorted linked lists and return it as a new list.
// The new list should be made by splicing together the nodes of the first two lists.
//合并两个链表
public class MergeTwoLists_21 {
    //递归解法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val<l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
    //非递归解法
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while (l1!=null||l2!=null){
            if (l2==null||(l1!=null&&l1.val<=l2.val)){
                temp.next = l1;
                l1 = l1.next;
            }else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        return result.next;

    }
}

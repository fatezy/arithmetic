package linkList;

import util.Link_List;
import util.ListNode;

/**
 * author： 张亚飞
 * time：2016/4/22  21:54
 */
//Given a linked list, swap every two adjacent nodes and return its head.
//
//        For example,
//        Given 1->2->3->4, you should return the list as 2->1->4->3.
//
//        Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
//
//        Subscribe to see which companies asked this question
//交换相邻节点并返回头部
public class SwapPairs_24 {
    public ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode node = head;
        ListNode temp = head.next;
        ListNode returnHead = head.next;
        while (node!=null&&node.next!=null){
            temp = node.next;
           node.next = node.next.next;
            temp.next = node;
            temp=node.next;
            if (node.next!=null&&node.next.next!=null){
                node.next=node.next.next;
                node=temp;
            }else {
                return returnHead;
            }


        }
        return returnHead;

    }

    public static void main(String[] args) {
        Link_List list = new Link_List();
        list.initList(3,4,5);
        SwapPairs_24 swapPairs_24 = new SwapPairs_24();
        list.setFirstNode(swapPairs_24.swapPairs(list.getFirstNode()));
        list.print();
    }
}

package linkList;

import util.Link_List;
import util.ListNode;

/**
 * author： 张亚飞
 * time：2016/5/13  18:40
 */
//Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//
//        You should preserve the original relative order of the nodes in each of the two partitions.
//
//        For example,
//        Given 1->4->3->2->5->2 and x = 3,
//        return 1->2->2->4->3->5.
public class PartitionList_86 {
    public static ListNode partition(ListNode head, int x) {

        ListNode firstHead = new ListNode(0);
        firstHead.next = head;
        ListNode secondHead = new ListNode(x);


        ListNode first = firstHead;
        ListNode second = secondHead;
        ListNode curNode = head;
        while(curNode!=null){
            ListNode tmp = curNode.next;
            if(curNode.val<x){

                first.next = curNode;
                first = curNode;
            }else{
                second.next = curNode;
                second = curNode;
                second.next = null;// important
            }
            curNode = tmp;
        }
        first.next = secondHead.next;
        return firstHead.next;
    }


    public static void main(String[] args) {
        Link_List list = new Link_List();
        list.initList(1,4,3,2,5,2);
        partition(list.getFirstNode(),3);
        System.out.println("ok");


    }
}

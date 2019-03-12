package leetCode.linkList;

import org.junit.Test;
import leetCode.util.Link_List;
import leetCode.util.ListNode;

/**
 * author： 张亚飞
 * time：2016/4/28  15:58
 */
//Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
//
// Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
// the linked list should become 1 -> 2 -> 4 after calling your function.
    //用node后一个的值覆盖前一个的，再后移
public class DeleteNode_237 {
    public void deleteNode(ListNode node) {
        if (node.next!=null) {
            node.val = node.next.val;
            node.next = node.next.next;
            node = node.next;
        }

    }


    @Test
    public void test (){
        Link_List list = new Link_List();
        list.initList(0,1);
        ListNode node = list.getFirstNode().next;
        deleteNode(list.getFirstNode());
        list.setSize(1);
        list.print();
    }

}

package linkedlist;

import util.Link_List;
import util.ListNode;

import java.util.Map;
import java.util.Stack;

/**
 * author： 张亚飞
 * time：2016/11/22  21:00
 */
//Given a linked list, remove the nth node from the end of list and return its head.
//
//        For example,
//
//        Given linked list: 1->2->3->4->5, and n = 2.
//
//        After removing the second node from the end, the linked list becomes 1->2->3->5.
    //移除倒数第n个节点
public class RemoveNthNodeFromEndofList_19 {
    //用栈来处理
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp !=null){
            stack.push(temp);
            temp = temp.next;
        }
        while (n-->0){
            stack.pop();
        }
        if (!stack.empty()){
            ListNode node = stack.pop();
            node.next = node.next.next;
        }else {
            return head.next;
        }

        return head;
    }


    //快慢指针法
    public ListNode removeNthFromEnd2(ListNode head, int n) {

        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }




    public static void main(String[] args) {
        Link_List list = new Link_List();
        list.initList(1,2);
        removeNthFromEnd(list.getFirstNode(),1);
    }
}

package interview;

import leetcode.util.LinkList;
import leetcode.util.Link_List;
import leetcode.util.ListNode;

/**
 * Created by 张亚飞 on 2019/5/9.
 */
public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = null;
        while(curr!=null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        Link_List list = new Link_List();
        list.initList(1,2,3);
        反转链表 test = new 反转链表();
        test.reverseList(list.getFirstNode());
    }
}

 
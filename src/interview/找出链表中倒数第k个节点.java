package interview;

import leetcode.util.Link_List;
import leetcode.util.ListNode;

/**
 * Created by 张亚飞 on 2019/5/9.
 */
public class 找出链表中倒数第k个节点 {
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode temp = head;
        for (int i = 0; i <k ; i++) {
            if (temp != null) {
                temp = temp.next;
            }else {
                return null;
            }

        }

        while (temp != null){
            temp = temp.next;
            head = head.next;
        }

        return head;
    }


    public static void main(String[] args) {
        Link_List list = new Link_List();
        list.initList(1,2,3,4,5,6,7);
        找出链表中倒数第k个节点 test= new 找出链表中倒数第k个节点();
        test.FindKthToTail(list.getFirstNode(),2);
    }
}

 
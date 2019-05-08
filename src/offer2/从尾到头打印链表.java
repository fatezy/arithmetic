package offer2;

import leetCode.util.ListNode;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by 张亚飞 on 2019/3/13.
 */
public class 从尾到头打印链表 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode == null){
            return null;
        }

        ArrayList<Integer> res = new ArrayList<>();
        ListNode curr = listNode;
        ListNode newHead = null;
        ListNode temp = null;
        ListNode currNext = null;
        while (curr != null){
            currNext = curr.next;
            temp = curr;
            temp.next = newHead;
            newHead = temp;
            curr = currNext;

        }

        while (newHead != null){
            res.add(newHead.val);
            newHead = newHead.next;
        }

        return res;
    }


    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next =l2;
        l2.next =l3;
        l3.next = l4;

        printListFromTailToHead(l1);
    }
}

 
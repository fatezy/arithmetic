package interview;

import leetcode.util.LinkList;
import leetcode.util.Link_List;
import leetcode.util.ListNode;

/**
 * Created by 张亚飞 on 2019/5/9.
 */
public class 反转链表 {

    //常规方法
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

    // 递归

    /**
     * 递归第一步要考虑当前的函数有什么功能，这个问题下递归即反转当前的链表
     * 返回值是节点的新头
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        //返回的是节点的新脑袋
         ListNode newList =  reverseList2(head.next);
         ListNode t1 = head.next;
         t1.next = head;
         head.next = null;


        return newList;
    }


    public static void main(String[] args) {
        Link_List list = new Link_List();
        list.initList(1,2,3);
        反转链表 test = new 反转链表();
        test.reverseList(list.getFirstNode());
    }




    public ListNode reverseList3(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverseList3(head.next);
        ListNode node = head.next;
        node.next = head;
        head.next = null;

        return newHead;
    }




}

 
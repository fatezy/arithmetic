package linkedlist;

import util.Link_List;
import util.ListNode;

/**
 * author： 张亚飞
 * time：2016/11/22  20:17
 */
//You are given two linked lists representing two non-negative numbers. The digits are
// stored in reverse order
// and each of their nodes contain a single digit. Add the two numbers and return
// it as a linked list.
/*Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        Output: 7 -> 0 -> 8*/
    //用两个链表模拟数字相加
public class AddTwoNumbers_2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        ListNode front  = head;
        while (l1!=null||l2!=null){
            if (l1!=null&&l2!=null){
                temp.next = new ListNode((temp.val+l1.val+l2.val)/10);
                temp.val = (temp.val+l1.val+l2.val)%10;
                l1 = l1.next;
                l2 = l2.next;
                front = temp;
                temp = temp.next;
                continue;
            }

            if (l1!=null){
                temp.next = new ListNode((temp.val+l1.val)/10);
                temp.val = (temp.val+l1.val)%10;
                front = temp;
                temp = temp.next;
                l1 =l1.next;
            }
            if (l2!=null){
                temp.next = new ListNode((temp.val+l2.val)/10);
                temp.val = (temp.val+l2.val)%10;
                front = temp;
                temp = temp.next;
                l2=l2.next;
            }

        }

        if (front.next!=null&&front.next.val==0){
            front.next = null;
        }

        return head;
    }

    public static void main(String[] args) {
        Link_List link_list = new Link_List();
        link_list.initList(1,8);
        Link_List link_list1 = new Link_List();
        link_list1.initList(0);
        addTwoNumbers(link_list1.getFirstNode(),link_list.getFirstNode());
        System.out.printf("ok");
    }

}

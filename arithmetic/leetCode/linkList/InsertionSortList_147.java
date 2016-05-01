package linkList;

import org.junit.Test;
import util.Link_List;
import util.ListNode;

/**
 * author： 张亚飞
 * time：2016/4/28  15:05
 */
//Sort a linked list using insertion sort.
    //插入排序
public class InsertionSortList_147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode runner = head.next;
        ListNode previous = head;
        while (runner != null) {
            if (runner.val < previous.val) {
                previous.next = runner.next;
                ListNode temp = runner;
                runner = runner.next;
                ListNode searchNode = head;
                ListNode previousNode = null;
                while (searchNode.val < temp.val) {
                    previousNode = searchNode;
                    searchNode = searchNode.next;
                }
                if (previousNode == null) {
                    temp.next = head;
                    head = temp;
                } else {
                    temp.next = searchNode;
                    previousNode.next = temp;
                }
            } else {
                previous = runner;
                runner = runner.next;
            }
        }
        return head;
    }

    @Test
    public void test (){
        Link_List list = new Link_List();
        list.initList(1,3,2,5);
        insertionSortList(list.getFirstNode());
    }

}

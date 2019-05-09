package leetcode.linkList;

import leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/7/25  21:45
 */
//Sort a linked list in O(n log n) time using constant space complexity.
    //linkedList排序
public class SortList_148 {
    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while (node != null){
            list.add(node.val);
            node = node.next;
        }
        Collections.sort(list);
        node = head;
        int i = 0;
        while (node!=null){
            node.val = list.get(i);
            i++;
            node = node.next;
        }

        return head;

    }
}

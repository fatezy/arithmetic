package leetCode.linkList;

import leetCode.util.ListNode;

import java.util.HashSet;

/**
 * author： 张亚飞
 * time：2016/4/27  23:17
 */
//Given a linked list, return the node where the cycle begins.
// If there is no cycle, return null.
public class DetectCycleII_142 {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head!=null){
            if (set.contains(head)) return head;
            set.add(head);
            head = head.next;

        }

        return null;

    }



}

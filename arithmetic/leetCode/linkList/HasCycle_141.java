package linkList;

import util.ListNode;

import java.util.HashSet;

/**
 * author： 张亚飞
 * time：2016/4/27  22:47
 */
//Given a linked list, determine if it has a cycle in it.
    //判断是否链表存在圈
public class HasCycle_141 {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head!=null){
           if (set.contains(head)) return true;
            set.add(head);
            head = head.next;

        }

        return false;

    }
    //快慢指针法
    public boolean hasCycle2(ListNode head) {
        if(head==null || head.next==null) return false;
        ListNode fast=head,slow=head;
        while(fast!=null&& fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) return true;
        }
        return false;
    }
}

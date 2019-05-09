package offer;

import leetcode.util.Link_List;
import leetcode.util.ListNode;

/**
 * author： 张亚飞
 * time：2016/5/20  20:20
 */
//输入两个单调递增的链表，输出两个链表合成后的链表，
// 当然我们需要合成后的链表满足单调不减规则。
public class Merge_17 {
    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 ==null&&list2 != null)
            return list2;
        if (list1!=null&&list2 == null)
             return list1;
        if (list1==null&&list2 == null)
            return null;
        ListNode result;
        ListNode firstNext;
        ListNode secondNext;
        ListNode curr;
        if (list1.val<= list2.val){
            result = list1;
        }else {
            result = list2;
        }
        curr = new ListNode(Integer.MAX_VALUE);
        while (list1 != null || list2 != null){
            if (list1!=null && list1.val <= list2.val ){
                    curr.next = list1;
                list1 = list1.next;
                curr = curr.next;
            }else {
                if (list2 !=null) {
                    curr.next = list2;
                    list2 = list2.next;
                    curr = curr.next;
                }
            }
        }
        return  result;
    }

    public static void main(String[] args) {
        Link_List list1 = new Link_List();
        list1.initList(1,3,5);
        Link_List list2 = new Link_List();
        list2.initList(2,4,6);
        Merge(list1.getFirstNode(),list2.getFirstNode());
    }
}

package divideandConquer;

import util.Link_List;
import util.ListNode;

/**
 * author： 张亚飞
 * time：2016/7/29  09:54
 */

//Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
    //合并k个有序链表，并分析其复杂度
public class MergekSortedLists_23 {

    public static ListNode mergeKLists2(ListNode[] lists){
        return partion(lists,0,lists.length-1);
    }

    public static ListNode partion(ListNode[] lists,int s,int e){
        if(s==e)  return lists[s];
        if(s<e){
            int q=(s+e)/2;
            ListNode l1=partion(lists,s,q);
            ListNode l2=partion(lists,q+1,e);
            return merge(l1,l2);
        }else
            return null;
    }

    //This function is from Merge Two Sorted Lists.
    public static ListNode merge(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next=merge(l1.next,l2);
            return l1;
        }else{
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }










    //超时
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 )
            return null;
        boolean b = false;
        for (int i = 0; i <lists.length ; i++) {
            if (lists[i] != null ){
                b = true;
            }
        }
        if (!b) return null;
        boolean flag = true;
        ListNode res  = new ListNode(getMin(lists));
        ListNode temp = res;
        while (flag){
            for (int i = 0; i <lists.length ; i++) {
                flag = false;
                if (lists[i] != null){
                    flag = true;
                    break;
                }
            }
            if (flag == false) break;
            temp.next = new ListNode(getMin(lists));
            temp = temp.next;
        }
        return res;
    }

    private static int getMin(ListNode[] lists){
            int min = Integer.MAX_VALUE;
            int site = -1;
        for (int i = 0; i <lists.length ; i++) {
            if (lists[i] !=null && lists[i].val < min){
                min = lists[i].val;
                site = i;
            }
        }
        if (site != -1){
            lists[site] = lists[site].next;
        }
        return min;
    }

    public static void main(String[] args) {
        Link_List list = new Link_List();
        list.initList(1,3);
        Link_List list1 = new Link_List();
        list1.initList(2,5);
        ListNode[] lists = new ListNode[2];
        lists[0] = list.getFirstNode();
        lists[1] = list1.getFirstNode();
        ListNode node =   mergeKLists(lists);
        System.out.println("ok");

    }
}

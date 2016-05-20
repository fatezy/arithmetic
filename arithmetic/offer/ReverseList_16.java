import util.Link_List;
import util.ListNode;

/**
 * author： 张亚飞
 * time：2016/5/20  17:38
 */
//逆转链表
public class ReverseList_16 {
    public static ListNode ReverseList(ListNode head) {
        if ((head == null) || (head.next == null)){
            return head;
        }

         ListNode curr = head;
        ListNode pre = null;
        ListNode nextNode ;
        while(curr!=null){
            nextNode = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nextNode;
        }
        return pre;

    }

    public static void main(String[] args) {
        Link_List list = new Link_List();
        list.initList(1,2,3,4,5);
        ReverseList(list.getFirstNode());
        System.out.println("ok");
    }


}

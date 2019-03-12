import leetCode.util.Link_List;
import leetCode.util.ListNode;

/**
 * author： 张亚飞
 * time：2016/5/19  22:27
 */
//题目描述
//
//        输入一个链表，输出该链表中倒数第k个结点。
public class FindKthToTail {
    //正数
    public ListNode FindKthToTail2(ListNode head, int k) {
        if (head == null)
            return head;
        int curr = 1;
        while (head != null){
            if (curr< k) {
                head = head.next;
                curr++;
            }else break;

        }
        if (curr<k){
            return null;
        }
        return head;
    }

    public static ListNode FindKthToTail(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr!=null){
            curr = curr.next;
            count++;
        }
        if (count<k){
            return null;
        }
        else {
            count = count - k;
        }
        for (int i = 0; i <count ; i++) {
            head = head.next;
        }
        return head;

    }

    public static void main(String[] args) {
        Link_List list = new Link_List();
        list.initList(1,2,3,4,5);
        FindKthToTail(list.getFirstNode(),1);
    }
}

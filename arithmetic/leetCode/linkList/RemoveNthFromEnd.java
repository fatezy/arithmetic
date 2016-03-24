/**
 * 
 */
package linkList;

import util.Link_List;
import util.ListNode;

/**
 * @author 张亚飞
 *从链表尾部移除第n个数据
 * @version 创建时间：2016年3月12日 下午9:18:59
 */
/**
 * Given linked list: 1->2->3->4->5, and n = 2.
  After removing the second node from the end, the linked list becomes 1->2->3->5.
 * 解题思想：定义两个节点，第一个节点从前往后遍历n个节点，第二个节点陪同第一个节点遍历余下节点，第二个
 * 节点遍历数刚好为n
 * 
 */
public class RemoveNthFromEnd {
	 public ListNode removeNthFromEnd(ListNode head, int n) {
		  	ListNode first = head;
				ListNode second = head;
				if (head.next == null)
					return null;
				while (n != 0) {
					first = first.next;
					n--;
				}
				if (first == null)
					return head.next;
				while (first.next != null) {
					first = first.next;
					second = second.next;
				}
				second.next = second.next.next;
				return head;
		}
	 
	 
	 public static void main(String[] args) {
			Link_List list = new Link_List();
			list.initList(3,4,5,6);
			RemoveNthFromEnd remove = new RemoveNthFromEnd();
			
			list.setFirstNode(remove.removeNthFromEnd(list.getFirstNode(), 1));
			//遍历时链表长度因移除数据而减小
			list.setSize(list.getSize()-1);
			list.print();
		}
}


package linkList;

import util.Link_List;
import util.ListNode;

/**
 * @author 张亚飞
 *单链表奇数偶数分离（奇偶指的是位数）
 * @version 创建时间：2016年3月12日 下午11:24:16
 */
//Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
//
//You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
//
//Example:
//Given 1->2->3->4->5->NULL,
//return 1->3->5->2->4->NULL.
public class OddEvenList {
	 public ListNode oddEvenList(ListNode head) {
		 if(head == null){
			 return null;
		 }
		//偶数
		 ListNode odd = head.next;
		 ListNode flag = head.next;
		 //奇数位
		 ListNode even  = head;
		 while(even != null&&even.next != null&&odd !=null&&odd.next != null){			 
			 even.next = even.next.next;
			 odd.next = odd.next.next;
			 odd = odd.next;
			 even = even.next;
			
		 }
		 even.next = flag;
		 return head;
	        
	    }
	
	public static void main(String[] args) {
		Link_List list = new Link_List();
		list.initList(3,4,5,6);
		OddEvenList remove = new OddEvenList();
		
		list.setFirstNode(remove.oddEvenList(list.getFirstNode()));
		//遍历时链表长度因移除数据而减小
		list.setSize(list.getSize()-1);
		list.print();
		

	}

}

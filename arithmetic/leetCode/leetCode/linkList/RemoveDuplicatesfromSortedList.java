/**
 * 
 */
package leetCode.linkList;

import leetCode.util.Link_List;
import leetCode.util.ListNode;

/**
 * @author 张亚飞
 *移除有序链表中重复的部分
 * @version 创建时间：2016年3月12日 下午9:29:37
 */
//Given a sorted linked list, delete all duplicates such that each element appear only once.
//
//For example,
//Given 1->1->2, return 1->2.
//Given 1->1->2->3->3, return 1->2->3.
public class RemoveDuplicatesfromSortedList {

	public ListNode deleteDuplicates(ListNode head){
		ListNode node = head;
		int value = 0 ;
		while(node != null&&node.next!=null){
			 value = node.val;
			if(value == node.next.val){
				node.next = node.next.next;
			}else{
				node = node.next;
			}
		}
		return head;
	}
	public static void main(String[] args) {
		Link_List list = new Link_List();
		list.initList(3,3,3,5,6);
		RemoveDuplicatesfromSortedList remove = new RemoveDuplicatesfromSortedList();
		
		list.setFirstNode(remove.deleteDuplicates(list.getFirstNode()));
		//遍历时链表长度因移除数据而减小
		list.setSize(list.getSize()-2);
		list.print();
		

	}

}

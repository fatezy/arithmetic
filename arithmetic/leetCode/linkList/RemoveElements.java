/**
 * 
 */
package linkList;

import util.Link_List;
import util.ListNode;

/**
 * @author 张亚飞
 *
 * @version 创建时间：2016年3月12日 下午9:51:45
 */
//Remove all elements from a linked list of integers that have value val.
//
//Example
//Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
//Return: 1 --> 2 --> 3 --> 4 --> 5
public class RemoveElements {

	 public ListNode removeElements(ListNode head, int val) {
		 if(head == null){
			 return null;
		 }
	  
	 while(head.val == val){
		 head = head.next;
		 if(head == null){
			 return null;
		 }
	 }
	
	 ListNode pre = head;
	   ListNode node= head.next;
	   while(node!=null){
		   if(node.val == val){
			   pre.next = node.next;
			   node = node.next;
		   }else{
			   pre = pre.next;
			   node = node.next;
		   }
	   }
	   
	        return head;
	    }
	public static void main(String[] args) {
		Link_List list = new Link_List();
//		list.initList(1,2,6,3,4,5,6);
		list.initList();
		RemoveElements remove = new RemoveElements();
		
		list.setFirstNode(remove.removeElements(list.getFirstNode(),1));
		//遍历时链表长度因移除数据而减小
//		list.setSize(list.getSize()-2);
//		list.print();
		

	}

}

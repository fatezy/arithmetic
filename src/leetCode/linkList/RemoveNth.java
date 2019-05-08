/**
 * 
 */
package leetCode.linkList;

import leetCode.util.Link_List;
import leetCode.util.ListNode;

/**
 * @author 张亚飞
 *移除链表第n个数据
 * @version 创建时间：2016年3月10日 下午7:19:57
 */
public class RemoveNth {
	public ListNode removeNth(ListNode head,int n){
		ListNode node  = head;
		
		if(n==1){
			head = head.next;
			
		}
		for(int i=0;i<n-2;i++){
			node = node.next;
		}
		if(n!= 1){
		node.next = node.next.next;
	
		}
		return head;
	}
	
	
	public static void main(String[] args) {
		Link_List list = new Link_List();
		list.initList(3,4,5,6);
		RemoveNth remove = new RemoveNth();
		
		list.setFirstNode(remove.removeNth(list.getFirstNode(), 1));
		list.setSize(list.getSize()-1);
		list.print();
	}
}

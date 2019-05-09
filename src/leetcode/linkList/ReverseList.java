/**
 * 
 */
package leetcode.linkList;

import leetcode.util.LinkList;
import leetcode.util.Node;

/**
 * @author 张亚飞
 *单链表逆置
 * @version 创建时间：2016年3月10日 下午3:23:28
 */
public class ReverseList<T> extends LinkList<T> {
	public Node<T> reverseList(){
		Node<T> node = this.getFirstNode();
		Node<T> front = this.getFirstNode();
		Node<T> p =  new Node<T>();
		if(node == null){
			return node;
		}else{
			node = node.next;
			while(node!=null){
				 p = node.next ;
				 node.next = front;
				 front = node;
				 node = p;
				
			}
		}
		this.setFirstNode(front);
		return front;
	}
	public static void main(String[] args) {
		ReverseList<Integer> linkList = new ReverseList<Integer>();
		linkList.initList(3,4,5);
		linkList.reverseList();
		linkList.printList();
	}
}

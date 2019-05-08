package offer.util;




/**
 * @author 张亚飞
 *
 * @version 创建时间：2016年3月5日 下午11:11:22
 */
public class MyLinkList<E> {
	/**
	 * 链表头指针
	 */
	Node<E> first ;
	/**
	 * 尾指针
	 */
	Node<E> last;
	/*
	 * 链表无参构造函数
	 */
	MyLinkList(){
		first.prev = null;
		first.item = null;
		first.next = null;
	}
	/**
	 * 链表有参构造函数
	 * @param a  链表构造数组
	 * @param n  数组的长度
	 */
	public MyLinkList(E a[],int n){
		first = new Node<E>(null,a[0],null);
		Node<E> p = first;
		for(int i = 0;i<n;i++){
			Node<E>  pNext = new Node<E>(p,a[i],null);
			p.next = pNext;
			p = p.next;
			if(i==n-1){
				last = pNext;
			}
		}
	}
	/**
	 * 打印链表
	 */
	
	public void printMyLinkList(){
		Node<E> p = first.next;
		while(p.item!=null){
			System.out.println(p.item);
			if(p.next!=null)
			    p= p .next;
			else
				break;
		}
	}
	/**
	 * 逆序打印链表
	 * @return void
	 */
	public void ReverseList(){
		Node<E> p = last;
		while(p.item!=null){
			System.out.println(p.item);
			if(p.prev.equals(first))
				break;
			if(p.prev!=null)
			    p= p.prev;
			else
				break;
		}
		
	}
	
	/**
	 * 自定义内部类 Node
	 * @author 张亚飞
	 *
	 * @version 创建时间：2016年3月5日 下午11:04:21
	 */
	 private static class Node<E> {
	        E item;
	        Node<E> next;
	        Node<E> prev;

	        Node(Node<E> prev, E element, Node<E> next) {
	            this.item = element;
	            this.next = next;
	            this.prev = prev;
	        }
	    }


}

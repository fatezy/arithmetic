/**
 * 
 */
package leetCode.util;

/**
 * @author 张亚飞
 *  链表节点
 * @version 创建时间：2016年3月10日 下午2:26:05
 */
public class Node<T> {
	public T value;
	public Node<T> next;
	
	/**
	 * 无参构造函数
	 */
	public Node() {
		super();
	}

/**
 * 有参构造函数
 * @param value
 * @param next
 */
	public Node(T value, Node<T> next){
		this.value = value;
		this.next = next;
	}
}

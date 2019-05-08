/**
 * 
 */
package leetCode.util;

/**
 * @author 张亚飞
 * 泛型单链表
 * @version 创建时间：2016年3月10日 上午10:46:26
 */
public class LinkList<T> {
	private Node<T> currentNode;
	private Node<T> firstNode;
	private Node<T> lastNode;
	private int size;
	
	
	public LinkList() {
		super();
	}
	
	
	/**
	 * 初始化方法
	 * @param values
	 * @return
	 */
	public Node<T> initList(@SuppressWarnings("unchecked") T...values){
		
		for(T value:values){
			Node<T> node = new Node<T>();
			node.value = value;
			if(firstNode == null){
				firstNode = node;
				currentNode =node;
				lastNode = node;
			}else{
				lastNode.next = node;
				lastNode = lastNode.next;
			}
			size++;
		}
		return firstNode;
	}
	
	
	
	/**
	 * 添加一个新元素
	 * @param item
	 */
	public void add(T item){
		Node<T> node = new Node<T>();
		node.value = item;
		if(firstNode == null){
			firstNode = node;
			currentNode = node;
		}else{
			lastNode.next = node;
			lastNode = lastNode.next;
		}
		size++;
	}
	/**
	 * 打印链表
	 */
	public void printList(){
		Node<T> node = firstNode;
		System.out.print("链表的值为：[");
		for(int i= 0;i<size;i++){
			if(i<size-1){
			System.out.print(node.value+"  ");
			node = node.next;
			}else{
				System.out.print(node.value);
				node = node.next;
			}
		}
		System.out.println("]");
	}
	
	
	public Node<T> getCurrentNode() {
		return currentNode;
	}
	public void setCurrentNode(Node<T> currentNode) {
		this.currentNode = currentNode;
	}
	public Node<T> getFirstNode() {
		return firstNode;
	}
	public void setFirstNode(Node<T> firstNode) {
		this.firstNode = firstNode;
	}
	public Node<T> getLastNode() {
		return lastNode;
	}
	public void setLastNode(Node<T> lastNode) {
		this.lastNode = lastNode;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	

}

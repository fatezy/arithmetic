/**
 * 
 */
package leetcode.util;

/**
 * @author 张亚飞
 *单链表
 * @version 创建时间：2016年3月10日 下午7:23:43
 */
public class Link_List {
	
	  private ListNode firstNode;
	  private ListNode lastNode;
	  private int size;
	  
	  
	  
	  public Link_List() {
			super();
		}
	  
	/**
	 * 初始化方法
	 * @param values
	 * @return
	 */
	public ListNode initList(int...vals){
		for(int val : vals){
			ListNode node = new ListNode(val);
			if(firstNode == null){
				firstNode =node;
				lastNode = node;
			}else{
				lastNode.next = node;
				lastNode = lastNode.next;
			}
			size++;
		}
		
        return firstNode;
	}
	
	public void print(){
		ListNode node = firstNode;
		System.out.print("链表的值为：[");
		for(int i= 0;i<size;i++){
			if(i<size-1){
			System.out.print(node.val+"  ");
			node = node.next;
			}else{
				System.out.print(node.val);
				node = node.next;
			}
		}
		System.out.println("]");
	}
	
	
	public ListNode getFirstNode() {
		return firstNode;
	}
	public void setFirstNode(ListNode firstNode) {
		this.firstNode = firstNode;
	}
	public ListNode getLastNode() {
		return lastNode;
	}
	public void setLastNode(ListNode lastNode) {
		this.lastNode = lastNode;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}
package week4_0327;

/**
 * 用双向链表实现LRU算法
 * 
 * @author liuxin
 *
 */
public class LRUPageFrame {
	
	private static class Node {
		
		Node prev;
		Node next;
		int pageNum;

		Node(int pageNum) {
			this.pageNum = pageNum;
		}
	}

	private int capacity;
	
	private int currentSize;
	private Node first;// 链表头
	private Node last;// 链表尾

	
	public LRUPageFrame(int capacity) {
		this.currentSize = 0;
		this.capacity = capacity;
		
	}

	/**
	 * 获取缓存中对象
	 * 
	 * @param key
	 * @return
	 */
	public void access(int pageNum) {
		if(isEmpty()){
			initFirstNode(pageNum);
			return;
		}
		if (contains(pageNum)) {
			moveToFirst(pageNum);
		} else {
			insert(pageNum);
		}
	}
	
	public void initFirstNode(int pageNum) {
		Node node = new Node(pageNum);
		first = last = node;
		currentSize ++;
	}
	
	public void moveToFirst(int pageNum) {
		if (isFirst(pageNum)) {
			return;
		}
		if (isLast(pageNum)) {
			moveLastToFirst();
		} else {
			moveMidToFirst(pageNum);
		}
	}
	
	public void moveLastToFirst() {
		Node temp = last;
		removeLast();
		addToFirst(temp);
	}
	
	public void addToFirst(Node temp) {
		temp.next = first;
		first.prev = temp;
		first = temp;
		currentSize ++;
	}
	
	public void removeLast() {
		Node temp = last.prev;
		temp.next = null;
		last = temp;
		currentSize --;
	}
	
	public void moveMidToFirst(int pageNum) {
		Node node = removeMidNode(pageNum);
		addToFirst(node);
	}
	
	public Node removeMidNode(int pageNum) {
		Node temp = getNode(pageNum);
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
		temp.next = null;
		temp.prev = null;
		currentSize --;
		return temp;
	}
	
	public boolean isEmpty(){
		return currentSize == 0;
	}
	
	public void insert(int pageNum) {
		if (isFull()){
			removeLast();
		}
		insertToFirst(pageNum);
	}
	
	public void insertToFirst(int pageNum) {
		Node node = new Node(pageNum);
		addToFirst(node);
	}
	
	public boolean isFull() {
		return currentSize == capacity;
	}
	
	public boolean isFirst(int pageNum) {
		return first.pageNum == pageNum;
	}
	
	public boolean isLast(int pageNum) {
		return last.pageNum == pageNum;
	}
	
	public Node getNode(int pageNum) {
		Node temp = first;
		for (int i = 0; i< currentSize; i++){
			if (temp.pageNum == pageNum) {
				break;
			}
			temp = temp.next;
		}
		return temp;
	}
	
	public boolean contains(int pageNum) {
		return indexOf(pageNum) != -1;
	}
	
	public int indexOf(int pageNum) {
		Node temp = first;
		for (int i = 0; i< currentSize; i++) {
			if (temp.pageNum == pageNum) {
				return i;
			}
			temp = temp.next;
		}
		return -1;
	}
	
	public String toString(){
		StringBuilder buffer = new StringBuilder();
		Node node = first;
		while(node != null){
			buffer.append(node.pageNum);			
			
			node = node.next;
			if(node != null){
				buffer.append(",");
			}
		}
		return buffer.toString();
	}
	
	

}

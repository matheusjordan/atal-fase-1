package atal;

public class Node<T> {
	private T value;
	private Node next;
//	private Node previous;
	
	public Node(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

//	public void setValue(T value) {
//		this.value = value;
//	}

	public Node getNext() {
		return next;
	}
	
	public boolean hasNext() {
		return next != null;
	}

	public void setNext(Node next) {
		this.next = next;
	}

//	public Node getPrevious() {
//		return previous;
//	}
//
//	public void setPrevious(Node previous) {
//		this.previous = previous;
//	}
	
	
}

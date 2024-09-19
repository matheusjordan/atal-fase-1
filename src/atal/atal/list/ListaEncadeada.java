package atal.list;

import atal.Node;

public class ListaEncadeada<T> {
	private Node<T> head;
	private Node<T> tail;
	private int inserted;
	
	public void add(T item) {
		var node = createNode(item);

		if (head == null) {
			head = node;
		} else {
			var current = head;
			
			while (current.hasNext()) {
				current = current.getNext();
			}
			
			current.setNext(node);
		}
		
		tail = node;
		inserted++;
	}
	
	public T get(int index) {
		validateIndex(index);
		
		var current = head;
		int counted = 0;
		
		while (current != null && counted != index) {
			current = current.getNext();
			counted++;
			
		}
		
		return current.getValue();
	}
	
	public void remove() {
		var current = head;
		
		while (current != null) {
			var next = current.getNext(); 
			if (current.hasNext() && next.equals(tail)) {
				current.setNext(null);
				tail = current;
			}
			
			current = next;
		}
		
		inserted--;
	}
	
	public int size() {
		return inserted;
	}
	
	private void validateIndex(int index) {
		if (index >= inserted || index < 0) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	@SuppressWarnings("unchecked")
	private Node<T> createNode(T item) {
		return new Node<T>(item);
	}
	
	@SuppressWarnings("unchecked")
	public void showItems() {
		var current = head;
		while (current != null) {
			System.out.println(current.toString());
			current = current.getNext();
		}
	}
}

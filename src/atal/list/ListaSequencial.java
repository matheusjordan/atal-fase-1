package atal.list;

public class ListaSequencial<T> {
	private static final int INITIAL_ALLOCATION = 3;
	private static final int INCREASE_FACTOR = 2;
	private T[] list;
	private int inserted;
	
	public ListaSequencial() {
		list = createArray(INITIAL_ALLOCATION);
	}
	
	public void add(T item) {
		if (list.length == inserted) {
			resizeArray();
		}
		
		list[inserted] = item;
		inserted++;
	}
	
	public T get(int index) {
		validateIndex(index);

		return list[index];
	}
	
	public void remove() {
		list[inserted - 1] = null;
		inserted--;
	}
	
	public void remove(int index) {
		list[index] = null;
		
		if (index < inserted) {
			moveArrayItems(index);
		}
		inserted--;
	}
	
	public int size() {
		return inserted;
	}
	
	public void showItems() {
		for (int i = 0; i < inserted; i++) {
			System.out.println(list[i]);
		}
		
		System.out.println();
	}
	
	public boolean isEmpty() {
		return inserted == 0;
	}
	
	private void moveArrayItems(int initialIndex) {
		int nextIndex = initialIndex + 1;
		
		while(nextIndex < inserted) {
			list[initialIndex] = list[nextIndex];
			nextIndex++;
			initialIndex++;
		}
		
		list[nextIndex] = null;
	}
	
	
	private void resizeArray() {
		T[] newList = createArray(list.length * INCREASE_FACTOR);
		
		for (int i = 0; i < list.length; i++) {
			newList[i] = list[i];
		}
		
		list = newList;
	}
	
	private void validateIndex(int index) {
		if (index >= inserted || index < 0) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	@SuppressWarnings("unchecked")
	private T[] createArray(int size) {
		return (T[]) new Object[size];
	}
}

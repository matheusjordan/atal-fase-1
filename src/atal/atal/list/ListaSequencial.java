package atal.list;

import atal.app1.models.EBook;
import atal.app1.models.SortBy;

public class ListaSequencial {
	private static final int INITIAL_ALLOCATION = 3;
	private static final int INCREASE_FACTOR = 2;
	private EBook[] list;
	private int inserted;
	
	public ListaSequencial() {
		list = createArray(INITIAL_ALLOCATION);
	}
	
	public void add(EBook item) {
		if (list.length == inserted) {
			resizeArray();
		}
		
		list[inserted] = item;
		inserted++;
	}
	
	public EBook get(int index) {
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
	
	public void sort() {
		quickSort();
	}
	
	private void quickSort() {
		int leftIndex = 0;
		int rigthIndex = inserted - 1;

		if (inserted > 1) {
			quickSortPartitioning(list, leftIndex, rigthIndex);
		}	
	}
	
	private void quickSortPartitioning(EBook[] items, int leftIndex, int rigthIndex) {
		if (leftIndex >= rigthIndex) {
			return;
		}
		
		System.out.println(toString());
		
		int i = leftIndex,
			j = rigthIndex,
			pivotIndex = 0;
		
		Integer nextPivotIndex = null;
		pivotIndex = (int) (leftIndex + rigthIndex) / 2;
		EBook pivot = list[pivotIndex];
		
		while (nextPivotIndex == null) {
			while(items[i].getPublishDate() < pivot.getPublishDate()) {
				i++;
			}
			
			while(items[j].getPublishDate() > pivot.getPublishDate()) {
				j--;
			}
			
			if (i >= j) {
				nextPivotIndex = j;
			} else {
				EBook aux = items[i];
				items[i] = items[j];
				items[j] = aux;
				i++;
				j--;
			}
			
		}
		
		
		quickSortPartitioning(items, leftIndex, nextPivotIndex);
		quickSortPartitioning(items, nextPivotIndex + 1, rigthIndex);	
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
		EBook[] newList = createArray(list.length * INCREASE_FACTOR);
		
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
	
	private EBook[] createArray(int size) {
		return new EBook[size];
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		
		books:
		for (EBook book : list) {
			if (book == null) {
				break books;
			} else {
				sb.append(book.getPublishDate());
				sb.append(" ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}

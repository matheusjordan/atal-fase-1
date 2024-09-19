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
			quickSortPartioning(list, leftIndex, rigthIndex);
		}	
	}
	
	private void quickSortPartioning(EBook[] items, int leftIndex, int rigthIndex) {
		if (leftIndex < rigthIndex) {
			return;
		}
		
		int i = leftIndex - 1,
			j = rigthIndex + 1,
			pivotIndex = 0;
		
		Integer nextPivotIndex = null;
		pivotIndex = (int) (leftIndex + rigthIndex) / 2;
		EBook pivot = list[pivotIndex];
		
		while (nextPivotIndex == null) {
			do {
				i++;
			} while(items[i].getPublishDate() < pivot.getPublishDate());
			
			do {
				j--;
			} while(items[j].getPublishDate() > pivot.getPublishDate());
			
			if (i >= j) {
				nextPivotIndex = j;
			} else {
				EBook aux = list[i];
				list[i] = list[j];
				list[j] = aux;	
			}
			
		}
		
		quickSortPartioning(list, leftIndex, pivotIndex);
		quickSortPartioning(list, pivotIndex + 1, rigthIndex);
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
}

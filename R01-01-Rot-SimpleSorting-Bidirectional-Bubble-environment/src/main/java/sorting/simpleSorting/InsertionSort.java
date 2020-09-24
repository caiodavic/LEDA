package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		T chave;
		for(int j =1; j< array.length;j++){
			chave = array[j];
			int i = j-1;
			while(i>-1 && array[i].compareTo(chave) > 0){
				array[i+1] = array[i];
				i = i-1;
			}
			array[i+1] = chave;
		}

	}
}

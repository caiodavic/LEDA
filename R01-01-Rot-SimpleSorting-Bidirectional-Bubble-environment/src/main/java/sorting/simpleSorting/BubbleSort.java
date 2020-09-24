package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	Util util = new Util();

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		boolean swapped = true;
		int i = 0;
		while (swapped == true){
			swapped = false;
			T aux;
			for(int j =0; j < array.length - i -1; j++){
				if(array[j].compareTo(array[j+1]) > 0){
					util.swap(array,j,j+1);
					swapped = true;

				}
			}
			i++;
		}
	}
}

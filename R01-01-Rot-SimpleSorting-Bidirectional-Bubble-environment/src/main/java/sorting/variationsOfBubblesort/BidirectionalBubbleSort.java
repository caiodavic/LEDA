package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	Util util = new Util();

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		boolean swapped = true;
		T aux;
		int inicio = 0;
		int fim = array.length - 1;
		while (swapped == true && inicio < fim){
			swapped = false;
			for(int i =inicio; i<fim;i++) {
				if (array[i].compareTo(array[i + 1]) > 0) {
					util.swap(array,i,i+1);
					swapped = true;
				}
			}
			fim--;
				for(int i = fim; i > inicio; i--){
					if(array[i].compareTo(array[i - 1]) < 0){
						util.swap(array,i,i-1);
						swapped = true;
				}
			}
			inicio++;
		}
	}
}

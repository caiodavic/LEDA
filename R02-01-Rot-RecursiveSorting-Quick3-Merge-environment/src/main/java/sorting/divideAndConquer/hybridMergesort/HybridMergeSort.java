package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	Util util = new Util();
	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		HybridMergeSort.MERGESORT_APPLICATIONS = 0;
		HybridMergeSort.INSERTIONSORT_APPLICATIONS = 0;

		if(leftIndex >= 0 && rightIndex < array.length && leftIndex<rightIndex){
			if(rightIndex-leftIndex<=SIZE_LIMIT){
				insertionSort(array,leftIndex,rightIndex);
			} else{
				mergeSort(array,leftIndex,rightIndex);
			}
		}
	}

	private void mergeSort(T[] array, int leftIndex, int rightIndex){
		if(leftIndex >= 0 && rightIndex< array.length && leftIndex<rightIndex) {
			HybridMergeSort.MERGESORT_APPLICATIONS++;

			int middle = (leftIndex + rightIndex) / 2;

			sort(array, leftIndex, middle);
			sort(array, middle+1, rightIndex);

			merge(array, leftIndex, middle, rightIndex);

		}
	}

	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {

			HybridMergeSort.INSERTIONSORT_APPLICATIONS++;

			for (int j = leftIndex + 1; j <= rightIndex; j++) {
				int i = j;
				while (i > leftIndex && array[i].compareTo(array[i - 1]) < 0) {
					util.swap(array, i, i - 1);
					i -= 1;
				}
			}
		}
	}

	private void merge(T[] array, int leftIndex, int middle, int rightIndex){
		T[] helper = (T[]) new Comparable[array.length];
		for(int i = leftIndex; i<=rightIndex;i++){
			helper[i] = array[i];
		}

		int i = leftIndex;
		int j = middle+1;
		int k = leftIndex;

		while(i<= middle && j<=rightIndex){
			if(helper[i].compareTo(helper[j])<0){
				array[k] = helper[i];
				i++;
				k++;
			} else {
				array[k] = helper [j];
				j++;
				k++;
			}
		}

		while(i<=middle){
			array[k] = helper[i];
			i++;
			k++;
		}

		while(j<=rightIndex){
			array[k] = helper[j];
			j++;
			k++;
		}


	}

}

package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(leftIndex >= 0 && rightIndex < array.length && leftIndex<rightIndex){
			extendedCoutingSort(array,leftIndex,rightIndex);
		}

	}

	public void extendedCoutingSort(Integer[] array, int leftIndex, int rightIndex){
		int lowest = findLowest(array,leftIndex,rightIndex);
		int highest = findHighest(array,leftIndex,rightIndex);

		Integer[] arrayC = new Integer[highest - lowest + 1];

		populate(arrayC);

		for(int i = leftIndex;i<=rightIndex;i++){
			arrayC[array[i] - lowest]++;
		}

		for(int i = 1; i< arrayC.length;i++){
			arrayC[i] += arrayC[i-1];
		}

		Integer[] arrayB = new Integer[array.length];

		for(int i = rightIndex;i>=leftIndex;i--){
			arrayB[arrayC[array[i]-lowest]-1 + leftIndex] = array[i];
			arrayC[array[i]-lowest]--;
		}

		copy(array,arrayB,leftIndex,rightIndex);

	}

	public int findHighest(Integer[] array, int leftIndex, int rightIndex){
		int highest = array[leftIndex];

		for(int i = leftIndex; i<=rightIndex;i++) {
			if (array[i] > highest) highest = array[i];
		}
		return highest;
	}

	public int findLowest(Integer[] array, int leftIndex, int rightIndex){
		int lowest = array[leftIndex];

		for(int i = leftIndex; i<=rightIndex;i++) {
			if (array[i] < lowest) lowest = array[i];
		}
		return lowest;
	}

	public void populate(Integer[] array){
		for(int i = 0; i< array.length ;i++){
			array[i] = 0;
		}
	}

	public void copy(Integer[] array, Integer[] arrayB, int leftIndex, int rightIndex){
		for(int i = leftIndex; i <= rightIndex; i++){
			array[i] = arrayB[i];
		}

	}

}

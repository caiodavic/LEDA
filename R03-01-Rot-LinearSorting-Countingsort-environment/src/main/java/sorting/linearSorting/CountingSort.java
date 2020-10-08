package sorting.linearSorting;

import sorting.AbstractSorting;

import javax.naming.InterruptedNamingException;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Voce pode assumir que o maior inteiro armazenado não chega a 100.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(leftIndex >= 0 && rightIndex < array.length && leftIndex<rightIndex){
			coutingSort(array,leftIndex,rightIndex);
		}
	}
	public void coutingSort(Integer[] array, int leftIndex, int rightIndex){
		int k = findK(array,leftIndex,rightIndex);
		Integer[] arrayC = new Integer[k+1];

		populate(arrayC,k);

		for(int i = leftIndex; i<=rightIndex ;i++){
			arrayC[array[i]]++;
		}

		for(int i = 1; i<=k; i++){
			arrayC[i] += arrayC[i-1];
		}

		Integer[] arrayB = new Integer[array.length];

		for(int i = rightIndex; i>=leftIndex;i--){
			arrayB[arrayC[array[i]]-1 + leftIndex] = array[i];
			arrayC[array[i]]--;
		}

		copy(array,arrayB, leftIndex,rightIndex);

	}

	public void populate(Integer[] array, int k){
		for(int i = 0; i<=k ;i++){
			array[i] = 0;
		}
	}

	public int findK(Integer[] array, int leftIndex, int rightIndex){
		int k = array[leftIndex];

		for(int i = leftIndex; i<=rightIndex;i++) {
			if (array[i] > k) k = array[i];
		}
		return k;
	}

	public void copy(Integer[] array, Integer[] arrayB, int leftIndex, int rightIndex){
		for(int i = leftIndex; i <= rightIndex; i++){
			array[i] = arrayB[i];
		}

	}

}

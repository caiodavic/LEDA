package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

		Util util = new Util();

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (leftIndex < rightIndex) {

			int indiceDoMenor = leftIndex;
			for (int j = leftIndex + 1; j < array.length; j++) {
				if (array[j].compareTo(array[indiceDoMenor]) < 0) {
					indiceDoMenor = j;
				}
			}
			util.swap(array, leftIndex, indiceDoMenor);
			sort(array, leftIndex + 1, rightIndex);


		}
	}

}

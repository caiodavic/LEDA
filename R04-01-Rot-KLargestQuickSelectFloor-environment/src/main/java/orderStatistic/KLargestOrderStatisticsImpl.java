package orderStatistic;

import util.Util;

/**
 * Uma implementacao da interface KLargest que usa estatisticas de ordem para 
 * retornar um array com os k maiores elementos de um conjunto de dados/array.
 *
 * A k-esima estatistica de ordem de um conjunto de dados eh o k-esimo menor
 * elemento desse conjunto. Por exemplo, considere o array [4,8,6,9,12,1]. 
 * A 3a estatistica de ordem eh 6, a 6a estatistica de ordem eh 12.
 *
 * Note que, para selecionar os k maiores elementos, pode-se pegar todas as 
 * estatisticas de ordem maiores que k. 
 *
 * Requisitos do algoritmo:
 * - DEVE ser in-place. Voce pode modificar o array original
 * - Voce DEVE usar alguma ideia de algoritmo de ordenacao visto em sala 
 *   para calcular estatisticas de ordem. 
 *
 * @author Adalberto
 *
 * @param <T>
 */
public class KLargestOrderStatisticsImpl<T extends Comparable<T>> implements KLargest<T>{

	@Override
	public T[] getKLargest(T[] array, int k) {

		if(array.length >= 1 && k <= array.length && k > 0) {
			T[] KLargests = (T[]) new Comparable[k];
			int cont = 0;
			for(int i = array.length-k; i< array.length;i++){
				KLargests[cont] = orderStatistics(array,i+1);
				cont++;
			}
			return KLargests;
		}
		return null;
	}

	/**
	 * Metodo que retorna a k-esima estatistica de ordem de um array, usando
	 * a ideia de algum algoritmo de ordenacao visto em sala. Caso nao exista 
	 * a k-esima estatistica de ordem, entao retorna null.
	 *
	 * Obs: o valor de k deve ser entre 1 e N.
	 *
	 * @param array
	 * @param k
	 * @return
	 */
	public T orderStatistics(T[] array, int k){

		if(k <= array.length && k > 0)
			return quickSelectPortion(array,0,array.length-1,k);
		else return null;
	}

	private T quickSelectPortion(T[] array, int leftIndex, int rightIndex, int k){

		if(leftIndex < rightIndex){
			int indexPivot = partition(array,leftIndex,rightIndex);
			if(k-1 > indexPivot) return quickSelectPortion(array,indexPivot+1, rightIndex,k);
			else if(k-1 < indexPivot) return quickSelectPortion(array,leftIndex,indexPivot-1,k);
			else return array[indexPivot];
		} else if(leftIndex == rightIndex){
			return array[leftIndex];
		} else {
			return null;
		}
	}

	private int partition(T[] array,int leftIndex, int rightIndex){
		int indexPivot = pickPivotIndex(array,leftIndex,rightIndex);
		Util.swap(array,indexPivot, rightIndex-1);
		T pivot = array[rightIndex-1];
		int i = rightIndex-1;

		for(int j = rightIndex-2;j>=leftIndex;j--){
			if(array[j].compareTo(pivot) >= 0){
				i-=1;
				Util.swap(array,i,j);
			}
		}

		Util.swap(array,rightIndex-1,i);
		return i;
	}

	private int pickPivotIndex(T[] array, int leftIndex, int rightIndex){
		int middle = (leftIndex+rightIndex)/2;

		if(array[rightIndex].compareTo(array[middle])<0) Util.swap(array,rightIndex,middle);
		if(array[middle].compareTo(array[leftIndex])<0) Util.swap(array,middle,leftIndex);
		if(array[rightIndex].compareTo(array[middle])<0) Util.swap(array,rightIndex,middle);

		return middle;
	}
}

package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		quickSort(array,0,array.length-1);
		return binarySearch(array,0,array.length-1,x);
	}

	private Integer binarySearch(Integer[] array, int leftIndex, int rightIndex, Integer x){
		if(leftIndex > rightIndex) return null;
		if(x.compareTo(array[leftIndex]) < 0) return null;

		int middle = (rightIndex+leftIndex)/2;

		if(x.compareTo(array[rightIndex]) >= 0) return array[rightIndex];
		if(middle == leftIndex) return array[leftIndex];
		if(array[middle].compareTo(x) == 0) return array[middle];
		else if(array[middle].compareTo(x)<0)return binarySearch(array,middle,rightIndex,x);
		else return binarySearch(array,leftIndex,middle-1,x);
	}

	private void quickSort(Integer[] array,int leftIndex, int rightIndex){
		if(leftIndex >= 0 && rightIndex < array.length && leftIndex<rightIndex){
			int indexPivot = partition(array,leftIndex,rightIndex);
			quickSort(array,leftIndex,indexPivot-1);
			quickSort(array,indexPivot+1,rightIndex);
		}
	}

	private int partition(Integer[] array, int leftIndex, int rightIndex){
		int indexPivot = pickPivotIndex(array,leftIndex,rightIndex);
		Util.swap(array,indexPivot, rightIndex-1);
		Integer pivot = array[rightIndex-1];
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

	private int pickPivotIndex(Integer[] array, int leftIndex, int rightIndex){
		int middle = (leftIndex+rightIndex)/2;

		if(array[rightIndex].compareTo(array[middle])<0) Util.swap(array,rightIndex,middle);
		if(array[middle].compareTo(array[leftIndex])<0) Util.swap(array,middle,leftIndex);
		if(array[rightIndex].compareTo(array[middle])<0) Util.swap(array,rightIndex,middle);

		return middle;
	}




}

package Sorting_Algorithms;

/**
 * 
 * @author anask in place algorithm complexity time is O(n�2) stable algorithm
 */
class Insertion_Sort {
	static int[] insertionSort(int[] array1){
		int[] array=array1;
		for(int firstUnsortedIndex=1;firstUnsortedIndex<array.length;firstUnsortedIndex++){
			int element=array[firstUnsortedIndex];
			int i;
			for(i=firstUnsortedIndex;i>0 && array[i-1]>element;i--){
				array[i]=array[i-1];
			}
			array[i]=element;
		}
		return array;
	}

	public static void main(String[] args) {
		int[] intArray = { -15, 23, 65, 22, 51, -5, 0, 53 };
		for(int e:insertionSort(intArray))
			System.out.println(e);
	}

}

package Sorting_Algorithms;

/**
 * 
 * @author anask
 * this algorithm shows the bubble sorting, which is: in-place
 * sorting o(n�2) time complexity.
 * unstable algorithm
 * Auswahlsortieren.
 */
class Selection_Sort {
	static int[] selectioinSort(int[] array1){
		int[] array=array1;
		for(int lastUnsortedIndex=array.length-1;lastUnsortedIndex>0;lastUnsortedIndex--){
			int largestIndex=0;
			for(int i=1;i<=lastUnsortedIndex;i++){
				if(array[i]>array[largestIndex])
					largestIndex=i;

				int temp=array[largestIndex];
				array[largestIndex]=array[lastUnsortedIndex];
				array[lastUnsortedIndex]=temp;
			}
		}
		return array;
	}

	public static void main(String[] args) {
		int[] intArray = { -15, 23, 65, 22, 51, -5, 0 };
		for(int e:selectioinSort(intArray))
			System.out.println(e);
	}
}

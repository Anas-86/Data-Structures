package Sorting_Algorithms;

/**
 * 
 * @author anask this algorithm shows the bubble sorting, which is: in-place
 *         sorting o(n�2) time complexity
 */
class Bubble_Sort {
	public static void main(String[] args) {
		int[] intArray = { -15, 23, 65, 22, 51, -5, 0 }; // intArray.length=7

		for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
			for (int i = 0; i < lastUnsortedIndex; i++) {
				if (intArray[i] > intArray[i + 1]) {
					int temp = intArray[i];
					intArray[i] = intArray[i + 1];
					intArray[i + 1] = temp;
				}
			}

		}
		for (int e : intArray) {
			System.out.println(e);
		}

	}
}

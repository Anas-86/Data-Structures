package Sorting_Algorithms;

/**
 * 
 * @author anask
 * pay attention to the fact that binary search is only and only applicable to sorted structures.
 * for example, sorted arrays, sorted linkedlists and so on.
 */

public class Binary_Search {
	public static void main(String[] args) {
		int[] intArray= {-11,-15,1,7,20,35,55};
		
//		Buble_search obj=new Buble_search();
//		System.out.println(iterativeBinarySearch(intArray,15));
//		System.out.println(iterativeBinarySearch(intArray,-15));
//		System.out.println(iterativeBinarySearch(intArray,35));
//		System.out.println(iterativeBinarySearch(intArray,-55));
		
		
		System.out.println(recursiveBinarySearch(intArray,15));
		System.out.println(recursiveBinarySearch(intArray,-15));
		System.out.println(recursiveBinarySearch(intArray,35));
		System.out.println(recursiveBinarySearch(intArray,-55));
		
		
		
	}
	
	public static int iterativeBinarySearch(int[] input, int value) {
		int start=0;
		int end=input.length;
		
		while(start<end) {
			int midpoint= (start+end)/2;
			if(input[midpoint]==value) {
				return midpoint;
			}
			else if(input[midpoint]<value) {
				start=midpoint+1;
			}
			else {
				end=midpoint;
			}
		}
		return -1;
	}
	
	public static int recursiveBinarySearch(int[] input, int value) {
		return recursiveBinarySearch(input,0,input.length,value);
	}
	
	public static int recursiveBinarySearch(int[] input, int start, int end, int value) {
		if(start>=end) {
			return -1;
		}
		int midpoint=(start+end)/2;
		System.out.println("midpoint = "+midpoint);
		
		if(input[midpoint]==value) {
			return midpoint;
		}
		else if(input[midpoint]<value) {
			return recursiveBinarySearch(input, midpoint+1, end, value);
		}
		else {
			return recursiveBinarySearch(input, start, midpoint, value);
		}
	}
}

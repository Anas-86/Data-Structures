package Sorting_Algorithms;

/*
 * the time complexity of this algorithm is O(nLog(n)) where Log here is to base 2.
 * and that is because we divide the array repeatedly in halves. 
 * the worst case is O(n^2), and happens when the pivot element is the minimum or maximum
 * that happens sometimes when the pivot element is chosen to be the first or last
 * element in a sorted array.
 * and the best case O(nLogn) where Log here is to base 2.
 * 
 */
class Quick_Sort {
	public static void main(String[] args) {
		int[] intArray = { -15, 23, 65, 22, 51, -5, 0 }; // intArray.length=7
		
		quickSort(intArray,0,intArray.length);
		
		for(int e:intArray)
			System.out.println(e);
		
	}
	
	public static void quickSort(int[] input,int start,int end) {
		if(end-start<2) {
			return;
		}
		
		int pivotIndex=partition(input,start,end);
		quickSort(input,start,pivotIndex);		//recursive call
		quickSort(input,pivotIndex+1,end);		//recursive call
		
		
	}
	
	public static int partition(int[] input,int start,int end) {
		//this is using the first element as the pivot
		int pivot=input[start];
		int i=start;		//i traverses from left to right.
		int j=end;			//j traverses from right  to left.
		
		while(i<j) {
			//note: the following loop is an empty loop body, and its main
			//purpose is decrementing j until we either find an element less than
			//the pivot or j crosses i.
			while(i<j && input[--j]>=pivot);		//the value of j that breaks this loop is going to be used in the following line of if(i<j)
			
			if(i<j) {					//if i has not crossed j, we want to move the element 
				input[i]=input[j];		//in position j to the position i
				
			}
			//note: the following loop is an empty loop body, and its main
			//purpose is incrementing i until we either find an element greater than
			//the pivot or j crosses i.
			while(i<j && input[++i]<=pivot);		//the value of i that breaks this loop is going to be used in the following line of if(i<j)

            if(i<j) {
				input[j]=input[i];
			}
			
			//notice:
			//here when you get out one of the inner while loops, you get out only
			//because the input[--j]>=pivot or input[++i]<=pivot has been broken.
			//because breaking the i<j in one of them is going to break the upper level
			//while loop.
		}
		input[j]=pivot;			//or instead you could replace j with i in this line, but also in the next line if you do so.
		return j;
		
	}
}

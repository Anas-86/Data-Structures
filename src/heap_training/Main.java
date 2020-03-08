package heap_training;

class Main {
	public static void main(String[] args) {
		Heap heap=new Heap(10);
		heap.insert(2);
		heap.insert(9);
		heap.insert(3);
		heap.insert(8);
		heap.insert(4);
		heap.insert(6);
		heap.insert(5);
		heap.insert(1);
		heap.insert(21);
		
		System.out.println("the heap is: ");
		heap.printHeap();
		
		System.out.println("the peak is: "+heap.peak());
		System.out.println();
		
		heap.delete(0);
		System.out.println("after deleting the peak: ");
		heap.printHeap();
		System.out.println("the peak is now: "+heap.peak());
		
		
	}
}

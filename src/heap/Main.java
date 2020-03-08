package heap;

class Main {
	public static void main(String[] args) {
		Heap heap=new Heap(10);
		
		heap.insert(80);
		heap.insert(75);
		heap.insert(60);
		heap.insert(68);
		heap.insert(55);
		heap.insert(40);
		heap.insert(52);
		heap.insert(67);
		
		heap.printHeap();
		
		System.out.println("\nthe peak is: ");
		System.out.println(heap.peak());
		System.out.println();
		
		heap.delete(0);		//here we give the index of the node to be deleted.
		System.out.println("\nafter deletion");
		heap.printHeap();
		
		System.out.println("\nthe peak after the deletion is: ");
		System.out.println(heap.peak());
		System.out.println();
		
	}
}

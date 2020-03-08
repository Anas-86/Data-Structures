package heap;

/**
 * 
 * @author anask important notes for the heap: insertion complexity time is
 *         O(log(n)).
 * 
 *         this heap is a max heap, which means that the root has the highest
 *         value. unlike the min heap whose root has the smallest value.
 *
 *         for deleting with having the index it is also O(log(n)) (because the
 *         heap needs to be fixed).
 * 
 *         for deleting with having the value to be deleted and not its index it
 *         is O(n*log(n)) (n comes from the linear search and log(n) comes from
 *         having to fix the heap.
 * 
 *         normally, when working with the heap, the root node is the one aimed
 *         to be deleted and in this case the complexity time would be O(log(n))
 *         (comes from having to fix the heap) and the root is in index 0.
 * 
 *         heap is normally used when we are interested in the minimum and
 *         maximum values. and if we need to search random values in our
 *         structure, so heap is not the right choice.
 */
class Heap {
	private int[] heap;
	private int size;

	public Heap(int capacity) {
		heap = new int[capacity];
	}

	public boolean isFull() {
		return size == heap.length;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getParent(int index) {	//this function returns the index of the parent, not the parent itself.
		return (index - 1) / 2; // we are using integer here, so we done have to say floor((index-1)/2)
	}

	public void insert(int value) {
		if (isFull()) {
			throw new IndexOutOfBoundsException("The heap is full");
		}
		heap[size] = value; // newly inserted values are added at the end of the array of the heap, and then
							// the fixHeapAbove(size) is used to heapify the heap.
		fixHeapAbove(size);
		size++;
	}

	private void fixHeapAbove(int index) {
		int newValue = heap[index];
		while (index > 0 && newValue > heap[getParent(index)]) {
			heap[index] = heap[getParent(index)]; // in this line and the line after it, we take the parent node one
													// level down, and update the index of the added value to be the
													// index of the parent node.
			index = getParent(index); // this loop terminates when we either hit the parent node or find the right
										// place of the inserted value.
		}
		heap[index] = newValue; // in this line, the parent node is updated with inserted value.
	}

	public int getChild(int index, boolean left) {// when left is true we want the leftChild, if it is false we want the
													// rightChild. the index of rightChild is 2*i+2, and of the leftChild
													// is 2*i+1
		return 2 * index + (left ? 1 : 2);
	}

	public int delete(int index) { // we need the index of the value we want to delete. why not the value itself?,
									// because if we provide the value instead, then we will have to search the
									// heap.
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("the heap is empty");

		}
		int parent = getParent(index); // parent of the deleted item.
		int deletedValue = heap[index];
		heap[index] = heap[size - 1]; // we replace the deleted item with the most right node in the heap.
		// now if the value in the heap[index] is greater than its parents, we will have
		// to fix the heap above.
		// but if the value in the heap[index] is less than its parents, we will have to
		// fix the heap below.

		if (index == 0 || heap[index] < heap[parent]) {
			fixHeapBelow(index, size - 1);
		} else {
			fixHeapAbove(index);
		}
		size--;

		return deletedValue;
	}

	private void fixHeapBelow(int index, int lastHeapIndex) { // lastHeapIndex is not needed for the fixBelow function,
																// but we will need it later in order to sort the heap.
		int childToSwap; // index of the child to be swaped.

		while (index <= lastHeapIndex) {
			int leftChild = getChild(index, true);
			int rightChild = getChild(index, false);
			if (leftChild <= lastHeapIndex) { // if this condition is fulfilled, it has a leftChild
				if (rightChild > lastHeapIndex) { // if this condition is fulfilled, it has not a rightChild
					childToSwap = leftChild;
				} else { // else here means that the heap[index] has two children.
					childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
				}

				if (heap[index] < heap[childToSwap]) {
					int temp = heap[index];
					heap[index] = heap[childToSwap];
					heap[childToSwap] = temp;
				} else { // here means that the replaced value is greater or equal to its child or
							// children, and we do not have to do anything more.
					break;
				}
				index = childToSwap; // we get to this step if the loop has not been broken. i.e. when no replacement
										// has taken place we go further with
										// the heapifying by setting the index of the replacement to the index of its
										// child or children.
			} else { // reaching here means that the replaced node has neither left nor right child.
				break;
			}
		}
	}

	public int peak() { // this function get the root node.
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("heap is empty");
		}
		return heap[0];
	}

	public void printHeap() {
		for (int i = 0; i < size; i++) {
			System.out.print(heap[i] + " , ");
		}
		System.out.println();
	}
}

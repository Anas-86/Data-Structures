package heap_training;

class Heap {
	private int[] heap;
	private int size;

	public Heap(int capacity) {
		heap = new int[capacity];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == heap.length;
	}

	public int getParent(int index) {
		return (index - 1) / 2;
	}

	public int getChild(int index, boolean left) {
		return (2 * index) + (left ? 1 : 2);
	}

	public void insert(int value) {
		if (isFull()) {
			throw new IndexOutOfBoundsException("the heap is full");
		}
		heap[size] = value;
		fixHeapAbove(size);
		size++;

	}

	public void fixHeapAbove(int index) {
		int value = heap[index];

		while (index > 0 && value > heap[getParent(index)]) {
			heap[index] = heap[getParent(index)];
			index = getParent(index);
		}
		heap[index] = value;
	}

	public int delete(int index) {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("the heap is empty");
		}
		int deletedValue = heap[index];
		heap[index] = heap[size - 1];
		if (index == 0 || heap[index] < heap[getParent(index)]) {
			fixHeapBelow(index, size - 1);
		} else {
			fixHeapAbove(index);
		}
		size--;
		return deletedValue;
	}

	public void fixHeapBelow(int index, int lastHeapIndex) {
		int childToSwap;
		while (index <= lastHeapIndex) {
			int rightChild = getChild(index, false);
			int leftChild = getChild(index, true);
			if (heap[leftChild] <= lastHeapIndex) {
				if (heap[rightChild] > lastHeapIndex) {
					childToSwap = leftChild;
				} else {
					childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
				}

				if (heap[index] < heap[childToSwap]) {
					int temp = heap[index];
					heap[index] = heap[childToSwap];
					heap[childToSwap] = temp;
				} else {
					break;
				}
				index = childToSwap;
			} else {
				break;
			}
		}
	}

	public int peak() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("the heap is empty");
		}
		return heap[0];
	}

	public void printHeap() {
		for (int e : heap) {
			System.out.println(e + " , ");
		}
		System.out.println();
	}

}

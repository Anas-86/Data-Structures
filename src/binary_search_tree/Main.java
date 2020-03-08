package binary_search_tree;

class Main {
	public static void main(String[] args) {

		Tree intTree = new Tree();
		intTree.insert(25);
		intTree.insert(20);
		intTree.insert(15);
		intTree.insert(27);
		intTree.insert(30);
		intTree.insert(29);
		intTree.insert(26);
		intTree.insert(22);
		intTree.insert(32);
		
		System.out.println("Traversing in Order");
		intTree.traverseInOrder();
		System.out.println();
		System.out.println("Traversing pre order");
		intTree.traversePreOrder();
		System.out.println(); 
		System.out.println("Traversing post order");
		intTree.traversePostOrder();
		System.out.println();
		System.out.println("Searching for values");
		System.out.println(intTree.get(13));
		System.out.println(intTree.get(22));
		System.out.println(intTree.get(100));
		System.out.println();
		System.out.println("searching for the minimum :");
		System.out.println(intTree.min());
		System.out.println();
		System.out.println("searching for the maximum :");
		System.out.println(intTree.max());
		
		System.out.println();
		System.out.println("deleting nodes: ");
		System.out.println("before deletion:");
		intTree.traverseInOrder();
		intTree.delete(27);
		System.out.println("\nafter deletion: ");
		intTree.traverseInOrder();
	}
}

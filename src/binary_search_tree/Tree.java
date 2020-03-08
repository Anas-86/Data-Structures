package binary_search_tree;

class Tree {
	private TreeNode root;

	public void insert(int value) {
		if (root == null) {
			root = new TreeNode(value);
		} else {
			root.insert(value);
		}
	}

	public void delete(int value) {
		root = delete(root, value); // recursive method
	}

	private TreeNode delete(TreeNode subtreeRoot, int value) { // this method returns the replacement node. and if the
																// node does not have to be replaced, the same node is
																// going to be returned.
		if (subtreeRoot == null) { // handles the case that the tree is empty.
			return subtreeRoot; // you could also return null.
		}
		if (value < subtreeRoot.getData()) {
			subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
		} else if (value > subtreeRoot.getData()) {
			subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));
		} else { // in else here we get the case that subtreeRoot.getData() is equal to value.
					// i.e. we have found the node that we want to delete, and it is the
					// subtreeRoot.
					// this block deals the cases that the node to be deleted has 0 or 1 children.
			if (subtreeRoot.getLeftChild() == null) {
				return subtreeRoot.getRightChild();
			} else if (subtreeRoot.getRightChild() == null) {
				return subtreeRoot.getLeftChild();
			} else {
				// here we handle the case that the node to be deleted has two children.

				// replace the value in the subrteeRoot node with the smallest value from the
				// right subtree
				subtreeRoot.setData(subtreeRoot.getRightChild().min());

				// delete the node that has the smallest value for the right subtree
				subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData()));
			}

		}
		return subtreeRoot; // this substitutes the subtreeRoot with itself when it has no child.
	}

	public void traverseInOrder() {
		if (root != null) {
			root.traverseInOrder();
		}
	}

	public void traversePreOrder() {
		if (root != null) {
			root.traversePreOrder();
		}
	}

	public void traversePostOrder() {
		if (root != null) {
			root.traversePostOrder();
		}
	}

	public TreeNode get(int value) {
		if (root != null) {
			return root.get(value);
		}
		return null;
	}

	public int min() {
		if (root != null) {
			return root.min();
		}
		return Integer.MIN_VALUE;		//when the tree is empty, MIN_VALUE is returnred
	}

	public int max() {
		if (root != null) {
			return root.max();

		}
		return Integer.MAX_VALUE;		//when the tree is empty, MAX_VALUE is returnred
	}
}

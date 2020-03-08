package binary_search_tree;

class TreeNode {
	private int data;
	private TreeNode leftChild;
	private TreeNode rightChild;

	public TreeNode(int data) {
		super();
		this.data = data;
	}

	//getters and setters
	public int getData() {
		return data;
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}

	public void insert(int value) {
		if (value == data) {
			return;
		}

		if (value < data) {
			if (leftChild == null) {
				leftChild = new TreeNode(value);
			} else {
				leftChild.insert(value);
			}
		} else {
			if (rightChild == null) {
				rightChild = new TreeNode(value);
			} else {
				rightChild.insert(value);
			}
		}
	}

	public void traverseInOrder() {
		if (leftChild != null) {
			leftChild.traverseInOrder();
		}
		System.out.print(data + " , ");
		if (rightChild != null) {
			rightChild.traverseInOrder();
		}
	}

	public void traversePreOrder() {
		if (this != null) {
			System.out.print(data + " , ");

		}
		if (leftChild != null) {
			leftChild.traversePreOrder();
		}
		if (rightChild != null) {
			rightChild.traversePreOrder();
		}
	}

	public void traversePostOrder() {
		if (leftChild != null) {
			leftChild.traversePostOrder();
		}
		if (rightChild != null) {
			rightChild.traversePostOrder();
		}
		System.out.print(data + " , ");
	}

	public TreeNode get(int value) {
		if(value==data) {
			return this;
		}
		else if(value<data) {
			if(leftChild!=null) {
				return leftChild.get(value);
			}
		}
		else if(rightChild!=null){
			if(rightChild!=null) {
				return rightChild.get(value);
			}
		}
		return null;
	}
	
	public int min() {
		if(leftChild!=null) {
			return leftChild.min();
		}
		return data;
	}
	
	public int max() {
		if(rightChild!=null) {
			return rightChild.max();
		}
		return data;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Data = "+data;
	}
	

	
}

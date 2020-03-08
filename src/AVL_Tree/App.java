package AVL_Tree;

public class App {

	public static void main(String[] args) {

		Tree avl = new AvlTree();

		int [] array={30,20,40,10,5,3,4,50,60,70,65};
		for(int e:array)
			avl.insert(e);


		
		avl.traverse();
		System.out.println();

	}
	
}

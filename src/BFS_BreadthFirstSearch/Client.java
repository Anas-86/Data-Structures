package BFS_BreadthFirstSearch;

import java.io.File;

public class Client {
    public static void main(String[] args) throws Exception{
        File file = new File("D:\\DataStructuresAndAlgorithmsCourse\\src\\Uebung6_Exercise1\\TextFile.txt");
        Graph graph=new Graph().createGraph(file,new AdjacencyMatrix());
        System.out.println("adjacency Matrix: ");
        System.out.println("------------------");
        graph.print();

        System.out.println();

        Graph graph2=new Graph().createGraph(file,new AdjacencyList());
        System.out.println("adjacency List: ");
        System.out.println("------------------");
        graph2.print();
    }
}

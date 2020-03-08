package BFS_BreadthFirstSearch;

public class AdjacencyList implements AdjacencyStructure {
    @Override

    public void print(int[] vertices, int[] edges) {
        for (int i = 0; i < vertices.length; i++) {
            System.out.print(vertices[i] + "\t-->\t");
            for (int j = 0; j < edges.length - 2; j = j + 3)
                if (vertices[i] == edges[j]) {
                    System.out.print("[" + edges[j + 1] + "," + edges[j + 2] + "]\t");
                }
            System.out.println();
        }

    }
}

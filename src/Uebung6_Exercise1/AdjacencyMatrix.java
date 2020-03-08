package Uebung6_Exercise1;

public class AdjacencyMatrix implements AdjacencyStructure {
    @Override

        public void print(int[] vertices, int[] edges) {
            Integer[][] array = new Integer[vertices.length + 1][vertices.length + 1];

            //initializing the array with null, in order to make vertices without edges as null
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = null;
                }
            }

            for(int i=0;i<vertices.length;i++){
                array[0][i+1]=vertices[i];
                array[i+1][0]=vertices[i];
            }

            int i=0;
            while(i<edges.length){
                array[edges[i]][edges[i+1]]=edges[i+2];     //because the vertices' names beginn from 1 and not from 0, we had to subtract 1 in order not to have ArrayIndexOutOfBoundsException
                i+=3;
            }

            System.out.print("     \t\t");
            for(i=1;i<array.length;i++){
                System.out.printf("%5d\t\t",array[0][i]);
            }
            System.out.println();
            for (i = 1; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    System.out.printf("%5d\t\t",array[i][j]);
                }
                System.out.println();
            }

        }

}

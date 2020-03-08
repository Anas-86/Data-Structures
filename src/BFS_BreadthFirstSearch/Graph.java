package BFS_BreadthFirstSearch;

/**
 * @ Anas Al Kala
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Graph {
    private AdjacencyStructure adStructure;
    private int[] verticesArray;
    private int[] edgesArray;

    public Graph createGraph(File file, AdjacencyStructure adStructure) throws IncompatibilityException, IncompatibleFileException {

        this.adStructure = adStructure;

        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder builder = new StringBuilder();
        while (sc.hasNextLine())
            builder.append(sc.nextLine());

        String str = builder.toString();

        if (checkFileValidity(str)) {
            this.verticesArray = extractValues(str, "[v|V]=\\{(\\d)(\\,\\d)*\\}");
            this.edgesArray = extractValues(str, "[e|E]=\\{(\\[\\d+\\,\\d+\\,\\d+\\])(\\,(\\[\\d+\\,\\d+\\,\\d+\\]))*\\}");
            if (checkCompatibility(verticesArray, edgesArray)) {
                System.out.println("the vertices and edges have been checked for compatibility and ready for printing");
            } else {
                throw new IncompatibilityException("the vertices are not compatible with the edges");
            }
        } else {
            throw new IncompatibleFileException("the file does not hold the convention of custom vertices and edges.");
        }
        return this;
    }


    public static boolean checkFileValidity(String str) {
        if (testingE(str) && testingV(str))
            return true;
        return false;
    }

    public void print() {
        adStructure.print(verticesArray, edgesArray);
    }

    private static boolean testingV(String str) {
        //return str.matches("V=\\{\\d(,\\d)*}");
        return str.matches(".*[v|V]=\\{(\\d)(\\,\\d)*\\}.*");
    }


    private static boolean testingE(String str) {
        //return str.matches E={[1,2,10],[2,1,10],[2,3,30],[3,1,50]}
        return str.matches(".*[e|E]=\\{(\\[\\d+\\,\\d+\\,\\d+\\])(\\,(\\[\\d+\\,\\d+\\,\\d+\\]))*\\}.*");
    }

    private static int[] extractValues(String str, String pat) {
        String s = null;
        Pattern pattern = Pattern.compile(pat);
        Matcher match = pattern.matcher(str);
        if (match.find())
            s = match.group();

        int count = 0;
        Pattern pattern1 = Pattern.compile("\\d+");
        Matcher matcher = pattern1.matcher(s);
        while (matcher.find())
            count++;

        int[] array = new int[count];
        matcher.reset();
        int i = 0;
        while (matcher.find()) {
            array[i++] = Integer.parseInt(matcher.group());
        }
        return array;
    }

    //this method checks if the matrix of edges is compatible with the matrix of vertices
    public static boolean checkCompatibility(int[] vertices, int[] edges) {
        ArrayList<Integer> verticesList = new ArrayList<>();
        for (int e : vertices)
            verticesList.add(e);

        int i = 0;
        boolean f = true;
        while (f && i < edges.length) {
            if ((!verticesList.contains(edges[i]) || !verticesList.contains(edges[++i]))) {
                f = false;
            } else {
                i += 2;        //for skipping the length between the vertices.
            }
        }
        return f;
    }

}

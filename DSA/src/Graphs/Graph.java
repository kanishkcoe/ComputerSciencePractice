package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    int nodeCount;
    ArrayList<LinkedList> adjacencyList;
    int [][] adjacencyMatrix;

    public Graph(int nodeCount) {
        this.nodeCount = nodeCount;
        //List
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < nodeCount; i++) {
            adjacencyList.add(new LinkedList<Integer>());
        }

        //Matrix
        adjacencyMatrix = new int[nodeCount][];
        for (int i = 0; i < nodeCount; i++) {
            adjacencyMatrix[i] = new int[nodeCount];
        }
    }

    void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);

        adjacencyMatrix[source][destination] = 1;
        adjacencyMatrix[destination][source] = 1;


        System.out.println("-------------------------------------------");
        System.out.println("edge added (" + source + ", " + destination + ")");
        System.out.println("edge added (" + destination + ", " + source + ")");
        System.out.println("-------------------------------------------");
    }

    void printAdjacencyList() {
        System.out.println("Adjacency List");
        System.out.println("-------------------------------------------");
        for (int i = 0; i < nodeCount; i++) {
            System.out.println(i + " -> " + adjacencyList.get(i));
        }
        System.out.println("-------------------------------------------");
    }


    void printAdjacencyMatrix() {
        System.out.println("Adjacency Matrix");
        System.out.println("-------------------------------------------");
        for (int i = 1; i < nodeCount; i++) {
            for (int j = 1; j < nodeCount; j++) {
                System.out.print(adjacencyMatrix[i][j] + ", ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------");
    }
}

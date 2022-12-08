package Graphs;

import java.util.*;

public class Graph {
    int nodeCount;
    ArrayList<LinkedList<Integer>> adjacencyList;
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


    ArrayList<Integer> breadthFirstSearch(int source) {
        //use Queue data structure
        ArrayList<Boolean> visited = new ArrayList<>();
        ArrayList<Integer> sequence = new ArrayList<>();
        for (int i = 0; i < nodeCount; i++) {
            visited.add(false);
        }

        Queue<Integer> queue = new LinkedList<>();

        int current = source;
        queue.offer(current);
        visited.set(current, true);
        while(!queue.isEmpty()) {
            current = queue.poll();
            sequence.add(current);
            for(Integer neighbour: adjacencyList.get(current)) {
                if(!visited.get(neighbour)) {
                    visited.set(neighbour, true);
                    queue.offer(neighbour);
                }
            }
        }

        return sequence;
    }

    ArrayList<Integer> depthFirstSearch(int source) {
        //use Stack data structure
        ArrayList<Boolean> visited = new ArrayList<>();
        ArrayList<Integer> sequence = new ArrayList<>();
        for (int i = 0; i < nodeCount; i++) {
            visited.add(false);
        }

        Stack<Integer> stack = new Stack<>();

        int current = source;
        stack.push(current);
        visited.set(current, true);
        while(!stack.isEmpty()) {
            current = stack.pop();
            sequence.add(current);
            for(Integer neighbour: adjacencyList.get(current)) {
                if(!visited.get(neighbour)) {
                    visited.set(neighbour, true);
                    stack.push(neighbour);
                }
            }
        }

        return sequence;
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

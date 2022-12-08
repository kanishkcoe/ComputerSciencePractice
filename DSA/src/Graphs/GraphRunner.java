package Graphs;

import java.util.Scanner;

public class GraphRunner {

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        Scanner scanner = new Scanner(System.in);

        String reset = "n";

        do {
            System.out.println("Enter source : ");
            int source = scanner.nextInt();
            System.out.println("Enter destination : ");
            int destination = scanner.nextInt();

            graph.addEdge(source, destination);

            System.out.println("Would you like to add more edges ? (y/n)");
            reset = scanner.next();
        } while (reset.equalsIgnoreCase("y"));

        graph.printAdjacencyMatrix();
        graph.printAdjacencyList();

        System.out.println("DFS of the graph is : " + graph.depthFirstSearch(1));
        System.out.println("BFS of the graph is : " + graph.breadthFirstSearch(1));
    }
}

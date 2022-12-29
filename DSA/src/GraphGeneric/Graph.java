package GraphGeneric;

import java.util.*;

class Node {
    String data;

    @Override
    public String toString() {
        return data;
    }

    public Node(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return data.equals(node.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}

class Edge {
    Node source;
    Node destination;

    public Edge(Node source, Node destination) {
        this.source = source;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "(" + source + ", " + destination + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return source.equals(edge.source) && destination.equals(edge.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination);
    }
}

public class Graph {

    Map<Node, List<Node>> adjacencyList;
    Map<Edge, Integer> cost;

    public Graph() {
        adjacencyList = new HashMap<>();
        cost = new HashMap<>();
    }

    public void addEdge(String sourceString, String destinationString, Integer weight) {
        Node source = new Node(sourceString);
        Node destination = new Node(destinationString);

        if(adjacencyList.containsKey(source)) {
            adjacencyList.get(source).add(destination);
        } else {
            adjacencyList.put(source, new LinkedList<>());
            adjacencyList.get(source).add(destination);
        }

        Edge edge = new Edge(source, destination);
        cost.put(edge, weight);
    }

    public void addBidirectionalEdge(String sourceString, String destinationString, Integer weight) {
        addEdge(sourceString, destinationString, weight);
        addEdge(destinationString, sourceString, weight);
    }

    List<Node> breadthFirstSearch(Node source) {
        Set<Node> visited = new HashSet<>();

        Queue<Node> queue = new LinkedList<>();

        List<Node> result = new LinkedList<>();

        queue.offer(source);
        visited.add(source);
        result.add(source);

        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if(!visited.contains(currentNode)) {
                visited.add(currentNode);
                result.add(currentNode);
            }

            for(Node neighbour : adjacencyList.get(currentNode)) {
                if(!visited.contains(neighbour)) {
                    queue.offer(neighbour);
                }
            }
        }

        return result;
    }

    List<Node> depthFirstSearch(Node source) {
        Set<Node> visited = new HashSet<>();

        Stack<Node> stack = new Stack<>();

        List<Node> result = new LinkedList<>();

        stack.push(source);
        visited.add(source);
        result.add(source);

        while(!stack.isEmpty()) {
            Node currentNode = stack.pop();
            if(!visited.contains(currentNode)) {
                visited.add(currentNode);
                result.add(currentNode);
            }

            for(Node neighbour : adjacencyList.get(currentNode)) {
                if(!visited.contains(neighbour)) {
                    stack.push(neighbour);
                }
            }
        }

        return result;
    }

    void printAdjacencyList() {
        for (Map.Entry<Node, List<Node>> entry : adjacencyList.entrySet()) {
            Node key = entry.getKey();
            StringBuilder valueString = new StringBuilder();
            for (Node value : entry.getValue()) {
                valueString.append(value).append("(").append(cost.get(new Edge(key, value))).append("), ");
            }
            System.out.println(key + " -> " + valueString);
        }
    }

    void printCostList() {
        for (Map.Entry<Edge, Integer> entry : cost.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}

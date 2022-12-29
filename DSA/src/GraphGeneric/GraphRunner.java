package GraphGeneric;

public class GraphRunner {

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addBidirectionalEdge("rithala", "rohini west", 5);
        graph.addBidirectionalEdge("rohini west", "rohini east", 10);
        graph.addBidirectionalEdge("rohini east", "rohini sector 18", 15);
        graph.addBidirectionalEdge("rohini east", "peeragadhi", 25);
        graph.addBidirectionalEdge("rohini east", "keshav puram", 20);
        graph.addBidirectionalEdge("keshav puram", "pulbangash", 15);
        graph.addBidirectionalEdge("pulbangash", "karol bagh", 10);
        graph.addBidirectionalEdge("peeragadhi", "pashchim vihar west", 5);
        graph.addBidirectionalEdge("pashchim vihar west", "pashchim vihar east", 10);
        graph.addBidirectionalEdge("pashchim vihar east", "karol bagh", 10);

        graph.printAdjacencyList();

    }

}

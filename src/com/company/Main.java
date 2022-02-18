package com.company;

public class Main {

    public static void main(String[] args) {
        DirectedGraph directedGraph = new DirectedGraph();
        directedGraph.addNode("Houston");
        directedGraph.addNode("Las Vegas");
        directedGraph.addNode("Seattle");
        directedGraph.addNode("Portland");
        directedGraph.addNode("JFK");
        directedGraph.addEdge("Houston", "Seattle");
        directedGraph.addEdge("Houston", "Las Vegas");
        directedGraph.addEdge("Seattle", "Portland");
        directedGraph.addEdge("Portland", "JFK");
        directedGraph.traverseDepthFirst("Houston");
    }


}

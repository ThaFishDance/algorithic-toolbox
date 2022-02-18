package com.company;

import java.util.*;

public class DirectedGraph {
    private class Node {
        String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to){
        var fromNode = nodes.get(from);
        if (fromNode == null) throw new IllegalArgumentException();
        var toNode = nodes.get(to);
        if (toNode == null) throw new IllegalArgumentException();

        // Directed Graph from -> to
        adjacencyList.get(fromNode).add(toNode);
    }

    public void removeEdge(){

    }

    public Node removeNode(){ return null; }

    public void traverseDepthFirst(String root){
        var node = nodes.get(root);
        traverseDepthFirst(node, new HashSet<>());
    }

    private void traverseDepthFirst(Node root, HashSet<Node> visited){
        System.out.println(root);
        visited.add(root);
        for( var node: adjacencyList.get(root)){
            if (!visited.contains(node)){
                traverseDepthFirst(node, visited);
            }
        }
    }

    public void print(){
        for(var source: adjacencyList.keySet()){
            var targets = adjacencyList.get(source);
            if(!targets.isEmpty()){
                System.out.println(source + " is connected to " + targets);
            }
        }
    }

}

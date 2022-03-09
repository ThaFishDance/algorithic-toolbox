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

    private void traverseDepthFirst(Node root, Set<Node> visited){
        System.out.println(root);
        visited.add(root);
        for( var node: adjacencyList.get(root)){
            if (!visited.contains(node)){
                traverseDepthFirst(node, visited);
            }
        }

    }

    public List<String> topologicalSort(){
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        for(var node: nodes.values()){
            topologicalSort(node, stack, visited);
        }

        List<String> sorted = new ArrayList<>();
        while(!stack.isEmpty()){
            sorted.add(stack.pop().label);
        }
        return sorted;
    }

    private void topologicalSort(Node node, Stack<Node> stack, Set<Node> visited) {
        if(visited.contains(node)) return;

        // add to visited
        visited.add(node);

        // go through all neighbors until no more neighbors exist
        for(var neighbor: adjacencyList.get(node)){
            topologicalSort(neighbor, stack, visited);
        }

        // add to stack
        stack.push(node);
    }

    public boolean hasCycle() {
        // three sets: all, visiting, visited
        Set<Node> all = new HashSet<>();
        all.addAll(nodes.values());

        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();

        while(!all.isEmpty()){
            // go through all nodes
            var current = all.toArray()[0];
        }
        return false;
    }

    private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting,
                             Set<Node> visited){
        all.remove(node);
        visiting.add(node);
        return false;
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

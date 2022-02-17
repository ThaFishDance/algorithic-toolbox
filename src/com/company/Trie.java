package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {

    private class TrieNode {
        char value;
        private HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord;

        public TrieNode(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }

        // hasChild -> boolean
        public boolean hasChild(Character ch) {
            return children.containsKey(ch);
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        // addChild -> void
        public void addChild(Character ch) {
            children.put(ch, new TrieNode(ch));
        }

        public TrieNode getChild(char ch) {
            return children.get(ch);
        }

        public TrieNode[] getChildren() {
            return children.values().toArray(new TrieNode[0]);
        }

        public void removeChild(char ch) {
            children.remove(ch);
        }
    }

    private final TrieNode root = new TrieNode(' ');

    public void insert(String word) {
        TrieNode current = root;
        for (var ch : word.toCharArray()) {
            if (!current.hasChild(ch)) {
                current.addChild(ch);
            }
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String word) {
        if (word == null) return false;

        var current = root;
        for (var ch : word.toCharArray()) {
            if (!current.hasChild(ch)) {
                return false;
            }
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public void preTraverse() {
        preTraverse(root);
    }

    private void preTraverse(TrieNode node) {
        System.out.println(node.value);
        for (var child : node.getChildren()) {
            preTraverse(child);
        }
    }

    public void postTraverse() {
        postTraverse(root);
    }

    private void postTraverse(TrieNode node) {
        for (var child : node.getChildren()) {
            postTraverse(child);
        }
        System.out.println(node.value);
    }

    public void delete(String word) {
        if (word == null) return;
        delete(root, word, 0);
    }

    private void delete(TrieNode node, String word, int index) {

        if (index == word.length()) {
            node.isEndOfWord = false;
            // cannot remove node from trie on itself.
            // Need to remove while on parent
            return;
        }
        char ch = word.charAt(index);
        TrieNode child = node.getChild(ch);
        if (child == null) return;
        delete(child, word, index + 1);
        // on parent, can remove child
        // if parent does not have other children or not endOfWord, you can remove child.
        if (!child.hasChildren() && !child.isEndOfWord) {
            root.removeChild(ch);
        }

    }

    public List<String> findWords(String prefix){
        if (prefix == null || prefix.length() < 3) return null;
        List<String> words = new ArrayList<String>();
        var lastNode = findLastNodeOf(prefix);
        findWords(lastNode, prefix, words);

        // may want to sort word as they are coming in to reduce time
        return words;
    }

    private void findWords(TrieNode root, String prefix, List<String> words){
        if (root == null) return;
        if(root.isEndOfWord){
            words.add(prefix);
        }
        for( var child: root.getChildren()){
            findWords(child, prefix + child.value, words);
        }
    }

    private TrieNode findLastNodeOf(String prefix){
        var current = root;
        for(var ch: prefix.toCharArray()){
            var child = current.getChild(ch);
            if(child == null) return null;
            current = child;
        }
        return current;
    }
}

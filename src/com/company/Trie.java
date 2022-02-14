package com.company;

import java.util.HashMap;

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

        // addChild -> void
        public void addChild(Character ch) {
            children.put(ch, new TrieNode(ch));
        }

        public TrieNode getChild(char ch) {
            return children.get(ch);
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

    public boolean contains(String word){
        if(word == null) return false;

        var current = root;
        for(var ch: word.toCharArray()){
            if(!current.hasChild(ch)){
                return false;
            }
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }
}

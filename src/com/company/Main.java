package com.company;

public class Main {

    public static void main(String[] args) {

        var trie = new Trie();
        trie.insert("car");
        trie.insert("care");
        trie.delete("car");
        trie.contains("car");
        System.out.println("Done");
    }
}

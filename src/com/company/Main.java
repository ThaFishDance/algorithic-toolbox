package com.company;

public class Main {

    public static void main(String[] args) {

        var trie = new Trie();
        trie.insert("cat");
        System.out.println();
        System.out.println(trie.contains("cat"));
        System.out.println("Done");
    }
}

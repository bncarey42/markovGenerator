package com.bncarey42;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws Exception {
        String corpus = "";
        int order = 2;
        Graph g = new Graph();

        String path = "/home/ben/git/markovGenerator/src/com/bncarey42/names.txt";
        try(Stream<String> stream = Files.lines(Paths.get(path))) {
            corpus = stream.collect(Collectors.joining(" "));
        }

        for(int i=0; i < corpus.length() - order; i++) {
            String gram = corpus.substring(i, i+order);
            g.addEdge(gram, Character.toString(corpus.charAt(i + order)));
        }

        // print the graph.
        //System.out.println("Graph:\n" + g);

        String currentGram = corpus.substring(0, order);
        StringBuilder result = new StringBuilder().append(currentGram);

        for (var i = 0; i < 1500; i++) {
            List<String> possible = g.getEdges(currentGram);
            String next =  possible.get(new Random().nextInt(possible.size()));
            result.append(next);
            int len = result.length();
            currentGram = result.substring(len - order, len);
        }

        System.out.println(result);
    }
}


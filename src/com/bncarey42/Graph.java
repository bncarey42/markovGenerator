package com.bncarey42;

import com.bncarey42.markov.Edge;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {

    private Map<String, List<String>> graph;

    public Graph(String[] vertecies) {
        this.graph = new HashMap<>();
        for(String vertex: vertecies) {
            this.graph.put(vertex, new LinkedList<>());
        }
    }

    public Graph() {
        this.graph = new HashMap<>();
    }

    public void addEdge(String source, String destination) {
        if(!this.graph.containsKey(source))
            addVertex(source);

        if(!this.graph.containsKey(destination))
            addVertex(destination);

        //TODO this is messy find a better way
        this.graph.get(source).add(destination);
        /*Map<String, Integer> src = this.graph.get(source);
        src.put(destination, src.containsKey(destination) ? src.get(destination)+1: 1);*/
    }

    public void addVertex(String s) {
        this.graph.put(s, new LinkedList<>());
    }

    public List<String> getEdges(String vertex) {
        return this.graph.get(vertex);
    }

    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        for (String v : this.graph.keySet()) {
            builder.append(v).append("-> ");
            //for (String w : this.graph.get(v).keySet()) {
            for (String w : this.graph.get(v)) {
                //builder.append(w).append(":").append((double) this.graph.get(v).get(w)/this.graph.get(v).keySet().size()).append(" ");
                builder.append(w).append(" ");
            }
            builder.append("\n");
        }

        return (builder.toString());
    }
}

package com.test.graphs.impl;

import com.test.Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GraphImpl<T> implements Graph<T> {

    private Map<T, List<T>> map;

    public GraphImpl() {
        this.map = new HashMap<>();
    }

    @Override
    public void addEdge(T source, T destination) {
        if(!map.containsKey(source))
            addVertex(source);

        if(!map.containsKey(destination))
            addVertex(destination);

        map.get(source).add(destination);
    }

    //TODO weighted vertices
    @Override
    public void addVertex(T s) {
        map.put(s, new LinkedList<>());
    }

    @Override
    public int getVertexCount() {
        return map.keySet().size();
    }

    @Override
    public int getEdgesCount() {
        int count = 0;
        for(T key: map.keySet()) {
            count += map.get(key).size();
        }
        return count;
    }

    @Override
    public boolean hasVertex(T s) {
        return map.containsKey(s);
    }

    @Override
    public boolean hasEdge(T s, T d) {
        return map.get(s).contains(d);
    }

    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        for (T v : map.keySet()) {
            builder.append(v.toString() + ": ");
            for (T w : map.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }

        return (builder.toString());
    }
}

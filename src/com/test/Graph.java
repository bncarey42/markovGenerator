package com.test;

public interface Graph<T> {
    //TODO should have weighted edges
    void addEdge(T source, T destination);
    void addVertex(T s);
    int getVertexCount();
    int getEdgesCount();
    boolean hasVertex(T s);
    boolean hasEdge(T s, T d);
}

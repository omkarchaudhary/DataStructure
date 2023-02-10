package datastructure;

import java.util.LinkedList;

public class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        // TODO Auto-generated constructor stub
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        System.out.println(g1.toString());
    }
}

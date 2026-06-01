package SigmaBatchDSA.ClassProblems.GraphsPart5;

import java.util.ArrayList;
import java.util.Collections;

public class KruskalsAlgorithm {
    static int n = 7; // Number of vertices
    static int[] parent = new int[n];
    static int[] rank = new int[n];

    // Edge class with Comparable for sorting by weight
    static class Edge implements Comparable<Edge> {
        int src, dest, wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge other) {
            return this.wt - other.wt;
        }
    }

    // Initialize DSU
    public static void init() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Find with path compression
    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union by rank
    public static void union(int x, int y) {
        int parentA = find(x);
        int parentB = find(y);

        if (parentA == parentB) return;

        if (rank[parentA] == rank[parentB]) {
            parent[parentB] = parentA;
            rank[parentA]++;
        } else if (rank[parentA] > rank[parentB]) {
            parent[parentB] = parentA;
        } else {
            parent[parentA] = parentB;
        }
    }

    // Kruskal's MST algorithm
    public static void kruskalsMST(ArrayList<Edge> edges, int V) {
        Collections.sort(edges); // Sort edges by weight O(ElogE)
        int mstCost = 0;
        int count = 0;

        for (int i = 0; count < V - 1 && i < edges.size(); i++) {//O(V)
            Edge e = edges.get(i);
            int parentA = find(e.src);
            int parentB = find(e.dest);

            if (parentA != parentB) {
                union(e.src, e.dest);
                mstCost += e.wt;
                System.out.println("Edge added: (" + e.src + ", " + e.dest + ") with weight " + e.wt);
                count++;
            }
        }

        System.out.println("Total cost of MST: " + mstCost);
    }

    public static void main(String[] args) {
        init();

        // Sample graph edges
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));
        edges.add(new Edge(1, 2, 25));
        edges.add(new Edge(4, 5, 2));
        edges.add(new Edge(5, 6, 3));
        edges.add(new Edge(4, 6, 8));

        kruskalsMST(edges, n);
    }
}
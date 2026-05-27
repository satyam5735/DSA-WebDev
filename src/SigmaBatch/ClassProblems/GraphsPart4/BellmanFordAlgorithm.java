package SigmaBatch.ClassProblems.GraphsPart4;

import java.util.ArrayList;

public class BellmanFordAlgorithm {

    static class Edge {
        int src, dest, wt;
        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    static void createGraph(ArrayList<Edge> graph) {
        graph.add(new Edge(0, 1, 6));
        graph.add(new Edge(0, 2, 7));
        graph.add(new Edge(1, 3, 5));
        graph.add(new Edge(1, 2, 8));
        graph.add(new Edge(1, 4, 3));   // changed from -1 to 3
        graph.add(new Edge(2, 3, 4));   // changed from -3 to 4
        graph.add(new Edge(3, 4, 9));
    }

//    static void createGraph(ArrayList<Edge> graph) {
//        graph.add(new Edge(0, 1, 2));
//        graph.add(new Edge(0, 2, 4));
//        graph.add(new Edge(1, 2, -4));
//        graph.add(new Edge(2, 3, 2));
//        graph.add(new Edge(3, 4, 4));
//        graph.add(new Edge(4, 1, -10));
//    }


    public static void bellmanFord(ArrayList<Edge> graph, int V, int src) {
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        // Relax all edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            for (Edge e : graph) {
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Check for negative weight cycles
        for (Edge e : graph) {
            int u = e.src;
            int v = e.dest;
            int wt = e.wt;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                System.out.println("Negative weight cycle detected");
                return;
            }
        }

        // Print distances
        for (int i = 0; i < V; i++) {
            System.out.println("• \tDistance from " + src + " to " + i + " = " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph = new ArrayList<>();
        createGraph(graph);
        bellmanFord(graph, V, 0);
    }
}
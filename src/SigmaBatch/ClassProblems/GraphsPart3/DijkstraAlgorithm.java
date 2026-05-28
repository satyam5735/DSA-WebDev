package SigmaBatch.ClassProblems.GraphsPart3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static class Pair implements Comparable<Pair> {
        int n;      // node
        int path;   // distance so far

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return Integer.compare(this.path, p2.path); // min-heap by path
        }
    }

    public static void dijkstraAlgorithm(ArrayList<Edge>[] graph, int src) {
        int n = graph.length;
        int[] dist = new int[n];           // dist[i] -> shortest distance src to i
        boolean[] vis = new boolean[n];    // visited set

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            int u = curr.n;

            if (vis[u]) continue;
            vis[u] = true;

            // relax all outgoing edges from u
            for (int i = 0; i < graph[u].size(); i++) {
                Edge e = graph[u].get(i);
                int v = e.dest;
                int wt = e.wt;

                if (!vis[v] && dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    pq.add(new Pair(v, dist[v])); // push neighbor v with updated distance
                }
            }
        }

        // print all source-to-vertex shortest distances
        for (int i = 0; i < n; i++) {
            System.out.print((dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
            if (i + 1 < n) System.out.print(" ");
        }
        System.out.println();
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Sample directed weighted graph (V = 6, nodes 0..5)
        // 0 -> 1 (2), 0 -> 2 (4)
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        // 1 -> 2 (1), 1 -> 3 (7)
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        // 2 -> 4 (3)
        graph[2].add(new Edge(2, 4, 3));

        // 4 -> 3 (2), 4 -> 5 (5)
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

        // 3 -> 5 (1)
        graph[3].add(new Edge(3, 5, 1));
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        int src = 0;
        dijkstraAlgorithm(graph, src); // expected output for sample graph: 0 2 3 8 6 9
    }
}
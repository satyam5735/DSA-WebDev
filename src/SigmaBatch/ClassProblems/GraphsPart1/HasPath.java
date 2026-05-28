package SigmaBatch.ClassProblems.GraphsPart1;

import java.util.ArrayList;

public class HasPath {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 - vertex
        graph[0].add(new Edge(0, 1, 5));

        // 1 - vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // 2 - vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 4));

        // 3 - vertex
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // 4 - vertex
        graph[4].add(new Edge(4, 2, 2));

        // Optional: Connect vertex 5 and 6 to test hasPath(0, 6)
        graph[2].add(new Edge(2, 5, 1));
        graph[5].add(new Edge(5, 6, 1));
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
        if (src == dest) {
            return true;
        }

        vis[src] = true;

        for (int i = 0; i < graph[src].size(); i++) {
            Edge edge = graph[src].get(i);
            if (!vis[edge.dest] && hasPath(graph, edge.dest, dest, vis)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        System.out.println(hasPath(graph, 0, 6, new boolean[V])); // Should print true if 0->2->5->6 exists
    }
}
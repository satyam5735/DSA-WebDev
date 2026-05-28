package SigmaBatch.ClassProblems.GraphsPart2;

import java.util.ArrayList;

public class CycleDetection {
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

        graph[0].add(new Edge(0, 1, 5));
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 4));
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));
        graph[4].add(new Edge(4, 2, 2));
    }

    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUntil(graph, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUntil(ArrayList<Edge> graph[], boolean vis[], int curr, int par) {
        vis[curr] = true;

        for (Edge e : graph[curr]) {
            if (!vis[e.dest]) {
                if (detectCycleUntil(graph, vis, e.dest, curr)) {
                    return true;
                }
            } else if (e.dest != par) {
                return true; // cycle detected
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        System.out.println("Cycle Detected: " + detectCycle(graph));
    }
}
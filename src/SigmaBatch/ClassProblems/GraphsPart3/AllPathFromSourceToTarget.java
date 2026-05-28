package SigmaBatch.ClassProblems.GraphsPart3;

import java.util.ArrayList;

public class AllPathFromSourceToTarget {

    // Edge class to represent a directed edge
    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Recursive method to print all paths from src to dest
    public static void printAllPath(ArrayList<Edge>[] graph, int src, int dest, String path) {
        path += src + " ";

        if (src == dest) {
            System.out.println(path);
            return;
        }

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            printAllPath(graph, e.dest, dest, path);
        }
    }

    // Sample graph creation
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges to the graph
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 1)); // Optional: creates a cycle
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        int src = 5, dest = 1;
        System.out.println("All paths from " + src + " to " + dest + ":");
        printAllPath(graph, src, dest, "");
    }
}

//Also: Optional Enhancement: Cycle Protection
//public static void printAllPath(ArrayList<Edge>[] graph, int src, int dest, String path, boolean[] visited) {
//    if (visited[src]) return;
//
//    visited[src] = true;
//    path += src + " ";
//
//    if (src == dest) {
//        System.out.println(path);
//        visited[src] = false;
//        return;
//    }
//
//    for (Edge e : graph[src]) {
//        printAllPath(graph, e.dest, dest, path, visited);
//    }
//
//    visited[src] = false;
//}
//Then call it with:
//boolean[] visited = new boolean[V];
//printAllPath(graph, src, dest, "", visited);
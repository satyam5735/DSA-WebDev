package SigmaBatchDSA.ClassProblems.GraphsSupplemental;

import java.util.ArrayList;
import java.util.Stack;

public class StronglyConnectedComponents {

    // ---------------------------------------------------------
    // Edge class
    // Represents one directed edge:
    // src --> dest
    // ---------------------------------------------------------
    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }


    // =========================================================
    // STEP 1:
    // Do DFS and store nodes in Stack
    // =========================================================
    public static void topSort(
            ArrayList<Edge> graph[],
            int curr,
            boolean visited[],
            Stack<Integer> stack) {

        // Mark current node as visited
        visited[curr] = true;

        // Visit all neighbours of current node
        for (int i = 0; i < graph[curr].size(); i++) {

            Edge edge = graph[curr].get(i);

            // If neighbour is not visited
            if (!visited[edge.dest]) {

                // Visit that neighbour
                topSort(graph, edge.dest, visited, stack);
            }
        }

        // Put current node into stack
        // AFTER visiting all its neighbours
        stack.push(curr);
    }


    // =========================================================
    // STEP 3:
    // Normal DFS on the TRANSPOSE graph
    // =========================================================
    public static void dfs(
            ArrayList<Edge> graph[],
            int curr,
            boolean visited[]) {

        // Mark current node as visited
        visited[curr] = true;

        // Print the node
        System.out.print(curr + " ");

        // Visit all neighbours
        for (int i = 0; i < graph[curr].size(); i++) {

            Edge edge = graph[curr].get(i);

            // If neighbour is not visited
            if (!visited[edge.dest]) {

                dfs(graph, edge.dest, visited);
            }
        }
    }


    // =========================================================
    // KOSARAJU'S ALGORITHM
    // =========================================================
    public static void kosaraju(
            ArrayList<Edge> graph[],
            int V) {


        // =====================================================
        // STEP 1: Get nodes in Stack
        // =====================================================

        Stack<Integer> stack = new Stack<>();

        boolean visited[] = new boolean[V];

        // Run DFS for every node
        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                topSort(graph, i, visited, stack);
            }
        }


        // =====================================================
        // STEP 2: Create Transpose Graph
        //
        // Original:
        // A --> B
        //
        // Transpose:
        // A <-- B
        // =====================================================

        ArrayList<Edge> transpose[] = new ArrayList[V];

        // Create empty ArrayList for every vertex
        for (int i = 0; i < V; i++) {

            transpose[i] = new ArrayList<>();

            // Reset visited array
            visited[i] = false;
        }


        // Reverse every edge
        for (int i = 0; i < V; i++) {

            for (int j = 0; j < graph[i].size(); j++) {

                Edge edge = graph[i].get(j);

                // Original:
                // edge.src --> edge.dest
                //
                // Transpose:
                // edge.dest --> edge.src

                transpose[edge.dest].add(
                        new Edge(edge.dest, edge.src)
                );
            }
        }


        // =====================================================
        // STEP 3:
        // Pop nodes from Stack and do DFS on Transpose
        // =====================================================

        while (!stack.isEmpty()) {

            // Get top node from stack
            int curr = stack.pop();

            // If not already visited
            if (!visited[curr]) {

                System.out.print("Strongly Connected Component: ");

                // DFS on TRANSPOSE graph
                dfs(transpose, curr, visited);

                System.out.println();
            }
        }
    }


    // =========================================================
    // MAIN METHOD
    // =========================================================
    public static void main(String[] args) {

        int V = 5;

        // Create graph
        ArrayList<Edge> graph[] = new ArrayList[V];

        // Create ArrayList for every vertex
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }


        // -----------------------------------------------------
        // Add edges
        //
        // Based on your diagram:
        //
        // 1 --> 0
        // 2 --> 1
        // 2 --> 0
        // 0 --> 3
        // 3 --> 4
        // -----------------------------------------------------

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 0));

        graph[0].add(new Edge(0, 3));

        graph[3].add(new Edge(3, 4));


        // Run Kosaraju's Algorithm
        kosaraju(graph, V);
    }
}
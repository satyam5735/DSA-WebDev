package SigmaBatchDSA.ClassProblems.GraphsPart5;
import java.util.*;

public class ConnectingCities {
    static class Edge implements Comparable<Edge> {
        int dest;
        int cost;

        public Edge(int d, int c) {
            this.dest = d;
            this.cost = c;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.cost - e2.cost;
        }
    }

    public static int connectingCities(int[][] cities) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[cities.length];

        pq.add(new Edge(0, 0));
        int finalCost = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.remove();
            if (!vis[curr.dest]) {
                vis[curr.dest] = true;
                finalCost += curr.cost;

                for (int i = 0; i < cities[curr.dest].length; i++) {
                    if (!vis[i] && cities[curr.dest][i] != 0) {
                        pq.add(new Edge(i, cities[curr.dest][i]));
                    }
                }
            }
        }

        return finalCost;
    }
    //TC: O(V^2) prims algorithm
    public static void main(String[] args) {
        int[][] cities = {
                {0, 1, 2, 0},
                {1, 0, 1, 3},
                {2, 1, 0, 1},
                {0, 3, 1, 0}
        };

        int cost = connectingCities(cities);
        System.out.println("Minimum cost to connect all cities: " + cost);
    }
}
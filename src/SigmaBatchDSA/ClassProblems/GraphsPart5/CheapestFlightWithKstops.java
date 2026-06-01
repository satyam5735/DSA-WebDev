package SigmaBatchDSA.ClassProblems.GraphsPart5;

import java.util.*;

public class CheapestFlightWithKstops {

    static class Edge {
        int src, dest, wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(int[][] flights, ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] flight : flights) {
            int src = flight[0];
            int dest = flight[1];
            int wt = flight[2];
            graph[src].add(new Edge(src, dest, wt));
        }
    }

    static class Info {
        int v;
        int cost;
        int stops;

        public Info(int v, int cost, int stops) {
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(flights, graph);

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info rem = q.remove();
            if (rem.stops > k) continue;

            for (Edge e : graph[rem.v]) {
                int v = e.dest;
                int wt = e.wt;

                if (rem.cost + wt < dist[v]) { //curr -> rem
                    dist[v] = rem.cost + wt;
                    q.add(new Info(v, dist[v], rem.stops + 1));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0;
        int dst = 2;
        int k = 1;

        int result = findCheapestPrice(n, flights, src, dst, k);
        System.out.println("Cheapest price from " + src + " to " + dst + " with at most " + k + " stops: " + result);
    }
}
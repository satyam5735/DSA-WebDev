package SigmaBatch.ClassProblems.GraphsPart5;
import java.util.*;

public class DisjointSetUnion {
    static int n = 7;
    static int[] parent = new int[n];
    static int[] rank = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];
    }

    public static void union(int x, int y) {
        int parentA = find(x);
        int parentB = find(y);

        if (parentA == parentB) return; // already in same set

        if (rank[parentA] == rank[parentB]) {
            parent[parentB] = parentA;
            rank[parentA]++;
        } else if (rank[parentA] > rank[parentB]) {
            parent[parentB] = parentA;
        } else {
            parent[parentA] = parentB;
        }
    }

    public static void main(String[] args) {
        init();
        System.out.println(find(3));
        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1, 5);
    }
}
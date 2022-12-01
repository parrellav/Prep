package com.parrella.graphs;

import java.util.*;

public class ShortestPath {

    public static int shortestPath(List<List<Integer>> graph, int root, int target) {
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(root);
        visited.add(root);
        int level = 0;
        while(dq.size() > 0) {
            int n = dq.size();
            for (int i = 0; i < n; i++) {
                int node = dq.pop();
                if (node == target) return level;
                for (int neighbour : graph.get(node)) {
                    if (visited.contains(neighbour)) continue;
                    dq.add(neighbour);
                    visited.add(neighbour);
                }
            }
            level++;
        }

        return level;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = List.of(
                List.of(1, 2),
                List.of(0, 2, 3),
                List.of(0, 1),
                List.of(1)
        );
        System.out.println(shortestPath(graph, 0, 3));
    }
}

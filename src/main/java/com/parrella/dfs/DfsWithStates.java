package com.parrella.dfs;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DfsWithStates {

    public static class Node<T> {
        public T val;
        public List<Node<T>> children;

        public Node(T val) {
            this(val, new ArrayList<>());
        }

        public Node(T val, List<Node<T>> children) {
            this.val = val;
            this.children = children;
        }
    }


    public static void dfs(Node<Integer> root, List<String> path, List<String> res) {
        if (root.children.isEmpty()) {
            path.add(Integer.toString(root.val));
            res.add(String.join("->", path));
        }
        for (Node<Integer> child : root.children) {
            if (null != child) {
                ArrayList<String> myCopy = new ArrayList<>(path);
                myCopy.add(Integer.toString(root.val));
                dfs(child, myCopy, res);
            }
        }
    }

    public static List<String> ternaryTreePaths(Node<Integer> root) {
        List<String> res = new ArrayList<>();
        if (root != null) dfs(root, new ArrayList<String>(), res);
        return res;
    }

    // this function builds a tree from input; you don't have to modify it
    // learn more about how trees are encoded in https://algo.monster/problems/serializing_tree
    public static <T> Node<T> buildTree(Iterator<String> iter, Function<String, T> f) {
        String val = iter.next();
        int num = Integer.parseInt(iter.next());
        ArrayList<Node<T>> children = new ArrayList<>();
        for (int i = 0; i < num; i++)
            children.add(buildTree(iter, f));
        return new Node<T>(f.apply(val), children);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node<Integer> root = buildTree(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
        scanner.close();
        List<String> res = ternaryTreePaths(root);
        for (String line : res) {
            System.out.println(line);
        }
    }
}

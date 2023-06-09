import java.util.*;

public class DisjointSet<T> {
    private Map<T, Node<T>> map;

    private static class Node<T> {
        T data;
        Node<T> parent;
        int rank;

        Node(T data) {
            this.data = data;
            this.parent = this;
            this.rank = 0;
        }
    }

    public DisjointSet() {
        map = new HashMap<>();
    }

    public void makeSet(T data) {
        Node<T> node = new Node<>(data);
        map.put(data, node);
    }

    public T findSet(T data) {
        Node<T> node = map.get(data);
        if (node == null) {
            return null;
        }
        return findSet(node).data;
    }

    private Node<T> findSet(Node<T> node) {
        if (node != node.parent) {
            node.parent = findSet(node.parent); // równoważenie wysokości
        }
        return node.parent;
    }

    public void union(T data1, T data2) {
        Node<T> parent1 = map.get(findSet(data1));
        Node<T> parent2 = map.get(findSet(data2));

        if (parent1 == null || parent2 == null || parent1 == parent2) {
            return;
        }

        if (parent1.rank > parent2.rank) {
            parent2.parent = parent1;
        } else if (parent1.rank < parent2.rank) {
            parent1.parent = parent2;
        } else {
            parent2.parent = parent1;
            parent1.rank++;
        }
    }

    public void printSets() {
        Map<Node<T>, List<T>> setTrees = new HashMap<>();
        for (T data : map.keySet()) {
            Node<T> node = map.get(data);
            Node<T> parent = findSet(node);

            List<T> tree = setTrees.getOrDefault(parent, new ArrayList<>());
            tree.add(node.data);
            setTrees.put(parent, tree);
        }

        for (Node<T> parent : setTrees.keySet()) {
            List<T> tree = setTrees.get(parent);
            displaySetTree(parent.data, tree, 0);
        }
    }

    private void displaySetTree(T data, List<T> tree, int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append("  ");
        }
        sb.append(data);
        System.out.println(sb.toString());

        for (T child : tree) {
            displaySetTree(child, new ArrayList<>(), indent + 1);
        }
    }

    public void display() {
        System.out.println("Disjoint Sets:");
        for (T data : map.keySet()) {
            T parentData = findSet(data);
            System.out.println(data + " -> " + parentData);
        }
    }
}

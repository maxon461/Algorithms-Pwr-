import java.util.*;

class Edge implements Comparable<Edge> {
    int source, destination, weight;

    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }
}

class Graph {
    int V, E;
    Edge[] edges;

    Graph(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
        for (int i = 0; i < e; ++i)
            edges[i] = new Edge();
    }

    int find(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    void kruskalMST() {
        Edge[] result = new Edge[V];
        int e = 0;
        int i = 0;
        Arrays.sort(edges);

        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        while (e < V - 1) {
            Edge nextEdge = edges[i++];
            int x = find(parent, nextEdge.source);
            int y = find(parent, nextEdge.destination);

            if (x != y) {
                result[e++] = nextEdge;
                union(parent, x, y);
            }
        }

        System.out.println("Minimalne drzewo rozpinające (Kruskal):");
        for (i = 0; i < e; ++i)
            System.out.println(result[i].source + " -- " + result[i].destination + "  waga: " + result[i].weight);
    }
}

public class App {
    public static void main(String[] args) {
        int V = 4; // liczba wierzchołków
        int E = 5; // liczba krawędzi
        Graph graph = new Graph(V, E);

        // Krawędzie w grafie
        graph.edges[0].source = 0;
        graph.edges[0].destination = 1;
        graph.edges[0].weight = 10;

        graph.edges[1].source = 0;
        graph.edges[1].destination = 2;
        graph.edges[1].weight = 6;

        graph.edges[2].source = 0;
        graph.edges[2].destination = 3;
        graph.edges[2].weight = 5;

        graph.edges[3].source = 1;
        graph.edges[3].destination = 3;
        graph.edges[3].weight = 15;

        graph.edges[4].source = 2;
        graph.edges[4].destination = 3;
        graph.edges[4].weight = 4;

        graph.kruskalMST();
    }
}

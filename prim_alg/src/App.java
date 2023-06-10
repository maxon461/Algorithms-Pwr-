import java.util.*;

class Graph {
    private int V;
    private List<List<Edge>> adj;

    Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
    }

    class Edge {
        int source, destination, weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    void addEdge(int source, int destination, int weight) {
        Edge newEdge = new Edge(source, destination, weight);
        adj.get(source).add(newEdge);
        adj.get(destination).add(newEdge);
    }

    void primMST() {
        boolean[] inMST = new boolean[V];
        Edge[] edgeKey = new Edge[V];
        int[] key = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>(V, Comparator.comparingInt(e -> e.weight));
        key[0] = 0;
        pq.offer(new Edge(-1, 0, 0));

        while (!pq.isEmpty()) {
            Edge minEdge = pq.poll();
            int u = minEdge.destination;

            inMST[u] = true;

            for (Edge e : adj.get(u)) {
                int v = e.destination;
                if (!inMST[v] && e.weight < key[v]) {
                    pq.remove(edgeKey[v]);
                    key[v] = e.weight;
                    edgeKey[v] = e;
                    pq.offer(new Edge(u, v, key[v]));
                }
            }
        }

        System.out.println("Minimalne drzewo rozpinające (Prima):");
        for (int i = 1; i < V; i++)
            System.out.println(edgeKey[i].source + " -- " + edgeKey[i].destination + "  waga: " + edgeKey[i].weight);
    }
}

public class App {
    public static void main(String[] args) {
        int V = 4; // liczba wierzchołków
        Graph graph = new Graph(V);

        // Krawędzie w grafie
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 3, 4);

        graph.primMST();
    }
}

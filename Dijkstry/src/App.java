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
        int destination, weight;

        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    void addEdge(int source, int destination, int weight) {
        Edge newEdge = new Edge(destination, weight);
        adj.get(source).add(newEdge);
    }

    void dijkstra(int source) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(V, Comparator.comparingInt(n -> n.distance));
        pq.offer(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node minNode = pq.poll();
            int u = minNode.vertex;

            for (Edge e : adj.get(u)) {
                int v = e.destination;
                int weight = e.weight;
                int newDistance = dist[u] + weight;
                if (newDistance < dist[v]) {
                    dist[v] = newDistance;
                    pq.offer(new Node(v, newDistance));
                }
            }
        }

        System.out.println("Najkrótsze ścieżki z wierzchołka " + source + ":");
        for (int i = 0; i < V; i++)
            System.out.println("do wierzchołka " + i + ": " + dist[i]);
    }

    class Node {
        int vertex, distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}

public class App {
    public static void main(String[] args) {
        int V = 5; // liczba wierzchołków
        Graph graph = new Graph(V);

        // Krawędzie w grafie
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 4, 5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 4, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 2, 6);
        graph.addEdge(3, 0, 7);
        graph.addEdge(4, 1, 3);
        graph.addEdge(4, 2, 9);
        graph.addEdge(4, 3, 2);

        int source = 0; // wierzchołek startowy
        graph.dijkstra(source);
    }
}

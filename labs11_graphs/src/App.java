public class App {
    public static void main(String[] args) throws Exception {
        // NDMGraph graph = new NDMGraph();
        // graph.inputMatrix();
        // graph.addVertice();
        // graph.connect(5, 2);
        // graph.display();

        // NDAGraph graph = new NDAGraph();
        // graph.inputVertices();
        // graph.display();
        // graph.addVertice();
        // graph.connect(2, 4);
        // graph.display();


        int numVertices = 6;
        Graph graph = new Graph(numVertices);

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        // Perform BFS starting from vertex 0
        System.out.println("BFS traversal:");
        graph.BFS(0);
        System.out.println("DFS traversal:");
        graph.DFS(0);


    }
}

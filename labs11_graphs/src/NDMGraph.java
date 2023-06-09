import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import javax.crypto.AEADBadTagException;

public class NDMGraph {
    Scanner sc = new Scanner(System.in);

    final int MAX_VERTICES = 10;
    final int MIN_VERTICES = 1;

    List<List<Integer>> graph = new ArrayList<>();
    int numVertices;
    // Collection<String> list1 = new ArrayList<>();
    // Vector<Integer> list2 = new Vector<>();

    int getNumberofVertices() {

        System.out.println("Enter the number of vertices (1-" + MAX_VERTICES + "): ");
        numVertices = sc.nextInt();
        return numVertices;

    }

    boolean isValidNumofVertices(int numVertices) {
        return (numVertices > MIN_VERTICES && numVertices < MAX_VERTICES);
    }

    public void inputMatrix() {
        numVertices = getNumberofVertices();
        if (!isValidNumofVertices(numVertices)) {
            System.out.println("Error: Invalid number of vertices");
        }

        System.out.println("Enter the adjency matrix (" + numVertices + "x" + numVertices + "):");
       
        for (int i = 0; i < numVertices; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < numVertices; j++) {
                
                int val = sc.nextInt();
                temp.add(val);

            }
            graph.add(temp);
        }
    }

    public void addVertice() {
        for (List<Integer> list : graph) {
            list.add(0);
        }

        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < numVertices + 1; i++) {
            temp.add(0);
        }
        numVertices++;
        graph.add(temp);
    }

    public void connect(int val1, int val2) {
        val1--;val2--;
        List<Integer> list = graph.get(val1);
        list.set(val2, 1);

        list = graph.get(val2);
        list.set(val1, 1);

    }

    public void display() {
        for (List<Integer> list : graph) {
            System.out.print(list);
            System.out.println();
        }
    }

}

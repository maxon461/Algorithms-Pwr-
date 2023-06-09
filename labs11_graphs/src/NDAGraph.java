import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class NDAGraph {
    Scanner sc = new Scanner(System.in);

    final int MAX_VERTICES = 10;
    final int MIN_VERTICES = 1;

    List<LinkedList<Integer>> graph = new ArrayList<>();
    int numVertices;

    int getNumberofVertices() {

        System.out.println("Enter the number of vertices (1-" + MAX_VERTICES + "): ");
        numVertices = sc.nextInt();
        return numVertices;

    }

    boolean isValidNumofVertices(int numVertices) {
        return (numVertices > MIN_VERTICES && numVertices < MAX_VERTICES);
    }

    public void inputVertices() {
        getNumberofVertices();
        for (int i = 0; i < numVertices; i++) {
            LinkedList<Integer> Tlist = new LinkedList<>();
            System.out.println("How many connection u need for " + (i+1) + " element");
            int temp = sc.nextInt()-1;
            for (int j = 0; j <= temp; j++) {
                int val = sc.nextInt();
                if(j==0){
                    Tlist.addFirst(val);
                }
                else{
                    Tlist.add(val);
                }
            }
            graph.add(Tlist);

        }
    }

    public void addVertice() {
        

        LinkedList<Integer> temp = new LinkedList<>();
        
        numVertices++;
        graph.add(temp);
    }

    public void connect(int val1, int val2) {
        val1--;val2--;
        List<Integer> list = graph.get(val1);
        if(!list.contains(val2+1))
        list.add(val2+1);

        list = graph.get(val2);
        if(!list.contains(val1+1))
        list.add(val1+1);

    }


    public void display() {
        int count = 0;
        for (List<Integer> list : graph) {
            count++;
            System.out.print(count +": "+ list);
            System.out.println();
        }
        System.out.println();

    }
}

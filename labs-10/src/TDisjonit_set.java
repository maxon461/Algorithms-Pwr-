import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

public class TDisjonit_set<T> {

    ArrayList<Node<T>> arr = new ArrayList<>();

    public class Node<T> {
        Node<T> first;
        Node<T> next;
        Node<T> last;
        T data;
        int leng;
    }

    public void makeSet(T val) {
        Node<T> current = new Node<>();
        current.first = current;
        current.last = current;
        current.data = val;
        current.next = null;
        current.leng = 1;
        this.arr.add(current);

    }

    public Node<T> find(T val) {
        for (Node<T> current : arr) {
            if (current.data == val) {
                return current;
            }
        }
        return null;

    }

    public void union(T o1, T o2) {
        Node<T> obj1 = find(o1);
        Node<T> obj2 = find(o2);
        obj1.first.leng += obj2.first.leng;
        obj1.first.last.next = obj2.first;
        obj1.first.last = obj2.first.last;
        obj2.first = obj1.first;
        while (obj2.next != null) {
            obj2 = obj2.next;
            obj2.first = obj1.first;

        }
        // obj1.last = obj2.last;
        refresh(obj1.first);

    }

    public void refresh(Node<T> node) {

        if (node.next != null) {
            node = node.next;
            node.last = null;
            node.leng = 0;

            refresh(node);

        }
    }

    public void TUnion(T o1, T o2) {
        Node<T> obj1 = find(o1);
        Node<T> obj2 = find(o2);
        if (obj1.first.leng < obj2.first.leng) {
            Node<T> temp = obj1;
            obj1 = obj2;
            obj2 = temp;
        }
        obj1.first.leng += obj2.first.leng;
        obj1.first.last.next = obj2.first;
        obj1.first.last = obj2.first.last;
        obj2.first = obj1.first;
        while (obj2.next != null) {
            obj2 = obj2.next;
            obj2.first = obj1.first;

        }
        // obj1.last = obj2.last;
        refresh(obj1.first);
    }
    public void display(){
        ArrayList<Node<T>> used = new ArrayList<>();
        for(Node<T> current : arr){
        current = current.first;
        if(current.next!=null && !used.contains(current)){
        do{
            System.out.print(current.data + "-->");
            used.add(current);
            current=current.next;
        }while(current!=null);
        System.out.println();
            }
        }
    }
}

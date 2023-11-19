import java.util.NoSuchElementException;

public class DoubleLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public DoubleLinkedList() {
        head = null;
        tail = null;
    }

    public void insertFront(T data) {
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertBack(T data) {
        Node<T> newNode = new Node<T>(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertBackList(DoubleLinkedList<T> list) {
        this.tail.next = list.head;
        list.head.prev = this.tail;
        this.tail = list.tail;
    }

    public void insertList(int index, DoubleLinkedList<T> list) {
        Node current = head;
        int res = 0;
        while (res != index - 1) {
            if (current.next != null) {
                current = current.next;
                res++;
            } else {
                throw new NoSuchElementException();
            }
        }
        
        Node temp = current.next;
        current.next = list.head;
        list.tail.next = temp;

    }

    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public boolean remove(T data) {
        Node<T> current = head;
        while (current != null && !current.data.equals(data)) {
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        if (current == head) {
            head = current.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (current == tail) {
            tail = current.prev;
            tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        return true;
    }

    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
}

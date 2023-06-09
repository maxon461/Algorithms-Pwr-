public class Queue {
    private OneWayLinkedList list;
    
    public Queue() {
        list = new LinkedList();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public void clear() {
        list.clear();
    }
    
    public void enqueue(Proces newElement) {
        list.add(newElement);
    }
    
    public Proces dequeue() {
        if (isEmpty()) {
            return null;
        }
        Proces removedElement = list.get_head();
        list.head = list.head.next;
        list.size--;
        return removedElement;
    }
    
    public Proces getFirst() {
        if (isEmpty()) {
            return null;
        }
        return list.get_head();
    }
    
    public void display() {
        list.display();
    }
}

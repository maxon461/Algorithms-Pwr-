public class OneWayLinkedList {
    private Proces head;
    public int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void add(Proces newElement) {
        if (isEmpty()) {
            head = newElement;
        } else {
            Proces current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newElement;
        }
        size++;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("[]");
            return;
        }

        Proces current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.getNumerProcesu());
            current = current.next;
            if (current != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

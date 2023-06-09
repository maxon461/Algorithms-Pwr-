public class LinkedList {
    private Element head;

    public LinkedList() {
        head = null;
    }

    private class Element {
        int key;
        Element next;

        public Element(int key) {
            this.key = key;
            this.next = null;
        }
    }

    public void add(int key) {
        Element newElement = new Element(key);
        if (head == null) {
            head = newElement;
        } else {
            Element current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newElement;
        }
    }

    public void printForward() {
        printForward(head);
    }

    private void printForward(Element element) {
        if (element == null) {
            return;
        }
        System.out.print(element.key + " ");
        printForward(element.next);
    }

    public void printReverse() {
        printReverse(head);
    }

    private void printReverse(Element element) {
        if (element == null) {
            return;
        }
        printReverse(element.next);
        System.out.print(element.key + " ");
    }

    public LinkedList copy() {
        LinkedList newList = new LinkedList();
        copy(head, newList);
        return newList;
    }

    private void copy(Element element, LinkedList newList) {
        if (element == null) {
            return;
        }
        newList.add(element.key);
        copy(element.next, newList);
    }

    public int sum() {
        return sum(head);
    }

    private int sum(Element element) {
        if (element == null) {
            return 0;
        }
        return element.key + sum(element.next);
    }

    public int count() {
        return count(head);
    }

    private int count(Element element) {
        if (element == null) {
            return 0;
        }
        return 1 + count(element.next);
    }
}

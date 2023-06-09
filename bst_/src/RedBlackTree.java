import java.util.LinkedList;
import java.util.Queue;
public class RedBlackTree<T extends Comparable<T>> {

    private Node<T> root;

    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;
        boolean isRed;
        
        Node(T data) {
            this.data = data;
            this.isRed = true;
        }
    }

    public void insert(T data) {
        root = insert(root, data);
        root.isRed = false;
    }

    private Node<T> insert(Node<T> node, T data) {
        if (node == null) {
            return new Node<>(data);
        }
        
        if (data.compareTo(node.data) < 0) {
            node.left = insert(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insert(node.right, data);
        }
        
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }
        
        return node;
    }

    private boolean isRed(Node<T> node) {
        if (node == null) {
            return false;
        }
        return node.isRed;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        newRoot.isRed = node.isRed;
        node.isRed = true;
        return newRoot;
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        newRoot.isRed = node.isRed;
        node.isRed = true;
        return newRoot;
    }

    private void flipColors(Node<T> node) {
        node.isRed = true;
        node.left.isRed = false;
        node.right.isRed = false;
    }

    public Node search(T data) {
        Node<T> current = root;
        while (current != null) {
            int cmp = data.compareTo(current.data);
            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    public void inOrderDisplay() {
        inOrderDisplay(root);
    }

    private void inOrderDisplay(Node<T> node) {
        if (node == null) {
            return;
        }
        inOrderDisplay(node.left);
        System.out.print(node.data + " " + node.isRed + " ");
        inOrderDisplay(node.right);
    }

    public void levelDisplay() {
        if (root == null) {
            return;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.offer(root); // like add method for queue
        int nodesInLevel = 1;
        int maxNodesInLevel = 2;
        int level = 0;
        int maxLevel = getHeight(root);
        int distanceBetweenNodes = (int) Math.pow(2, maxLevel - level - 1);
        for (int i = 0; i < maxLevel; i++) {
            System.out.println();
            printSpaces(distanceBetweenNodes);
            while (nodesInLevel > 0) {
                Node<T> node = queue.poll();
                if (node != null) {
                    System.out.print(node.isRed ? "*"+node.data+"* " : node.data+" ");
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    System.out.print("-- ");
                    queue.offer(null);
                    queue.offer(null);
                }
                printSpaces(2 * distanceBetweenNodes - 1);
                nodesInLevel--;
            }
            level++;
            nodesInLevel = maxNodesInLevel;
            maxNodesInLevel *= 2;
            distanceBetweenNodes = (int) Math.pow(2, maxLevel - level - 1);
        }
        System.out.println();
    }
    
    public int getHeight(){
        int res = getHeight(this.root);
        return res;
    }

    public int getLeftSubHeight(){
        int res = getHeight(this.root.left);
        return res;
    }


    public int getRightSubHeight(){
        int res = getHeight(this.root.right);
        return res;
    }


    public int countElements() {
        return countElements(root);
    }

    public int LeftSubTreeCount(){
        return countElements(this.root.left);

    }

    public int RightSubTreeCount(){
        return countElements(this.root.right);
    }


    
    private int countElements(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + countElements(node.left) + countElements(node.right);
    }

    public int LeftSubElementTreeCount(T key){
       Node cmp =  search(key);
       int res = countElements(cmp.left);
       return res;

    }

    public int RightSubElementTreeCount(T key){
        Node cmp =  search(key);
        int res = countElements(cmp.right);
        return res;
 
     }

     public int LeftSubElementTreeHeight(T key){
        Node cmp = search(key);
        int res = getHeight(cmp.left);
        return res;
     }

     public int RightSubElementTreeHeight(T key){
        Node cmp = search(key);
        int res = getHeight(cmp.right);
        return res;
     }

    private int getHeight(Node<T> node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    private void printSpaces(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
    }
    
}

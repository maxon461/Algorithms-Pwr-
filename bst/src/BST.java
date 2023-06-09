import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.LinkedList;
public class BST {
    public Node root;

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int elem) {
            this.value = elem;
        }
    }

    public BST(int val) {
        this.root = new Node(val);
    }

    public BST() {
        this.root = null;
    }

    public int find(int elem) {
        Node node = search(elem);
        return node.value;
    }

    public Node search(int elem) {
        Node node = this.root;
        while (node != null && node.value != elem) {
            node = node.value < elem ? node.right : node.left;
        }
        return node;
    }

    public void insert(int elem) {
        root = insert(root, elem);
    }

    private Node insert(Node node, int elem) {
        if (node == null) {
            node = new Node(elem);
        } else {
            if (elem < node.value) {
                node.left = insert(node.left, elem);
            } else if (elem > node.value) {
                node.right = insert(node.right, elem);
            } else {
                throw new NoSuchElementException();
            }
        }
        return node;
    }

    public void getMin() {
        if (this.root == null) {
            throw new NoSuchElementException();
        }
        Node node = findMin(this.root);
        System.out.println("Min is :" + node.value);
        
    }

    public Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void getMax() {
        if (this.root == null) {
            throw new NoSuchElementException();
        }
        Node node = findMax(this.root);
        System.out.println("Max is :" + node.value);

        
    }

    public Node findMax(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.value + " ");
            inorder(node.right);
        }
    }

    public void preorder() {
        preorder(root);
    }

    private void preorder(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder() {
        postorder(root);
    }

    private void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.value + " ");
        }
    }

    public void display() {
        if (this.root == null) {
            return;
        }

        int height = getHeight(this.root);
        int width = (int) Math.pow(2, height) - 1;
        Queue<Node> q = new LinkedList<>();
        q.add(this.root);

        for (int i = 0; i < height; i++) {
            int levelWidth = (int) Math.pow(2, i);
            int padding = (width - levelWidth) / 2;
            for (int j = 0; j < padding; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < levelWidth; j++) {
                if (!q.isEmpty()) {
                    Node node = q.remove();
                    if (node != null) {
                        System.out.print(node.value);
                        q.add(node.left);
                        q.add(node.right);
                    } else {
                        System.out.print(" ");
                        q.add(null);
                        q.add(null);
                    }
                } else {
                    System.out.print(" ");
                }
                for (int k = 0; k < padding * 2 + 1; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }

    int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    int countLeaves(Node root) {
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        return countLeaves(root.left) + countLeaves(root.right);
    }

    public Node findSuccessor(int key) {
        Node successor = null;
        Node current = root;
    
        while (current != null) {
            if (current.value > key) {
                successor = current;
                current = current.left;
            } else {
                current = current.right;
            }
        }
    
        return successor;
    }
    
    public Node findPredecessor(int key) {
        Node predecessor = null;
        Node current = root;
    
        while (current != null) {
            if (current.value < key) {
                predecessor = current;
                current = current.right;
            } else {
                current = current.left;
            }
        }
    
        return predecessor;
    }
    
    public void remove(int elem) {
        root = remove(root, elem);
    }
    
    private Node remove(Node node, int elem) {
        if (node == null) {
            throw new NoSuchElementException();
        }
    
        if (elem < node.value) {
            node.left = remove(node.left, elem);
        } else if (elem > node.value) {
            node.right = remove(node.right, elem);
        } else {
            if (node.left == null && node.right == null) {
                node = null;
            } else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            } else {
                Node temp = findMin(node.right);
                node.value = temp.value;
                node.right = remove(node.right, temp.value);
            }
        }
    
        return node;
    }
    
    // metoda wyświetlająca parametry drzewa
    void printTreeParams() {
        System.out.println("Wysokość drzewa: " + (getHeight(root)-1));
        System.out.println("Liczba węzłów drzewa: " + countNodes(root));
        System.out.println("Liczba liści drzewa: " + countLeaves(root));
    }




}

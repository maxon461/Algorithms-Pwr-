public class App {
    public static void main(String[] args) throws Exception {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(2);
        bst.insert(7);
        bst.insert(1);
        bst.insert(3);
        bst.insert(6);
        bst.insert(8);

        System.out.print("Inorder: ");
        bst.inorder();
        System.out.println();

        System.out.print("Preorder: ");
        bst.preorder();
        System.out.println();

        System.out.print("Postorder: ");
        bst.postorder();
        System.out.println();

        bst.display();
        System.out.println();
        System.out.println();

        bst.printTreeParams();

        bst.getMin();
        bst.getMax();
        System.out.println(bst.findPredecessor(3).value);

        System.out.println(bst.findSuccessor(3).value);

        
    }
}

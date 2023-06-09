public class App {
    public static void main(String[] args) throws Exception {

        RedBlackTree<Integer> tree = new RedBlackTree<>();

        tree.insert(50);
        tree.insert(25);
        tree.insert(75);
        tree.insert(10);
        tree.insert(30);
        tree.insert(60);
        tree.insert(80);
        tree.insert(5);
        tree.insert(15);
        tree.insert(27);
        tree.insert(35);
        tree.insert(55);
        tree.insert(65);
        tree.insert(85);
        tree.insert(2);
        tree.insert(7);
        tree.insert(12);
        tree.insert(17);
        tree.insert(22);
        tree.insert(28);
        tree.insert(33);
        tree.insert(40);
        tree.insert(52);
        tree.insert(57);
        tree.insert(62);
        tree.insert(68);
        tree.insert(77);
        tree.insert(82);
        tree.insert(87);

        // tree.insert(20);
        // tree.insert(15);
        // tree.insert(25);
        // tree.insert(10);
        // tree.insert(18);
        // tree.insert(23);
        // tree.insert(28);

        System.out.println("In-order display:");
        tree.inOrderDisplay();

        System.out.println("\nLevel display:");
        tree.levelDisplay();

        System.out.print("\nSearching for 15: ");
        System.out.println(tree.search(15) != null ? "true" : "false");
        System.out.print("Searching for 30: ");
        System.out.println(tree.search(30) != null ? "true" : "false");

        System.out.println("Height is : " + tree.getHeight());
        System.out.println("Left sub tree height: " + tree.getLeftSubHeight());
        System.out.println("Right sub tree hight: " + tree.getRightSubHeight());
        System.out.println("Elements in tree: " + tree.countElements());
        System.out.println("Elements in left sub tree: " + tree.LeftSubTreeCount());
        System.out.println("Elements in right sub tree: " + tree.RightSubTreeCount());
        System.out.println("Elements in left sub tree below 15 : " + tree.LeftSubElementTreeCount(15));
        System.out.println("Elements in right sub tree below 15 : " + tree.RightSubElementTreeCount(15));
        System.out.println("Left sub tree below 15 height is : " + tree.LeftSubElementTreeHeight(15));
        System.out.println("Right sub tree below 15 height is : " + tree.RightSubElementTreeHeight(15));

    }
}

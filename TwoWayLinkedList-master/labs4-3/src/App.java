public class App {
    public static void main(String[] args) throws Exception {
        DoubleLinkedList<String> arr1 = new DoubleLinkedList<>();
        DoubleLinkedList<String> arr2 = new DoubleLinkedList<>();

        arr1.insertBack("HI");
        arr1.insertBack("Hello");
        arr1.insertBack("whats up");
        arr1.insertFront("die");

        arr2.insertBack("1");
        arr2.insertBack("2");
        arr2.insertBack("3");
         // arr1.insertBackList(arr2);

         
        arr1.insertList(4, arr2);


        arr1.display();




    }
}

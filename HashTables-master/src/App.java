public class App {
    public static void main(String[] args) throws Exception {

        DHashTable dtable = new DHashTable(10);
        dtable.put("apple", "A fruit that grows on trees.");
        dtable.put("banana", "A fruit that is yellow and long.");
        dtable.put("cherry", "A fruit that is small and red.");
        dtable.put("date", "A fruit that is sweet and brown.");
        dtable.put("elderberry", "A fruit that is dark purple and used in jams and pies.");

        System.out.println(dtable.get("apple")); // Output: A fruit that grows on trees.
        System.out.println(dtable.get("banana")); // Output: A fruit that is yellow and long.
        System.out.println(dtable.get("cherry")); // Output: A fruit that is small and red.
        System.out.println(dtable.get("date")); // Output: A fruit that is sweet and brown.
        System.out.println(dtable.get("elderberry")); // Output: A fruit that is dark purple and used in jams and pies.
        System.out.println(dtable.get("fig")); // Output: null

        dtable.remove("cherry");

        System.out.println(dtable.containsKey("cherry")); // Output: false
        System.out.println(dtable.size()); // Output: 4
        System.out.println(dtable.isEmpty()); // Output: false

        dtable.dump();

        QHashTable qtable = new QHashTable(10);

        qtable.put("apple", "red");
        qtable.put("banana", "yellow");
        qtable.put("grape", "purple");

        // Retrieve a value from the table
        System.out.println("The color of an apple is " + qtable.get("apple"));

        // Remove a key-value pair from the table
        qtable.remove("banana");

        // Add some more key-value pairs to the table
        qtable.put("orange", "orange");
        qtable.put("kiwi", "brown");

        // Dump all key-value pairs in the table
        System.out.println("Dumping all key-value pairs in the table:");
        qtable.dump();

        HashTable table = new HashTable(10);

        // Add some key-value pairs to the table
        table.put("cat", "meow");
        table.put("dog", "woof");
        table.put("bird", "tweet");
        table.put("snake", "hiss");

        // Retrieve a value from the table
        System.out.println("The sound a dog makes is " + table.get("dog"));

        // Remove a key-value pair from the table
        table.remove("bird");

        // Add some more key-value pairs to the table
        table.put("lion", "roar");
        table.put("elephant", "trumpet");

        // Dump all key-value pairs in the table
        System.out.println("Dumping all key-value pairs in the table:");
        table.dump();

    }
}

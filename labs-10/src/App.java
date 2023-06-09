public class App {
    public static void main(String[] args) throws Exception {
        // TDisjonit_set<String> set = new TDisjonit_set<String>();
        // String str1 = "A";
        // String str2 = "B";
        // String str3 = "C";
        // String str4 = "D";
        // String str5 = "E";
        // String str6 = "F";
        // String str7 = "G";
        // String str8 = "H";
        

        // set.makeSet(str1);
        // set.makeSet(str2);
        // set.makeSet(str3);
        // set.makeSet(str4);
        // set.makeSet(str5);
        // set.makeSet(str6);
        // set.makeSet(str7);
        // set.makeSet(str8);

        // set.union(str3, str8);
        // set.union(str3, str5);
        // set.union(str5, str2);

        // set.union(str6, str7);
        // set.union(str7, str4);

        // set.TUnion(str7, str5);

 
        // set.display();


        //Trees

    DisjointSet<String> disjointSet = new DisjointSet<>();

    // Tworzenie zbiorów
    disjointSet.makeSet("A");
    disjointSet.makeSet("B");
    disjointSet.makeSet("C");
    disjointSet.makeSet("D");

    // Łączenie zbiorów
    disjointSet.union("A", "B");
    disjointSet.union("B", "C");
    disjointSet.union("A", "D");

    // Wyświetlanie zbiorów jako drzewa
    disjointSet.printSets();

    // Wyświetlanie zbiorów jako pary elementów
    disjointSet.display();




    }
}

import java.util.Scanner;


public class App {

    public static void main(String[] args) {
        CircularLinkedList<String> list = new CircularLinkedList<>();

        list.add("Maks");
        list.add("Jedrek");
        list.add("Piotr");
        list.add("Ania");
        list.add("Bartek");
        list.add("Pratek");
        list.add("Michał");
        list.add("Hello");
        list.add("WHATS UP");

        

        list.display();

        Scanner sc = new Scanner(System.in);

        System.out.println("Wpisz co jaka osobe usuwac: ");
        int k = sc.nextInt();
        int res = 0;
        int i = k - 1;
        int a = 0;
        while (list.size > 1 ) {
            list.removePos(i - res);

            a = i - res + k ;

            if (a > list.size) {
                i = a - list.size - 1;
                res = 0;
                
            }
            else{
                i += k;
                res++;
            }

            list.display();

        }

    }
}

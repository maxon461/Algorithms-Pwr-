import javax.print.attribute.standard.Fidelity;

public class App {
    public static void main(String[] args) throws Exception {
        LinkedList arr = new LinkedList();
        arr.add(new Proces(1, 0, 2, 0, 0));
        arr.add(new Proces(2, 1, 6, 0, 0));
        arr.add(new Proces(3, 2, 4, 0, 0));
        arr.add(new Proces(4, 3, 9, 0, 0));
        arr.add(new Proces(5, 6, 12, 0, 0));

        Queue f = new Queue();
        System.out.println(f.waiting_time(arr));
    }
}

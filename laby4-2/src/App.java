import java.util.Scanner;


public class App {

    public static void main(String[] args) {
       ListStack<String> list = new ListStack<>();

       list.push("HI");
       list.push("Hello");
    //    list.pop();

       System.out.println(list.top());

        

    }
}

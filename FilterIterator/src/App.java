import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;


public class App {
    

    public static void main(String[] args) {

        NumberIterator nIterator  = new NumberIterator(30);

        // nIterator.last();
        while(!nIterator.isDone()){
            System.out.println(nIterator.current());
            nIterator.next();
        }
        PrimeNumberIterator numiterator = new PrimeNumberIterator(20);
        while(!numiterator.isDone()){

            System.out.println(numiterator.current());
            numiterator.next();
        }
        


        
        
        
    }
}

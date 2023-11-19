import java.awt.List;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Car[] cars = {
            new Car("Toyota", "Blue", 2010),
            new Car("Honda", "Red", 2015),
            new Car("Ford", "Green", 2012),
            new Car("Chevrolet", "Black", 2018)
        };


        // bubble sort task 1
        for(int i=0;i<cars.length;i++){
            for(int j=0;j<cars.length-1;j++){
                if(Car.yearComparator.compare(cars[j], cars[j+1])>0){
                    Car temp = cars[j];
                    cars[j]=cars[j+1];
                    cars[j+1]=temp;

                }
            }
        }
        System.out.println("Sorted by year:");
        for (Car car : cars) {
            System.out.println(car.getBrand() + " " + car.getColor() + " " + car.getYear());
        }


        //insert sort : 
      

        int n = cars.length;
        for(int i=0;i<n;i++){
            Car temp = cars[i];
            int j=i-1;
            while (j>=0 && (Car.complexComparator.compare(cars[j], temp))>0) {
                cars[j+1] = cars[j];
                j--;
                
            }
            cars[j+1] = temp;
        }

        System.out.println("Sorted by year:");
        for (Car car : cars) {
            System.out.println(car.getBrand() + " " + car.getColor() + " " + car.getYear());
        }

        
        //insert sort
        for(int i=0;i<n;i++){
            int minIndex = i;
            for(int j=i+1;j<n;j++){
                if(Car.compoundComparator.compare(cars[j], cars[minIndex])<0){
                    minIndex = j;
                }
            }
            if(minIndex != i ){
                Car temp = cars[i];
                cars[i] = cars[minIndex];
                cars[minIndex]  = temp;
            }
        }
        System.out.println("Sorted by brand:");
        for (Car car : cars) {
            System.out.println(car.getBrand() + " " + car.getColor() + " " + car.getYear());
        }

    }   
}

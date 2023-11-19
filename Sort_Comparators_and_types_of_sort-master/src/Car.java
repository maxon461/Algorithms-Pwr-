import java.util.Comparator;

import javax.xml.transform.Result;

public class Car implements Comparable<Car> {
    private String brand;
    private String color;
    private int year;

    // 3-args constructor
    public Car(String brand, String color, int year) {
        this.brand = brand;
        this.color = color;
        this.year = year;
    }
    // getters and setters 
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    
    //simple for brands
    @Override
    public String toString() {
        return "Car [brand=" + brand + ", color=" + color + ", year=" + year + "]";
    }


    @Override
    public int compareTo(Car other){
        return this.brand.compareTo(other.brand);
    }

    // simple for colors
    public static Comparator<Car> colorComparator = new Comparator<Car>() {
        @Override
        public int compare(Car car1, Car car2) {
            return car1.color.compareTo(car2.color);
        }
    };
    
    // simple comparator for year
    public static Comparator<Car> yearComparator = new Comparator<Car>() {
        @Override
        public int compare(Car car1, Car car2) {
            return car1.year - car2.year;
        }
    };
    
    public static Comparator<Car> brandComparator = new Comparator<Car>() {
        @Override
        public int compare(Car car1, Car car2) {
            return car1.getBrand().compareTo(car2.getBrand());
        }
    };

    public static Comparator<Car> compoundComparator = brandComparator.thenComparing(yearComparator).thenComparing(colorComparator);
        
    public static Comparator<Car> complexComparator = new Comparator<Car>() {
        @Override 
        public int compare(Car o1 , Car o2){
            int result = yearComparator.compare(o1, o2);
            if(result == 0 ){
                result = colorComparator.compare(o1, o2);
                if(result == 0){
                    result = brandComparator.compare(o1, o2);
                }
            }
            return result;

        }

    };

    };

    
    
    


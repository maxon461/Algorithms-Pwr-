import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.Iterator;



public class App {
    public static void pokaz_po_punktach(StudentArray arr , double value){
        Iterator<Student> iter = arr.iterator();
        while(iter.hasNext()){
            Student s = iter.next();
            if(s.getSr_ocena() == value){
                System.out.println(s.toString());
            }
        }
        
    }

    public static void main(String[] args) {

        Student[] students ;
        students = new Student[3];
        int res = 0;

        try {
            File file = new File("/Users/maxon462/Desktop/java_laboratorium/laby2/text/Studenci.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Scanner lineScanner = new Scanner(line);

                String firstName = lineScanner.next();
                String lastName = lineScanner.next();
                String number = lineScanner.next();
                String fin_number = number.substring(1,number.length()-1);
                double grade1 = lineScanner.nextDouble();
                double grade2 = lineScanner.nextDouble();
                double average_grade = (grade1+grade2)/2;

                Student student = new Student(firstName, lastName, fin_number, average_grade);
                students[res]=student;
                res++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    
        StudentArray studentArray = new StudentArray(students); //USING ARRAYITERATOR
        StudentArray.StudentIterator iterator = studentArray.new StudentIterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student.getNazwisko() + ", " + student.getImie() + ", " + student.getIndeks() + ", " + student.getSr_ocena());
        }
        
        pokaz_po_punktach(studentArray, 3.25);//END OF ARRAYITERATOR 
        

        // Iterator<Student> filteriterator = new FilterIterator(students,
        //         student -> ((Student)student).getSr_ocena() >= 1.0);  


        Iterator<Student> filteriterator = new FilterIterator<>(students, new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return ((Student)student).getSr_ocena() >= 3.5;
            }
        });

        


        while (filteriterator.hasNext()) {
            Student student = filteriterator.next();
            System.out.println(student.getImie() + " " + student.getNazwisko());
        }
    }

    




}
    



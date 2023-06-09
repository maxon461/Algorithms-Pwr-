import java.util.Iterator;

public class StudentArray implements Iterable<Student> {

    private Student[] students;

    public StudentArray(Student[] students) {
        this.students = students;
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentIterator();
    }

    public class StudentIterator implements Iterator<Student> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < students.length;
        }

        @Override
        public Student next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException("No more elements to iterate over.");
            }
            Student student = students[index];
            index++;
            return student;
        }
    }
}

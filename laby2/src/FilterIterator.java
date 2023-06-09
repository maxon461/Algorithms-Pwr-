import java.util.Iterator;
import java.util.function.Predicate;

public class FilterIterator<T> implements Iterator<T> {

    private T[] array;
    private Predicate<T> predicate;
    private int nextIndex;

    public FilterIterator(T[] array, Predicate<T> predicate) {
        this.array = array;
        this.predicate = predicate;
        getNextIndex();
    }

    private void getNextIndex() {
        while (nextIndex < array.length && !predicate.test(array[nextIndex])) {
            nextIndex++;
        }
    }

    @Override
    public boolean hasNext() {
        return nextIndex < array.length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("No more elements to iterate over.");
        }
        T element = array[nextIndex];
        nextIndex++;
        getNextIndex();
        return element;
    }

    // public Predicate<T> generatePredicate(T minValue, T maxValue, Predicate<T> condition) {
    //     return element -> element.compareTo(minValue) >= 0 && element.compareTo(maxValue) <= 0 && condition.test(element);
    // }

}

public class PrimeNumberIterator implements Iterator<Integer> {
    private NumberIterator numberIterator;
    private Predicate<Integer> predicate;
    
    public PrimeNumberIterator(int maxNumber) {
        this.numberIterator = new NumberIterator(maxNumber);
        this.predicate = new Predicate<Integer>();
    }
    
   
    
    public void first() {
        numberIterator.first();
        skipNonPrimes();
    }
    
    public void last() {
        numberIterator.last();
        skipNonPrimesBackwards();
    }
    
    public void next() {
        numberIterator.next();
        skipNonPrimes();
    }
    
    public void previous() {
        numberIterator.previous();
        skipNonPrimesBackwards();
    }
    
    public boolean isDone() {
        return numberIterator.isDone();
    }
    
    public Integer current() {
        return numberIterator.current();
    }
    
    private void skipNonPrimes() {
        while (!isDone() && !predicate.test(current())) {
            numberIterator.next();
        }
    }
    
    private void skipNonPrimesBackwards() {
        while (!isDone() && !predicate.test(current())) {
            numberIterator.previous();
        }
    }
}

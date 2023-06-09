
public class NumberIterator implements Iterator<Integer> {
    private int currentNumber;
    private int maxNumber;
    
    public NumberIterator(int maxNumber) {
        this.currentNumber = 1;
        this.maxNumber = maxNumber;
    }
    
    public void first() {
        currentNumber = 1;
    }
    
    public void last() {
        currentNumber = maxNumber;
    }
    
    public void next() {
        currentNumber++;
    }
    
    public void previous() {
        currentNumber--;
    }
    
    public boolean isDone() {
        return currentNumber < 1 || currentNumber > maxNumber;
    }
    
    public Integer current() {
        if (isDone()) {
            return null;
        }
        return currentNumber;
    }
}

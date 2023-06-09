public class DrowningStack<T> {
    private T[] stack;
    private int top;
    
    public DrowningStack(int capacity) {
        stack = (T[]) new Object[capacity];
        top = 0;
    }
    
    public void push(T item) {
        if (top == stack.length) {
            // stack is full, drown the bottom item
            for (int i = 0; i < top - 1; i++) {
                stack[i] = stack[i+1];
            }
            top--;
        }
        stack[top++] = item;
    }
    
    public T pop() {
        if (top <= 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[--top];
    }
    
    public T peek() {
        if (top <= 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top - 1];
    }
    
    public boolean isEmpty() {
        return top == 0;
    }
    
    public int size() {
        return top;
    }
}

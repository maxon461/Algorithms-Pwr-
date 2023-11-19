public class App {
    public static void main(String[] args) throws Exception {
        DrowningStack<Integer> stack = new DrowningStack<>(5);
    
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Stack size: " + stack.size()); // should print 5
        
        stack.push(6);
        System.out.println("Stack size after adding 6: " + stack.size()); // should still print 5
        
        System.out.println("Popped item: " + stack.pop()); // should print 5
        
        stack.push(7);
        System.out.println("Peeked item: " + stack.peek()); // should print 7
        
        while (!stack.isEmpty()) {
            System.out.println("Popped item: " + stack.pop());
        }
    }
}

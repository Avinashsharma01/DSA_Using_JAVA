package Stack;

import java.util.Stack;

public class MyStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
//        stack.add(10);
//        stack.add(100);
//        stack.add(1000);
//        stack.add(10000);
//        stack.add(100000);
//        stack.add(1000000);
//        stack.add(10);
//        stack.add(150000);
//        stack.add(20000);
//        stack.pop();
//        System.out.println(stack);
//        System.out.println("Is the stack empty? " + stack.isEmpty());

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);

        System.out.println("Stack: " + stack);

        // Peek (see the top element without removing it)
        System.out.println("Top element: " + stack.peek());

        // Pop elements
        System.out.println("Popped: " + stack.pop());
        System.out.println("Stack after pop: " + stack);

        // Check if stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty());

        // Search (position from top, 1-based index)
        System.out.println("Position of 10 from top: " + stack.search(10));

    }
}

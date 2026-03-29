package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
    public static void main(String[] args) {
        // Queue is an interface in Java.
        // LinkedList is a standard implementation of the Queue interface.
        // It provides O(1) time complexity for enqueue (add) and dequeue (remove) operations.
        Queue<Integer> queue = new LinkedList<>();


        int totalQueue = 7;
        for (int i=1; i<=totalQueue; i++){
            queue.add(i);
            System.out.println("Queue no "+ i + " has added into queue");
        }
        System.out.println(queue);
        System.out.println("=========================");

        // Processing (removing) elements from the queue
        // They will be removed in FIFO (First-In-First-Out) order.
        int size = queue.size();
        for (int i=1; i<=size; i++){
            System.out.println("Queue no " + queue.remove() + " work Has Done");
        }

        System.out.println("___________________________");
        System.out.println("Work Done");


        System.out.println("=========Questions==========");
        Queue<Integer> q1 = new LinkedList<>();
        for (int i=1; i<=5; i++){
            // add() inserts elements at the tail of the queue
            q1.add(i);
        }

        // Iterating through the queue without removing elements
        for (int i : q1){
            System.out.println(i);
        }


    }
}

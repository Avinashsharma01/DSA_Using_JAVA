package Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Dqueue {
    public static void main(String[] args) {
        Deque<Integer> dqA = new ArrayDeque<>();
        Deque<Integer> dqL = new LinkedList<>();

        dqA.addFirst(10);
        dqA.addFirst(20);
        dqA.addFirst(30);
        dqA.addFirst(40);
        dqA.addFirst(50);

        System.out.println(dqA);

        dqL.addLast(1);
        dqL.addLast(2);
        dqL.addLast(3);
        dqL.addLast(4);
        dqL.addLast(5);
        System.out.println(dqL);

    }
}

package Queue.again;

class QueueLinkedList {

    // Node class
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front, rear;

    // Constructor
    public QueueLinkedList() {
        front = rear = null;
    }

    /**
     * Add (Enqueue)
     * Inserts an element to the `rear` end of the linked list queue.
     *
     * Time Complexity: O(1) - because we have a reference to the `rear` of the queue.
     * In a singly linked list without a tail pointer, adding to the end would be O(N).
     */
    public void add(int data) {
        Node newNode = new Node(data);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    /**
     * Remove (Dequeue)
     * Retrieves and removes the element from the `front` end of the queue.
     *
     * Time Complexity: O(1) - we just move the `front` pointer to the next element.
     */
    public int remove() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }

        int removedData = front.data;
        front = front.next;

        // If queue becomes empty, reset rear point to null too,
        // to maintain consistency when next adding elements.
        if (front == null) {
            rear = null;
        }

        return removedData;
    }

    /**
     * Peek
     * Returns the value at the `front` without modifying the queue.
     */
    public int peek() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }

        return front.data;
    }

    // Display
    public void display() {
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }

        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method to test
    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList();

        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.print("Queue: ");
        queue.display();

        System.out.println("Peek: " + queue.peek());

        System.out.println("Removed: " + queue.remove());

        System.out.print("Queue after removal: ");
        queue.display();
    }
}
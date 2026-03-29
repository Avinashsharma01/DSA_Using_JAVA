package Queue.again;

public class CircularQueueUsingLinkedList {

    Node head = null;
    Node tail = null;
    int size=0;

    /**
     * Internal Node class specifically for a Circular Linked List.
     */
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Enqueues an element.
     * In a circular linked list queue, the `tail.next` continually points back to `head`.
     *
     * Time Complexity: O(1) constant time since we keep track of the `tail`.
     */
    public boolean add(int data){
        Node newNode = new Node(data);
        if (head == null){
            head= tail= newNode;
            size++;
            tail.next = head;
            return true;
        }

        tail.next = newNode;
        tail=newNode;
        size++;
        tail.next = head;
        return true;
    }

    /**
     * Dequeues an element from the 'front' (the `head`).
     * We must update `tail.next` to point to the new `head` to maintain circularity.
     *
     * Time Complexity: O(1) constant time.
     */
    public int remove(){
        if (isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }

        int removedData  = head.data;

        if (size==1){
            head = tail = null;
            size--;
            return removedData ;
        }else {
            head = head.next;
            tail.next = head; // Restoring circular property
            size--;
        }
        return removedData ;
    }

    public int peek() throws Exception{
        if (isEmpty()){
            throw new Exception("Queue is empty");
        }
        return head.data;
    }

    public void display() throws Exception{
        if (isEmpty()){
            throw new Exception("Queue is empty");
        }

        Node temp = head;


        do{
            System.out.print(temp.data + " -> ");
            temp =temp.next;
        }while (temp != head);
        System.out.print("Back to head");
    }


    public boolean isEmpty(){
        return head == null;
    }

    public int getSize() throws Exception{
        if (isEmpty()){
            throw new Exception("Queue is empty");
        }
        return size;
    }


    public static void main(String[] args) throws Exception {
        CircularQueueUsingLinkedList q = new CircularQueueUsingLinkedList();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);


        System.out.println(q.size);
        q.remove();
        System.out.println(q.size);

        System.out.println(q.peek());

        q.display();


    }

}
